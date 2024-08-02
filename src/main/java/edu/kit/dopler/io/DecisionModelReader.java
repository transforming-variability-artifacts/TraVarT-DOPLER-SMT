package edu.kit.dopler.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

import edu.kit.dopler.model.*;
import edu.kit.dopler.model.Enumeration;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import edu.kit.dopler.common.DoplerUtils;
import edu.kit.dopler.exceptions.NotSupportedVariabilityTypeException;
import edu.kit.dopler.exceptions.ParserException;
import edu.kit.dopler.io.parser.ConditionParser;
import edu.kit.dopler.io.parser.RulesParser;

public class DecisionModelReader {

	public static final String FILE_EXTENSION_CSV = ".csv";

	private static final String CARDINALITY_NOT_SUPPORTED_ERROR = "Cardinality %s not supported for decision of type %s";

	public Dopler read(final Path path) throws IOException, NotSupportedVariabilityTypeException {
		Objects.requireNonNull(path);
		Dopler dm = new Dopler();
		dm.setName(path.getFileName().toString());
//		dm.setSourceFile(path.toAbsolutePath().toString());
		CSVFormat dmFormat = CSVUtils.createCSVFormat();

		try (Reader in = new FileReader(path.toFile(), StandardCharsets.UTF_8)) {
			Iterable<CSVRecord> records = dmFormat.parse(in);
			for (CSVRecord record : records) {
				String descriptionString = "";
				String id = record.get(CSVHeader.ID).trim();
				assert !id.isBlank();
				String typeString = record.get(CSVHeader.TYPE.toString()).trim();
				assert !typeString.isBlank();
				String questionString = record.get(CSVHeader.QUESTION.toString()).trim();
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
						NumberDecision numberDecision = (NumberDecision) decision;
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
			Iterable<CSVRecord> secondParse = dmFormat.parse(secondIn);
			ConditionParser vParser = new ConditionParser(dm);
			RulesParser rParser = new RulesParser(dm);

			for (CSVRecord record : secondParse) {
				String id = record.get(CSVHeader.ID);
				
				IDecision decision = DoplerUtils.getDecision(dm,id);
				assert decision != null;
				String csvRules = record.get(CSVHeader.RULES.toString());
				if (!csvRules.isEmpty()) {
					// TODO: Find better way to spit the string of rules (decision names may have
					// "if" as part of their names)
					String[] CSVruleSplit = Arrays.stream(csvRules.split("if")).map(String::trim)
							.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
					Set<Rule> rules = rParser.parse(decision, CSVruleSplit);
					rules.forEach(decision::addRule);
				}

				String visiblity = record.get(CSVHeader.VISIBLITY.toString());
				IExpression v = vParser.parse(visiblity);
				decision.setVisibilityCondition(v);
			}
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dm;
	}

	private Set<IExpression> deriveNumberValidityConditions(String rangeString, IDecision decision) {
		String[] options = Arrays.stream(rangeString.split("-")).map(String::trim)
		.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
		assert options.length == 2;
		Set<IExpression> validityconditions = new HashSet<>();
		validityconditions.add(new GreatherThan(new DoubleLiteralExpression(Double.parseDouble(options[0])),new DecisionValueCallExpression(decision)));
		validityconditions.add(new LessThan(new DoubleLiteralExpression(Double.parseDouble(options[1])),new DecisionValueCallExpression(decision)));
		return validityconditions;

	}

	private IDecision deriveEnumerationDecision(Dopler dm, CSVRecord record, String id, String descriptionString, String questionString,
			IDecision decision) throws NotSupportedVariabilityTypeException {
		String rangeString = record.get(CSVHeader.RANGE.toString()).trim();
		String[] options = Arrays.stream(rangeString.split("\\|")).map(String::trim)
				.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
		assert options.length > 0;
		Enumeration enumeration = new Enumeration(new HashSet<>());
		for (String o : options) {
			enumeration.addEnumLiteral(new EnumerationLiteral(o));
		}
		String cardinality = record.get(CSVHeader.CARDINALITY.toString()).trim();
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
				new HashSet<>(), enumeration, min, max);
		dm.addEnum(enumeration);
		return decision;
	}
}
