package edu.kit.dopler.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
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
import edu.kit.dopler.model.Dopler;
import edu.kit.dopler.model.Enumeration;
import edu.kit.dopler.model.EnumerationDecision;
import edu.kit.dopler.model.EnumerationLiteral;
import edu.kit.dopler.model.IDecision;
import edu.kit.dopler.model.IExpression;
import edu.kit.dopler.model.NumberDecision;
import edu.kit.dopler.model.Rule;
import edu.kit.dopler.model.StringDecision;

public class DecisionModelReader {

	public static final String FILE_EXTENSION_CSV = ".csv";

	private static final String CARDINALITY_NOT_SUPPORTED_ERROR = "Cardinality %s not supported for decision of type %s";

	public Dopler read(final Path path) throws IOException, NotSupportedVariabilityTypeException {
		Objects.requireNonNull(path);
		Dopler dm = new Dopler();
//		dm.setName(path.getFileName().toString());
//		dm.setSourceFile(path.toAbsolutePath().toString());
		CSVFormat dmFormat = CSVUtils.createCSVFormat();

		try (Reader in = new FileReader(path.toFile(), StandardCharsets.UTF_8)) {
			Iterable<CSVRecord> records = dmFormat.parse(in);
			for (CSVRecord record : records) {
				String descriptionString = "";
				String id = record.get(CSVHeader.ID).trim();
				assert !id.isBlank();
				String typeString = record.get(CSVHeader.TYPE).trim();
				assert !typeString.isBlank();
				String questionString = record.get(CSVHeader.QUESTION).trim();
				assert !questionString.isBlank();

				IDecision decision = null;
				switch (typeString) {
				case "Boolean":
					decision = new BooleanDecision(id, questionString, descriptionString,
							new BooleanLiteralExpression(true), Collections.emptySet());
					break;
				case "Enumeration":
					decision = deriveEnumerationDecision(record, id, descriptionString, questionString, decision);
					break;
				case "Double":
					String rangeString = record.get(CSVHeader.RANGE);
					Set<IExpression> validityConditions = Collections.emptySet();
					if (!rangeString.isBlank()) {
						validityConditions = deriveNumberValidityConditions(rangeString);
					} 
					decision = new NumberDecision(id, questionString, descriptionString, new BooleanLiteralExpression(true), Collections.emptySet(), validityConditions);
					
					break;
				case "String":
					rangeString = record.get(CSVHeader.RANGE);
					validityConditions = Collections.emptySet();
					decision = new StringDecision(id, questionString, descriptionString, new BooleanLiteralExpression(true),
							Collections.emptySet(), validityConditions);
					break;
				default:
					throw new NotSupportedVariabilityTypeException(typeString);
				}
				dm.addDecision(decision);
			}
		}

		try (Reader secondIn = new FileReader(path.toFile(), StandardCharsets.UTF_8)) {
			Iterable<CSVRecord> secondParse = dmFormat.parse(secondIn);
			ConditionParser vParser = new ConditionParser(dm);
			RulesParser rParser = new RulesParser(dm);

			for (CSVRecord record : secondParse) {
				String id = record.get(CSVHeader.ID);
				
				IDecision decision = DoplerUtils.getDecision(dm,id);
				assert decision != null;

				String csvRules = record.get(CSVHeader.RULES);
				if (!csvRules.isEmpty()) {
					// TODO: Find better way to spit the string of rules (decision names may have
					// "if" as part of their names)
					String[] CSVruleSplit = Arrays.stream(csvRules.split("if")).map(String::trim)
							.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
					Set<Rule> rules = rParser.parse(decision, CSVruleSplit);
					rules.forEach(rule -> decision.addRule(rule));
				}

				String visiblity = record.get(CSVHeader.VISIBLITY);
				IExpression v = vParser.parse(visiblity);
				decision.setVisibilityCondition(v);
			}
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dm;
	}

	private Set<IExpression> deriveNumberValidityConditions(String rangeString) {
		String[] options = Arrays.stream(rangeString.split("-")).map(String::trim)
		.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
		assert options.length == 2;
		
		return null;
	}

	private IDecision deriveEnumerationDecision(CSVRecord record, String id, String descriptionString, String questionString,
			IDecision decision) throws NotSupportedVariabilityTypeException {
		String rangeString = record.get(CSVHeader.RANGE).trim();
		String[] options = Arrays.stream(rangeString.split("\\|")).map(String::trim)
				.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
		assert options.length > 0;
		Enumeration enumeration = new Enumeration(Collections.emptySet());
		for (String o : options) {
			enumeration.addEnumLiteral(new EnumerationLiteral(o));
		}
		String cardinality = record.get(CSVHeader.CARDINALITY).trim();
		assert !cardinality.isBlank();
		String[] values = Arrays.stream(cardinality.split(":")).map(String::trim)
				.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
		if (values.length != 2) {
			throw new NotSupportedVariabilityTypeException(String.format(CARDINALITY_NOT_SUPPORTED_ERROR, cardinality,
					decision.getClass().getCanonicalName()));
		}
		int min = Integer.parseInt(values[0]);
		int max = Integer.parseInt(values[1]);
		decision = new EnumerationDecision(id, questionString, descriptionString, new BooleanLiteralExpression(true),
				Collections.emptySet(), enumeration, min, max);
		return decision;
	}
}
