package edu.kit.dopler.io.antlr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.kit.dopler.model.NumberDecision;
import edu.kit.dopler.model.StringDecision;
import edu.kit.dopler.exceptions.InvalidCardinalityException;
import edu.kit.dopler.io.antlr.resources.CSVLexer;
import edu.kit.dopler.io.antlr.resources.CSVParser.CardinalityContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.CsvFileContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DecisionTypeContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.IdContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.QuestionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.RangeContext;
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

public class DoplerDecisionCreator extends DecisionParserBase {
	String name;
	
	public DoplerDecisionCreator(String name){
		this.name = name;
	}

	@Override
	public void enterCsvFile(CsvFileContext ctx) {
		dopler = new Dopler();
		dopler.setName(name);
	}

	@Override
	public void enterId(IdContext ctx) {
		if (matchesColumn(ctx, column_ID) && ctx.IDENTIFIER() != null) {
			currentID = ctx.IDENTIFIER().getText();
		} 
	}

	@Override
	public void enterCardinality(CardinalityContext ctx) {
		IDecision<?> currentDecision = findDecisionByID(currentID);
		List<TerminalNode> cardinals = ctx.DoubleLiteralExpression();
		if (cardinals.size() >= 2) {
			if(currentDecision instanceof EnumerationDecision)
			{
				EnumerationDecision enumerationDecision = (EnumerationDecision) currentDecision;
				try {
					enumerationDecision.setCardinality(Integer.parseInt(cardinals.get(0).getText()), Integer.parseInt(cardinals.get(1).getText()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (InvalidCardinalityException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void enterQuestion(QuestionContext ctx) {
		if (ctx.QUESTION() != null) {
			currentQuestion = ctx.QUESTION().getSymbol().getText();
		}
	}

	@Override
	public void enterRange(RangeContext ctx) {
		IDecision<?> currentDecision = findDecisionByID(currentID);
		switch (currentDecision.getDecisionType()) {
		case BOOLEAN:
			return;
		case STRING:
			// The same way as in NUMBER trough ValidityConditions
			break;
		case NUMBER:
			List<TerminalNode> AllExpressions = ctx.DoubleLiteralExpression();
			Set<IExpression> currentValidityConditions = new HashSet<>();
			NumberDecision numberDecision = (NumberDecision) currentDecision;
			if (AllExpressions.size() % 2 ***REMOVED*** 0) {
				for (int i = 0; i < AllExpressions.size(); i += 2) {
					TerminalNode left = ctx.DoubleLiteralExpression(i);
					TerminalNode right = ctx.DoubleLiteralExpression(i + 1);
					currentValidityConditions
							.add(new GreatherThan(new DoubleLiteralExpression(Double.parseDouble(left.getText()) - 1),
									new DecisionValueCallExpression(currentDecision)));
					currentValidityConditions
							.add(new LessThan(new DoubleLiteralExpression(Double.parseDouble(right.getText()) + 1),
									new DecisionValueCallExpression(currentDecision)));
				}
			}
			numberDecision.setValidityConditions(currentValidityConditions);
			break;
		case ENUM:
			List<ParseTree> children = ctx.children;
			List<TerminalNode> leafs = new ArrayList<>();
			for (ParseTree child : children) {
				leafs.addAll(getAllTerminalNodes(child));
			}

			Set<EnumerationLiteral> enumerationLiterals = new HashSet<>();
			String currentLiteral = "";
			for (int i = 0; i < leafs.size(); i++) {
				if (leafs.get(i).getSymbol().getType() ***REMOVED*** CSVLexer.PIPE) {
					enumerationLiterals.add(new EnumerationLiteral(currentLiteral));
					currentLiteral = "";
				} else {
					currentLiteral += leafs.get(i).getSymbol().getText();
				}
			}
			enumerationLiterals.add(new EnumerationLiteral(currentLiteral));
			Enumeration enumeration = new Enumeration(enumerationLiterals);
			EnumerationDecision enumerationDecision = (EnumerationDecision) currentDecision;
			enumerationDecision.setEnumeration(enumeration);
			dopler.addEnum(enumeration);
		}
	}

	@Override
	public void enterDecisionType(DecisionTypeContext ctx) {
		for (ParseTree child : ctx.children) {
			if (child instanceof TerminalNode) {
				TerminalNode node = (TerminalNode) child;
				switch (node.getSymbol().getType()) {
				case CSVLexer.NumberDecision:
					dopler.addDecision(new NumberDecision(currentID, currentQuestion, currentDescription, new BooleanLiteralExpression(true) , new HashSet<>(), new HashSet<>()));
					break;
				case CSVLexer.EnumerationDecision:
					dopler.addDecision(new EnumerationDecision(currentID, currentQuestion, currentDescription, new BooleanLiteralExpression(true), new HashSet<>(), null, 1, 1));
					break;
				case CSVLexer.BooleanDecision:
					dopler.addDecision(new BooleanDecision(currentID, currentQuestion, currentDescription, new BooleanLiteralExpression(true), new HashSet<>()));
					break;
				case CSVLexer.StringDecision:
					dopler.addDecision(new StringDecision(currentID, currentQuestion, currentDescription, new BooleanLiteralExpression(true), new HashSet<>(), new HashSet<>()));
					break;
				}
			}
		}
	}

}
