package edu.kit.dopler.io.antlr;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;

import edu.kit.dopler.model.NumberDecision;
import edu.kit.dopler.model.NumberEnforce;
import edu.kit.dopler.model.OR;
import edu.kit.dopler.model.Rule;
import edu.kit.dopler.model.StringLiteralExpression;
import edu.kit.dopler.model.XOR;
import edu.kit.dopler.io.antlr.resources.CSVParser;
import edu.kit.dopler.io.antlr.resources.CSVParser.AllowsContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.AndExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.BooleanEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.BooleanLiteralExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DecisionValueCallExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DecisionVisibilityCallExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DisallowsContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DoubleEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DoubleLiteralExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.EnumEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.EnumerationLiteralExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.EqualityExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.GreaterThanExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.IdContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.IsTakenContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.LessThanExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.LiteralExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.OrExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.RowContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.RuleContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.StringEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.StringLiteralExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.UnaryExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.XorExpressionContext;
import edu.kit.dopler.model.AND;
import edu.kit.dopler.model.Allows;
import edu.kit.dopler.model.BooleanDecision;
import edu.kit.dopler.model.BooleanEnforce;
import edu.kit.dopler.model.BooleanLiteralExpression;
import edu.kit.dopler.model.Decision.DecisionType;
import edu.kit.dopler.model.DecisionValueCallExpression;
import edu.kit.dopler.model.DisAllows;
import edu.kit.dopler.model.Dopler;
import edu.kit.dopler.model.DoubleLiteralExpression;
import edu.kit.dopler.model.Enumeration;
import edu.kit.dopler.model.EnumerationDecision;
import edu.kit.dopler.model.EnumerationLiteral;
import edu.kit.dopler.model.EnumeratorLiteralExpression;
import edu.kit.dopler.model.Equals;
import edu.kit.dopler.model.GreatherThan;
import edu.kit.dopler.model.IAction;
import edu.kit.dopler.model.IDecision;
import edu.kit.dopler.model.IExpression;
import edu.kit.dopler.model.IsTaken;
import edu.kit.dopler.model.LessThan;
import edu.kit.dopler.model.NOT;
import edu.kit.dopler.model.BooleanValue;
import edu.kit.dopler.model.DoubleValue;
import edu.kit.dopler.model.EnumEnforce;
import edu.kit.dopler.model.StringValue;

public class DoplerExpressionParser extends DecisionParserBase {
	private boolean idSet;

	// Current Rules variables
	private Set<Rule> currentRules = new HashSet<>();
	// Per Rule
	private Set<IAction> currentActions = new HashSet<>();

	// Traverse Expression
	Deque<IExpression> expressionStack = new ArrayDeque<>();

	private IExpression currentVisibilityCondition;
	
	public DoplerExpressionParser(Dopler dopler) {
		this.dopler = dopler;
	}

	public Dopler getDopler() {
		return dopler;
	}
	
	@Override
	public void enterRow(RowContext ctx) {
		idSet = false;
	}

	@Override
	public void exitRow(RowContext ctx) {		
		IDecision<?> currentDecision = findDecisionByID(currentID);
		if(currentDecision ***REMOVED*** null) return;
		if(!(currentVisibilityCondition ***REMOVED*** null)) currentDecision.setVisibilityCondition(currentVisibilityCondition);
		currentRules.forEach(r -> currentDecision.addRule(r));
		resetValues();
	}

	private void resetValues() {
		currentID = "";
		currentRules.clear();
		currentActions.clear();
		currentVisibilityCondition = null;
	}

	@Override
	public void enterId(IdContext ctx) {
		if (!idSet) {
			currentID = ctx.IDENTIFIER().getText();
			idSet = true;
		} else {
			expressionStack.push(new DecisionValueCallExpression(findDecisionByID(ctx.IDENTIFIER().getText())));
			IDecision<?> decision = findDecisionByID(ctx.IDENTIFIER().getText());
			if (decision != null) {
				expressionStack.push(new DecisionValueCallExpression(decision));
			}
			currentVisibilityCondition = expressionStack.pop();
		}
	}

	@Override
	public void exitUnaryExpression(UnaryExpressionContext ctx) {
		expressionStack.push(new NOT(expressionStack.pop()));
	}

	@Override
	public void enterDecisionVisibilityCallExpression(DecisionVisibilityCallExpressionContext ctx) {
		expressionStack.clear();
	}

	@Override
	public void exitDecisionVisibilityCallExpression(DecisionVisibilityCallExpressionContext ctx) {
		if (ctx.children.size() != 1) {
			if (ctx.children.get(1) instanceof TerminalNode) {
				IExpression right = expressionStack.pop();
				IExpression left = expressionStack.pop();

				TerminalNode operator = (TerminalNode) ctx.children.get(1);
				switch (operator.getSymbol().getType()) {
				case CSVParser.AND:
					expressionStack.push(new AND(left, right));
					break;
				case CSVParser.OR:
					expressionStack.push(new OR(left, right));
					break;
				case CSVParser.EQUALS:
					expressionStack.push(new Equals(left, right));
					break;
				case CSVParser.GREATER_THAN:
					expressionStack.push(new GreatherThan(left, right));
					break;
				case CSVParser.LESS_THAN:
					expressionStack.push(new LessThan(left, right));
					break;
				}
			}
		}
		if(!expressionStack.isEmpty()) currentVisibilityCondition = expressionStack.pop();
	}

	@Override
	public void enterIsTaken(IsTakenContext ctx) {
		TerminalNode decisionID = ctx.IDENTIFIER();
		if (decisionID != null) {
			expressionStack.push(new IsTaken(findDecisionByID(decisionID.getText())));
		}
	}

