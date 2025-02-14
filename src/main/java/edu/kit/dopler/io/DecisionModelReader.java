/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 * <p>
 * Contributors:
 *    @author Fabian Eger
 *    @author Kevin Feichtinger
 * <p>
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.io;

import edu.kit.dopler.common.DoplerUtils;
import edu.kit.dopler.exceptions.NotSupportedVariabilityTypeException;
import edu.kit.dopler.exceptions.ParserException;
import edu.kit.dopler.io.parser.ConditionParser;
import edu.kit.dopler.io.parser.RulesParser;
import edu.kit.dopler.model.BooleanDecision;
import edu.kit.dopler.model.BooleanLiteralExpression;
import edu.kit.dopler.model.DecisionValueCallExpression;
import edu.kit.dopler.model.Dopler;
import edu.kit.dopler.model.DoubleLiteralExpression;
import edu.kit.dopler.model.Enumeration;
import edu.kit.dopler.model.EnumerationDecision;
import edu.kit.dopler.model.EnumerationLiteral;
import edu.kit.dopler.model.GreatherThan;
import edu.kit.dopler.model.IDecision;
import edu.kit.dopler.model.IExpression;
import edu.kit.dopler.model.LessThan;
import edu.kit.dopler.model.NumberDecision;
import edu.kit.dopler.model.Rule;
import edu.kit.dopler.model.StringDecision;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class DecisionModelReader {

    private static final String CARDINALITY_NOT_SUPPORTED_ERROR = "Cardinality %s not supported for decision";
    private static final Pattern SPLIT_PATTERN = Pattern.compile("\"?if ");

    public Dopler read(Path path) throws IOException, NotSupportedVariabilityTypeException {
        Objects.requireNonNull(path);
        Dopler dm = new Dopler();
        dm.setName(path.getFileName().toString());
        CSVFormat dmFormat = CSVUtils.createCSVFormat(true);

        Supplier<Reader> readerSupplier = () -> {
            try {
                return new FileReader(path.toFile(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        return createModelWithReader(readerSupplier, dmFormat, dm);
    }

    public Dopler read(String model, String modelName) throws IOException, NotSupportedVariabilityTypeException {
        Objects.requireNonNull(model);
        Dopler dm = new Dopler();
        dm.setName(modelName);
        CSVFormat dmFormat = CSVUtils.createCSVFormat(true);
        Supplier<Reader> readerSupplier = () -> new StringReader(model);
        return createModelWithReader(readerSupplier, dmFormat, dm);
    }

    private Dopler createModelWithReader(Supplier<Reader> readerSupplier, CSVFormat dmFormat, Dopler dm)
            throws IOException, NotSupportedVariabilityTypeException {

        //First read
        try (Reader in = readerSupplier.get()) {
            Iterable<CSVRecord> records = dmFormat.parse(in);
            for (CSVRecord record : records) {

                String descriptionString = "";
                String id = record.get(CSVHeader.ID).trim();
                String typeString = record.get(CSVHeader.TYPE.toString()).trim();
                String questionString = record.get(CSVHeader.QUESTION.toString()).trim();

                if (id.isBlank() || typeString.isBlank() || questionString.isBlank()) {
                    throw new AssertionError();
                }

                IDecision<?> decision;
                switch (typeString) {
                    case "Boolean" -> decision = new BooleanDecision(id, questionString, descriptionString,
                            new BooleanLiteralExpression(true), new HashSet<>());
                    case "Enumeration" ->
                            decision = deriveEnumerationDecision(dm, record, id, descriptionString, questionString);
                    case "Double" -> {
                        String rangeString = record.get(CSVHeader.RANGE.toString());
                        Set<IExpression> validityConditions = new HashSet<>();
                        decision = new NumberDecision(id, questionString, descriptionString,
                                new BooleanLiteralExpression(true), new HashSet<>(), validityConditions);
                        if (!rangeString.isBlank()) {
                            validityConditions = deriveNumberValidityConditions(rangeString, decision);
                            NumberDecision numberDecision = (NumberDecision) decision;
                            numberDecision.setValidityConditions(validityConditions);
                        }
                    }
                    case "String" -> {
                        Set<IExpression> validityConditions;
                        validityConditions = new HashSet<>();
                        decision = new StringDecision(id, questionString, descriptionString,
                                new BooleanLiteralExpression(true), new HashSet<>(), validityConditions);
                    }
                    default -> throw new NotSupportedVariabilityTypeException(typeString);
                }
                dm.addDecision(decision);
            }
        }

        //Second read
        try (Reader in = readerSupplier.get()) {
            Iterable<CSVRecord> secondParse = dmFormat.parse(in);
            ConditionParser conditionParser = new ConditionParser(dm);
            RulesParser rulesParser = new RulesParser(dm);

            for (CSVRecord record : secondParse) {
                IDecision<?> decision = DoplerUtils.getDecision(dm, record.get(CSVHeader.ID));

                String csvRules = record.get(CSVHeader.RULES.toString());
                if (!csvRules.isEmpty()) {
                    // TODO: Find better way to spit the string of rules (decision names may have
                    // "if" as part of their names)
                    String[] csvRuleSplit = Arrays.stream(SPLIT_PATTERN.split(csvRules)).map(String::trim)
                            .filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
                    Set<Rule> rules = rulesParser.parse(decision, csvRuleSplit);
                    rules.forEach(decision::addRule);
                }

                String visibilityString = record.get(CSVHeader.VISIBLITY.toString());
                IExpression visibilityExpression = conditionParser.parse(visibilityString);
                decision.setVisibilityCondition(visibilityExpression);
            }
        } catch (ParserException e) {
            throw new RuntimeException(e);
        }

        return dm;
    }

    private Set<IExpression> deriveNumberValidityConditions(String rangeString, IDecision<?> decision) {
        String[] options =
                Arrays.stream(rangeString.split("-")).map(String::trim).filter(s -> !s.isEmpty() && !s.isBlank())
                        .toArray(String[]::new);

        if (2 != options.length) {
            throw new AssertionError();
        }

        Set<IExpression> validityConditions = new HashSet<>();
        validityConditions.add(new GreatherThan(new DoubleLiteralExpression(Double.parseDouble(options[0])),
                new DecisionValueCallExpression(decision)));
        validityConditions.add(new LessThan(new DoubleLiteralExpression(Double.parseDouble(options[1])),
                new DecisionValueCallExpression(decision)));
        return validityConditions;
    }

    private IDecision<?> deriveEnumerationDecision(Dopler dm, CSVRecord record, String id, String descriptionString,
                                                   String questionString) throws NotSupportedVariabilityTypeException {
        String rangeString = record.get(CSVHeader.RANGE.toString()).trim();
        String[] options =
                Arrays.stream(rangeString.split("\\|")).map(String::trim).filter(s -> !s.isEmpty() && !s.isBlank())
                        .toArray(String[]::new);

        if (0 == options.length) {
            throw new AssertionError();
        }

        Enumeration enumeration = new Enumeration(new HashSet<>());
        for (String o : options) {
            enumeration.addEnumLiteral(new EnumerationLiteral(o));
        }
        String cardinality = record.get(CSVHeader.CARDINALITY.toString()).trim();

        if (cardinality.isBlank()) {
            throw new AssertionError();
        }

        String[] values =
                Arrays.stream(cardinality.split(":")).map(String::trim).filter(s -> !s.isEmpty() && !s.isBlank())
                        .toArray(String[]::new);
        if (2 != values.length) {
            throw new NotSupportedVariabilityTypeException(String.format(CARDINALITY_NOT_SUPPORTED_ERROR, cardinality));
        }
        int min = Integer.parseInt(values[0]);
        int max = Integer.parseInt(values[1]);
        dm.addEnum(enumeration);
        return new EnumerationDecision(id, questionString, descriptionString, new BooleanLiteralExpression(true),
                new HashSet<>(), enumeration, min, max);
    }
}