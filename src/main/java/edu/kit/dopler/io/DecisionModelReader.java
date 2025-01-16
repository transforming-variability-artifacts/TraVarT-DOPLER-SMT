/*******************************************************************************
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 * 	@author Fabian Eger
 * 	@author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

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

public class DecisionModelReader {

	public static final String FILE_EXTENSION_CSV = ".csv";

	private static final String CARDINALITY_NOT_SUPPORTED_ERROR = "Cardinality %s not supported for decision of type %s";

	public Dopler read(final Path path) throws IOException, NotSupportedVariabilityTypeException {
		Objects.requireNonNull(path);
		final Dopler dm = new Dopler();
		dm.setName(path.getFileName().toString());
		final CSVFormat dmFormat = CSVUtils.createCSVReadFormat();

		try (Reader in = new FileReader(path.toFile(), StandardCharsets.UTF_8)) {
			final Iterable<CSVRecord> records = dmFormat.parse(in);
			for (final CSVRecord record : records) {
				final String descriptionString = "";
				final String id = record.get(CSVHeader.ID).trim();
				assert !id.isBlank();
				final String typeString = record.get(CSVHeader.TYPE.toString()).trim();
				assert !typeString.isBlank();
				final String questionString = record.get(CSVHeader.QUESTION.toString()).trim();
				assert !questionString.isBlank();

				IDecision<?> decision = null;
				switch (typeString) {
				case "Boolean":
					decision = new BooleanDecision(id, questionString, descriptionString,
							new BooleanLiteralExpression(true), new HashSet<>());
					break;
				case "Enumeration":
					decision = deriveEnumerationDecision(dm, record, id, descriptionString, questionString, decision);
					break;
				case "Double":
					String rangeString = record.get(CSVHeader.RANGE.toString());
					Set<IExpression> validityConditions = new HashSet<>();
					decision = new NumberDecision(id, questionString, descriptionString, new BooleanLiteralExpression(true), new HashSet<>(), validityConditions);
					if (!rangeString.isBlank()) {
						validityConditions = deriveNumberValidityConditions(rangeString, decision);
						final NumberDecision numberDecision = (NumberDecision) decision;
						numberDecision.setValidityConditions(validityConditions);
					}
					break;
				case "String":
					rangeString = record.get(CSVHeader.RANGE.toString());
					validityConditions = new HashSet<>();
					decision = new StringDecision(id, questionString, descriptionString, new BooleanLiteralExpression(true),
							new HashSet<>(), validityConditions);
					break;
				default:
					throw new NotSupportedVariabilityTypeException(typeString);
				}
				dm.addDecision(decision);
			}
		}

		try (Reader secondIn = new FileReader(path.toFile(), StandardCharsets.UTF_8)) {
			final Iterable<CSVRecord> secondParse = dmFormat.parse(secondIn);
			final ConditionParser vParser = new ConditionParser(dm);
			final RulesParser rParser = new RulesParser(dm);

			for (final CSVRecord record : secondParse) {
				final String id = record.get(CSVHeader.ID);

				final IDecision decision = DoplerUtils.getDecision(dm,id);
				assert decision != null;
				final String csvRules = record.get(CSVHeader.RULES.toString());
				if (!csvRules.isEmpty()) {
					// TODO: Find better way to spit the string of rules (decision names may have
					// "if" as part of their names)
					final String[] CSVruleSplit = Arrays.stream(csvRules.split("if")).map(String::trim)
							.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
					final Set<Rule> rules = rParser.parse(decision, CSVruleSplit);
					rules.forEach(decision::addRule);
				}

				final String visiblity = record.get(CSVHeader.VISIBLITY.toString());
				final IExpression v = vParser.parse(visiblity);
				decision.setVisibilityCondition(v);
			}
		} catch (final ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dm;
	}

	private Set<IExpression> deriveNumberValidityConditions(final String rangeString, final IDecision decision) {
		final String[] options = Arrays.stream(rangeString.split("-")).map(String::trim)
				.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
		assert options.length == 2;
		final Set<IExpression> validityconditions = new HashSet<>();
		validityconditions.add(new GreatherThan(new DoubleLiteralExpression(Double.parseDouble(options[0])),new DecisionValueCallExpression(decision)));
		validityconditions.add(new LessThan(new DoubleLiteralExpression(Double.parseDouble(options[1])),new DecisionValueCallExpression(decision)));
		return validityconditions;

	}

	private IDecision deriveEnumerationDecision(final Dopler dm, final CSVRecord record, final String id, final String descriptionString, final String questionString,
			IDecision decision) throws NotSupportedVariabilityTypeException {
		final String rangeString = record.get(CSVHeader.RANGE.toString()).trim();
		final String[] options = Arrays.stream(rangeString.split("\\|")).map(String::trim)
				.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
		assert options.length > 0;
		final Enumeration enumeration = new Enumeration(new HashSet<>());
		for (final String o : options) {
			enumeration.addEnumLiteral(new EnumerationLiteral(o));
		}
		final String cardinality = record.get(CSVHeader.CARDINALITY.toString()).trim();
		assert !cardinality.isBlank();
		final String[] values = Arrays.stream(cardinality.split(":")).map(String::trim)
				.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
		if (values.length != 2) {
			throw new NotSupportedVariabilityTypeException(String.format(CARDINALITY_NOT_SUPPORTED_ERROR, cardinality,
					decision.getClass().getCanonicalName()));
		}
		final int min = Integer.parseInt(values[0]);
		final int max = Integer.parseInt(values[1]);
		decision = new EnumerationDecision(id, questionString, descriptionString, new BooleanLiteralExpression(true),
				new HashSet<>(), enumeration, min, max);
		dm.addEnum(enumeration);
		return decision;
	}
}
