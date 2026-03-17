/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 *    @author Fabian Eger
 *    @author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.common;

import edu.kit.dopler.io.DoplerModelWriter;
import edu.kit.dopler.io.antlr.DoplerDecisionCreator;
import edu.kit.dopler.io.antlr.DoplerExpressionParser;
import edu.kit.dopler.io.antlr.resources.DoplerLexer;
import edu.kit.dopler.io.antlr.resources.DoplerParser;
import edu.kit.dopler.model.*;
import edu.kit.dopler.model.Decision.DecisionType;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public final class DoplerUtils {

    private DoplerUtils() {
    }


    static void writeDoplerToFile(Dopler dopler, String fileName) throws IOException {
        // Write Dopler Model in csv and json
        DoplerModelWriter dmw = new DoplerModelWriter();
        dmw.writeCSV(dopler, Paths.get("output_dm_dopler.csv"));
        dmw.writeJson(dopler, Paths.get("output_dm_dopler.json"));
    }


    public static Dopler readDOPLERModelFromFile(Path file) throws IOException {
        // ANTLR Setup
        // TODO check for wrong file formats
        CharStream input = CharStreams.fromPath(file);
        DoplerLexer lexer = new DoplerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DoplerParser parser = new DoplerParser(tokens);

        // Create parse tree
        ParseTree tree = parser.document();
        ParseTreeWalker walker = new ParseTreeWalker();

        // Walk through both listeners, first to create the decisions, second to create the expressions
        DoplerDecisionCreator decisionCreator = new DoplerDecisionCreator(file.getFileName().toString());
        walker.walk(decisionCreator, tree);
        DoplerExpressionParser expressionParser = new DoplerExpressionParser(decisionCreator.getDopler());
        walker.walk(expressionParser, tree);

        // Extract Dopler Model

        return expressionParser.getDopler();

    }


    @SuppressWarnings("rawtypes")
    public static EnumerationLiteral getEnumerationliteral(final Dopler dm, final IValue enumString) {
        for (final Object o : dm.getEnumSet()) {
            final Enumeration enumeration = (Enumeration) o;
            for (final EnumerationLiteral enumerationLiteral : enumeration.getEnumerationLiterals()) {
                if (enumerationLiteral.getValue().equals(enumString.getValue())) {
                    return enumerationLiteral;
                }
            }
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    public static IDecision getDecision(final Dopler dm, final String displayId) {
        for (final Object o : dm.getDecisions()) {
            final IDecision decision = (IDecision) o;
            if (decision.getDisplayId().equals(displayId)) {
                return decision;
            }
        }
        return null;
    }

    public static Set<IDecision> getBooleanDecisions(final Dopler dm) {
        return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.BOOLEAN))
                .collect(Collectors.toSet());
    }

    public static Set<IDecision> getEnumerationDecisions(final Dopler dm) {
        return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.ENUM))
                .collect(Collectors.toSet());
    }

    public static Set<IDecision> getNumberDecisions(final Dopler dm) {
        return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.NUMBER))
                .collect(Collectors.toSet());
    }

    public static Set<IDecision> getStringDecisions(final Dopler dm) {
        return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.STRING))
                .collect(Collectors.toSet());
    }
}
