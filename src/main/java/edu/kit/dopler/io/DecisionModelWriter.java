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

import edu.kit.dopler.exceptions.UnknownDecisionTypeException;
import edu.kit.dopler.model.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class DecisionModelWriter {

	public void write(Dopler dm, Path path) throws IOException {
		Objects.requireNonNull(dm);
		Objects.requireNonNull(path);
		CSVFormat dmFormat = CSVUtils.createCSVFormat(true);
		try (FileWriter out = new FileWriter(path.toFile(), StandardCharsets.UTF_8);
			 CSVPrinter printer = new CSVPrinter(out, dmFormat)) {
			printer.println();
			for (IDecision<?> obj : dm.getDecisions()) {

				String rangeString = createRangeString(obj);
				String rulesString = createRulesString(obj);
				String cardinalityString = createCardinalityString(obj);

				printer.printRecord(obj.getDisplayId(), obj.getQuestion(), obj.getDecisionType(), rangeString,
						cardinalityString, rulesString, obj.getVisibilityCondition());
			}
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	public String write(Dopler dm) throws IOException {
		CSVFormat dmFormat = CSVUtils.createCSVFormat(true);
		try (StringWriter out = new StringWriter(1000); CSVPrinter printer = new CSVPrinter(out, dmFormat)) {
			printer.println();
			for (IDecision<?> obj : dm.getDecisions()) {
				String rangeString = createRangeString(obj);
				String rulesString = createRulesString(obj);
				String cardinalityString = createCardinalityString(obj);

				printer.printRecord(obj.getDisplayId(), obj.getQuestion(), obj.getDecisionType(), rangeString,
						cardinalityString, rulesString, obj.getVisibilityCondition());
			}
			return out.toString();
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	private String createCardinalityString(IDecision<?> decision) {
		String cardinalityString = "";
		if (decision instanceof EnumerationDecision enumDecision) {
			cardinalityString = enumDecision.getMinCardinality() + ":" + enumDecision.getMaxCardinality();
		}
		return cardinalityString;
	}

	private String createRulesString(IDecision<?> decision) {
		String rulesString;
		Set<Rule> rulesSet = decision.getRules();

		if (rulesSet.isEmpty()) {
			return "";
		}

		StringBuilder rulesSetBuilder = new StringBuilder("\"");
		for (Rule rule : rulesSet) {
			rulesSetBuilder.append(rule);
		}
		rulesSetBuilder.append("\"");
		rulesString = rulesSetBuilder.toString();
		return rulesString;
	}

	private String createRangeString(IDecision<?> decision) throws UnknownDecisionTypeException {
		String rangeString = "";
		switch (decision.getDecisionType()) {
			case BOOLEAN -> rangeString = "true | false";
			case NUMBER, STRING -> {
				//empty range
			}
			case ENUM -> {
				EnumerationDecision enumDecision = (EnumerationDecision) decision;
				List<EnumerationLiteral> enumeration =
						new ArrayList<>(enumDecision.getEnumeration().getEnumerationLiterals());
				enumeration.sort(Comparator.comparing(EnumerationLiteral::getValue));
				rangeString = String.join(" | ", enumeration.stream().map(EnumerationLiteral::getValue).toList());
			}
			default -> throw new UnknownDecisionTypeException(
					"Unknown Decision Type encountered during writing the DOPLER model.");
		}
		return rangeString;
	}
}