	@Override
	public void enterDecisionValueCallExpression(DecisionValueCallExpressionContext ctx) {
		TerminalNode decisionID = ctx.IDENTIFIER();
		if (decisionID != null) {
			expressionStack.push(new DecisionValueCallExpression(findDecisionByID(decisionID.getText())));
		}
	}
	
	@Override
	public void enterBooleanLiteralExpression(BooleanLiteralExpressionContext ctx) {
		expressionStack.push(new BooleanLiteralExpression(Boolean.parseBoolean(ctx.BooleanLiteralExpression().getText())));
	}
	
	@Override
	public void enterStringLiteralExpression(StringLiteralExpressionContext ctx) {
		expressionStack.push(new StringLiteralExpression(ctx.StringLiteralExpression().getText()));
	}
	
	@Override
	public void enterDoubleLiteralExpression(DoubleLiteralExpressionContext ctx) {
		expressionStack.push(new DoubleLiteralExpression(Double.parseDouble(ctx.DoubleLiteralExpression().getText())));
	}
	
	@Override
	public void enterEnumerationLiteralExpression(EnumerationLiteralExpressionContext ctx) {
		String[] enumerationArray = ctx.EnumerationLiteralExpression().getText().split("\\.");
		if (enumerationArray.length < 2)
			return;
		IDecision<?> decision = findDecisionByID(enumerationArray[0]);
		if (decision instanceof EnumerationDecision) {
			EnumerationDecision enumerationDecision = (EnumerationDecision) decision;
			for(Enumeration enumeration : dopler.getEnumSet()) {
				Optional<EnumerationLiteral> enumerationLiteral = enumeration.getEnumerationLiterals().stream().filter(e -> e.getValue().equals(enumerationArray[1])).findFirst();
				if(enumerationLiteral.isPresent()) {
					expressionStack.push(new Equals(new DecisionValueCallExpression(enumerationDecision), new EnumeratorLiteralExpression(enumerationLiteral.get())));
					break;
				}
			}
		}
	}

	@Override
	public void enterRule(RuleContext ctx) {
		expressionStack.clear();

	}

	@Override
	public void exitRule(RuleContext ctx) {
		if (expressionStack.isEmpty()) {
			return;
		}
		currentRules.add(new Rule(expressionStack.pop(), new HashSet<>(currentActions)));
		expressionStack.clear();
		currentActions.clear();
	}

	@Override
	public void exitAllows(AllowsContext ctx) {
		String[] enumerationArray = ctx.EnumerationLiteralExpression().getText().split("\\.");
		if(enumerationArray.length > 1) {
			String identifier = enumerationArray[0];
			if (!identifier.isEmpty()) {
				IDecision<?> decision = findDecisionByID(identifier);
				if (decision != null && decision.getDecisionType() ***REMOVED*** DecisionType.ENUM) {
					currentActions.add(new Allows((EnumerationDecision) decision, new StringValue(enumerationArray[1])));
				}
			}
		}
	}

	@Override
	public void exitDisallows(DisallowsContext ctx) {
		String[] enumerationArray = ctx.EnumerationLiteralExpression().getText().split("\\.");
		if(enumerationArray.length > 1) {
			String identifier = enumerationArray[0];
			if (!identifier.isEmpty()) {
				IDecision<?> decision = findDecisionByID(identifier);
				if (decision != null && decision.getDecisionType() ***REMOVED*** DecisionType.ENUM) {
					currentActions.add(new DisAllows((EnumerationDecision) decision, new StringValue(enumerationArray[1])));
				}
			}
		}
	}

	@Override
	public void enterEnumEnForce(EnumEnForceContext ctx) {
		String identifier = ctx.IDENTIFIER().getFirst().getText();
		String value = ctx.IDENTIFIER().getLast().getText();
		if (!identifier.isEmpty()) {
			IDecision<?> decision = findDecisionByID(identifier);
			if (decision != null && decision.getDecisionType() ***REMOVED*** DecisionType.ENUM) {
				currentActions.add(new EnumEnforce((EnumerationDecision) decision, new StringValue(value)));
			}
		}
	}

	@Override
	public void enterBooleanEnForce(BooleanEnForceContext ctx) {
		String identifier = ctx.IDENTIFIER().getText();
		if (!identifier.isEmpty()) {
			IDecision<?> decision = findDecisionByID(ctx.IDENTIFIER().getText());
			if (decision != null && decision.getDecisionType() ***REMOVED*** DecisionType.BOOLEAN) {
				boolean value = Boolean.parseBoolean(ctx.BooleanLiteralExpression().getText());
				currentActions.add(new BooleanEnforce((BooleanDecision) decision, new BooleanValue(value)));
			}
		}
	}

	@Override
	public void enterDoubleEnForce(DoubleEnForceContext ctx) {
		String identifier = ctx.IDENTIFIER().getText();
		if (!identifier.isEmpty()) {
			IDecision<?> decision = findDecisionByID(ctx.IDENTIFIER().getText());
			if (decision != null && decision.getDecisionType() ***REMOVED*** DecisionType.NUMBER) {
				Double value = Double.parseDouble(ctx.DoubleLiteralExpression().getText());
				currentActions.add(new NumberEnforce((NumberDecision) decision, new DoubleValue(value)));
			}
		}
	}

	@Override
	public void exitAndExpression(AndExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new AND(left, right));
	}

	@Override
	public void exitOrExpression(OrExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new OR(left, right));
	}

	@Override
	public void exitXorExpression(XorExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new XOR(left, right));
	}

	@Override
	public void exitEqualityExpression(EqualityExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new Equals(left, right));
	}

	@Override
	public void exitGreaterThanExpression(GreaterThanExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new GreatherThan(left, right));
	}

	@Override
	public void exitLessThanExpression(LessThanExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new LessThan(left, right));
	}

}
