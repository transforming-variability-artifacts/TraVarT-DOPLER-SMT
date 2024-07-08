package edu.kit.dopler.io;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVFormat.Builder;
import org.apache.commons.csv.CSVPrinter;

import edu.kit.dopler.exceptions.UnknownDecisionTypeException;
import edu.kit.dopler.model.Dopler;
import edu.kit.dopler.model.EnumerationDecision;
import edu.kit.dopler.model.EnumerationLiteral;
import edu.kit.dopler.model.IDecision;
import edu.kit.dopler.model.Rule;

public class DecisionModelWriter {

	public void write(final Dopler dm, final Path path) throws IOException {
		Objects.requireNonNull(dm);
		Objects.requireNonNull(path);
		CSVFormat dmFormat = CSVUtils.createCSVFormat();
		try (FileWriter out = new FileWriter(path.toFile(), StandardCharsets.UTF_8);
				CSVPrinter printer = new CSVPrinter(out, dmFormat)) {
			for (Object obj : dm.getDecisions()) {
				assert obj instanceof IDecision;
				IDecision decision = (IDecision) obj;

				String rangeString = createRangeString(decision);
				String rulesString = createRulesString(decision);
				String cardinalityString = createCardinalityString(decision);

				printer.printRecord(decision.getDisplayId(), decision.getQuestion(), decision.getDecisionType(),
						rangeString, cardinalityString, rulesString,
						decision.getVisibilityCondition());
			}
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	private String createCardinalityString(IDecision decision) {
		String cardinalityString = "";
		if (decision instanceof EnumerationDecision) {
			EnumerationDecision enumDecision = ((EnumerationDecision) decision);
			cardinalityString = enumDecision.getMinCardinality() + ":" + enumDecision.getMaxCardinality();
		}
		return cardinalityString;
	}

	private String createRulesString(IDecision decision) {
		String rulesString = "";
		Set<Rule> rulesSet = decision.getRules();
		StringBuilder rulesSetBuilder = new StringBuilder();
		for (Rule rule : rulesSet) {
			rulesSetBuilder.append(rule);
		}
		rulesString = rulesSetBuilder.toString();
		return rulesString;
	}

	private String createRangeString(IDecision decision) throws UnknownDecisionTypeException {
		String rangeString = "";
		switch (decision.getDecisionType()) {
		case BOOLEAN:
			rangeString = "true | false";
			break;
		case NUMBER:
			// no range
			break;
		case STRING:
			// no range
			break;
		case ENUM:
			EnumerationDecision enumDecision = (EnumerationDecision) decision;
			Set<EnumerationLiteral> enumeration = enumDecision.getEnumeration().getEnumerationLiterals();
			StringBuilder builder = new StringBuilder();
			int i = 0;
			for (EnumerationLiteral literal : enumeration) {
				builder.append(literal.getValue());
				if (i != enumeration.size()) {
					builder.append(" | ");
				}
				i++;
			}
			rangeString = builder.toString();
			break;
		default:
			throw new UnknownDecisionTypeException(
					"Unknown Decision Type encountered during writing the DOPLER model.");

		}
		return rangeString;
	}
}
