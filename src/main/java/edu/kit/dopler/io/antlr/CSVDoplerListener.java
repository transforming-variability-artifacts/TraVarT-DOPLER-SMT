package edu.kit.dopler.io.antlr;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.kit.dopler.model.NumberDecision;
import edu.kit.dopler.model.OR;
import edu.kit.dopler.model.Rule;
import edu.kit.dopler.model.StringDecision;
import edu.kit.dopler.model.StringLiteralExpression;
import edu.kit.dopler.model.UnaryExpression;
import edu.kit.dopler.model.XOR;
import edu.kit.dopler.io.antlr.resources.CSVLexer;
import edu.kit.dopler.io.antlr.resources.CSVListener;
import edu.kit.dopler.io.antlr.resources.CSVParser;
import edu.kit.dopler.io.antlr.resources.CSVParser.ActionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.AllowsContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.AndExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.BinaryExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.BooleanEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.CardinalityContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.CsvFileContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DecisionTypeContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DecisionValueCallExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DecisionVisibilityCallExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DisallowsContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DoubleEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.EnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.EnumEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.EqualityExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.ExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.FieldContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.GreaterEqualsExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.GreaterThanExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.HdrContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.IdContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.IsTakenContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.LessEqualsExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.LessThanExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.LiteralExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.OrExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.QuestionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.RangeContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.RangeItemContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.RowContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.RuleContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.SpecialCharacterContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.StringEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.SubrangeContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.UnaryExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.ValueRestrictionActionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.XorExpressionContext;
import edu.kit.dopler.model.AND;
import edu.kit.dopler.model.Action;
import edu.kit.dopler.model.BooleanDecision;
import edu.kit.dopler.model.BooleanLiteralExpression;
import edu.kit.dopler.model.Decision;
import edu.kit.dopler.model.Decision.DecisionType;
import edu.kit.dopler.model.DecisionValueCallExpression;
import edu.kit.dopler.model.DecisionVisibilityCallExpression;
import edu.kit.dopler.model.Dopler;
import edu.kit.dopler.model.DoubleLiteralExpression;
import edu.kit.dopler.model.Enumeration;
import edu.kit.dopler.model.EnumerationDecision;
import edu.kit.dopler.model.EnumerationLiteral;
import edu.kit.dopler.model.EnumeratorLiteralExpression;
import edu.kit.dopler.model.Equals;
import edu.kit.dopler.model.Expression;
import edu.kit.dopler.model.GreatherThan;
import edu.kit.dopler.model.IAction;
import edu.kit.dopler.model.IDecision;
import edu.kit.dopler.model.IExpression;
import edu.kit.dopler.model.IsTaken;
import edu.kit.dopler.model.LessThan;
import edu.kit.dopler.model.LiteralExpression;
import edu.kit.dopler.model.NOT;

public class CSVDoplerListener implements CSVListener {
	private Dopler dopler;
	
	private String currentID = "";
	private String currentQuestion = "";
	private String currentDescription = "";
	private DecisionType currentDecisionType;
	private Enumeration currentEnumeration;
	private Set<IExpression> currentValidityConditions;

	// Current Rules variables
	private Set<Rule> currentRules;
	// Per Rule
	private Set<IAction> currentActions;

	// Traverse Expression
	Deque<IExpression> expressionStack = new ArrayDeque<>();

	private int currentMinCardinality = 1;
	private int currentMaxCardinality = 1;
	private IExpression currentVisibilityCondition;

	private final int column_ID = 0;
	private final int column_VisibilityCondition = 6;


	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterCsvFile(CsvFileContext ctx) {
		dopler = new Dopler();

	}

	@Override
	public void exitCsvFile(CsvFileContext ctx) {
		dopler.setName("File Name");
	}

	@Override
	public void enterHdr(HdrContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitHdr(HdrContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterRow(RowContext ctx) {
		// Nothing to do when entering a row, the decision is being created, by entering
		// the decision type
	}

	@Override
	public void exitRow(RowContext ctx) {
		switch (currentDecisionType) {
		case BOOLEAN:
			dopler.addDecision(new BooleanDecision(currentID, currentQuestion, currentDescription,
					currentVisibilityCondition, currentRules));
			break;
		case STRING:
			dopler.addDecision(new StringDecision(currentID, currentQuestion, currentDescription, currentVisibilityCondition,
					currentRules, currentValidityConditions));
			break;
		case NUMBER:
			dopler.addDecision(new NumberDecision(currentID, currentQuestion, currentDescription, currentVisibilityCondition,
					currentRules, currentValidityConditions));
			break;
		case ENUM:
			dopler.addDecision(new EnumerationDecision(currentID, currentQuestion, currentDescription, currentVisibilityCondition,
					currentRules, currentEnumeration, currentMinCardinality, currentMaxCardinality));
			dopler.addEnum(currentEnumeration);
		}
		resetValues();
	}

	private void resetValues() {
		currentID = "";
		currentQuestion = "";
		currentDescription = "";
		currentDecisionType = null;
		currentEnumeration = null;
		currentValidityConditions = null;
		currentRules = null;
		currentMinCardinality = 1;
		currentMaxCardinality = 1;
		currentVisibilityCondition = null;
	}

	@Override
	public void enterField(FieldContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitField(FieldContext ctx) {
		
	}

	@Override
	public void enterId(IdContext ctx) {
		if (matchesColumn(ctx, column_ID) && ctx.IDENTIFIER() != null) {
			currentID = ctx.IDENTIFIER().getText();
		} else if (matchesColumn(ctx, column_VisibilityCondition) && ctx.IDENTIFIER() != null) {
			expressionStack.push(new DecisionValueCallExpression(findDecisionByID(ctx.IDENTIFIER().getText())));
			IDecision<?> decision = findDecisionByID(ctx.IDENTIFIER().getText());
			if (decision != null) {
				expressionStack.push(new DecisionValueCallExpression(decision));
			}
		}
	}


	private boolean matchesColumn(ParserRuleContext ctx, int column) {
		return ctx ***REMOVED*** ctx.getParent().children.get(column_ID);
	}

	@Override
	public void exitId(IdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterCardinality(CardinalityContext ctx) {
		List<TerminalNode> cardinals = ctx.DoubleLiteralExpression();
		if (cardinals.size() >= 2) {
			currentMinCardinality = Integer.parseInt(cardinals.get(0).getText());
			currentMaxCardinality = Integer.parseInt(cardinals.get(1).getText());
		}
	}

	@Override
	public void exitCardinality(CardinalityContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterQuestion(QuestionContext ctx) {
		if (ctx.QUESTION() != null) {
			currentQuestion = ctx.QUESTION().getSymbol().getText();
		}
	}

	@Override
	public void exitQuestion(QuestionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExpression(ExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExpression(ExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterUnaryExpression(UnaryExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitUnaryExpression(UnaryExpressionContext ctx) {
		expressionStack.push(new NOT(expressionStack.pop()));
	}

	@Override
	public void enterRange(RangeContext ctx) {
		switch (currentDecisionType) {
		case BOOLEAN:
			return;
		case STRING:
			// The same way as in NUMBER trough ValidityConditions
			break;
		case NUMBER:
			List<TerminalNode> AllExpressions = ctx.DoubleLiteralExpression();
			if (AllExpressions.size() % 2 ***REMOVED*** 0) {
				for (int i = 0; i < AllExpressions.size(); i += 2) {
					TerminalNode left = ctx.DoubleLiteralExpression(i);
					TerminalNode right = ctx.DoubleLiteralExpression(i + 1);
					currentValidityConditions.add(new GreatherThan(new DoubleLiteralExpression(Double.parseDouble(left.getText()) - 1 ) , new DecisionValueCallExpression(findDecisionByID(currentID))));
					currentValidityConditions.add(new LessThan(new DoubleLiteralExpression(Double.parseDouble(right.getText()) + 1), new DecisionValueCallExpression(findDecisionByID(currentID))));
				}
			}
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
			currentEnumeration = new Enumeration(enumerationLiterals);
		}
	}
	
	private IDecision<?> findDecisionByID(String ID){
		for(IDecision<?> decision : dopler.getDecisions()) {
			if(decision.getDisplayId().equals(ID)) return decision;
		}
		return null;
	}

	private List<TerminalNode> getAllTerminalNodes(ParseTree tree) {
		List<TerminalNode> terminals = new ArrayList<>();
		collectTerminals(tree, terminals);
		return terminals;
	}

	private void collectTerminals(ParseTree tree, List<TerminalNode> result) {
		if (tree instanceof TerminalNode) {
			result.add((TerminalNode) tree);
		} else {
			for (int i = 0; i < tree.getChildCount(); i++) {
				collectTerminals(tree.getChild(i), result);
			}
		}
	}

	@Override
	public void exitRange(RangeContext ctx) {
		expressionStack.clear();
	}

	@Override
	public void enterDecisionVisibilityCallExpression(DecisionVisibilityCallExpressionContext ctx) {
		expressionStack.clear();
	}

	@Override
	public void exitDecisionVisibilityCallExpression(DecisionVisibilityCallExpressionContext ctx) {
		// visibility condition is set to true by default
		if(ctx.children.size()***REMOVED***0) {
			currentVisibilityCondition = new BooleanLiteralExpression(true);
			return;
		}
		
		if (ctx.children.size() != 1) {
			if (ctx.children.get(1) instanceof TerminalNode) {
				IExpression right = expressionStack.pop();
				IExpression left = expressionStack.pop();

				TerminalNode operator = (TerminalNode) ctx.children.get(1);
				switch (operator.getSymbol().getTokenIndex()) {
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
		currentVisibilityCondition = expressionStack.pop();
	}

	@Override
	public void enterIsTaken(IsTakenContext ctx) {
		TerminalNode decisionID = ctx.IDENTIFIER();
		if (decisionID != null) {
			expressionStack.push(new IsTaken(findDecisionByID(decisionID.getText())));
		}
	}

	@Override
	public void exitIsTaken(IsTakenContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDecisionValueCallExpression(DecisionValueCallExpressionContext ctx) {
		TerminalNode decisionID = ctx.IDENTIFIER();
		if (decisionID != null) {
			expressionStack.push(new DecisionValueCallExpression(findDecisionByID(decisionID.getText())));
		}
	}

	@Override
	public void exitDecisionValueCallExpression(DecisionValueCallExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterBinaryExpression(BinaryExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitBinaryExpression(BinaryExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterLiteralExpression(LiteralExpressionContext ctx) {
		if(ctx.BooleanLiteralExpression() != null) {
			expressionStack.push(new BooleanLiteralExpression(Boolean.parseBoolean(ctx.BooleanLiteralExpression().getText())));
		} else if(ctx.DoubleLiteralExpression() != null){
			expressionStack.push(new DoubleLiteralExpression(Double.parseDouble(ctx.DoubleLiteralExpression().getText())));
		} else if(ctx.EnumerationLiteralExpression() != null) {
			String[] enumeration = ctx.EnumerationLiteralExpression().getText().split(".");
			if(enumeration.length < 2) return;
			IDecision<?> decision = findDecisionByID(enumeration[0]);
			if(decision instanceof EnumerationDecision) {
				EnumerationDecision enumerationDecision = (EnumerationDecision) decision;
				Optional<EnumerationLiteral> enumerationLiteral = enumerationDecision.getEnumeration().getEnumerationLiterals().stream().filter(e -> e.getValue().equals(enumeration[1])).findFirst();
				expressionStack.push(new Equals(new DecisionValueCallExpression(enumerationDecision),new EnumeratorLiteralExpression(enumerationLiteral.get())));
			}
		} else if(ctx.StringLiteralExpression() != null) {
			expressionStack.push(new StringLiteralExpression(ctx.StringLiteralExpression().getText()));
		}
	}

	@Override
	public void exitLiteralExpression(LiteralExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDecisionType(DecisionTypeContext ctx) {
		for (ParseTree child : ctx.children) {
			if (child instanceof TerminalNode) {
				TerminalNode node = (TerminalNode) child;
				switch (node.getSymbol().getType()) {
				case CSVLexer.NumberDecision:
					currentDecisionType = DecisionType.NUMBER;
					break;
				case CSVLexer.EnumerationDecision:
					currentDecisionType = DecisionType.ENUM;
					break;
				case CSVLexer.BooleanDecision:
					currentDecisionType = DecisionType.BOOLEAN;
					break;
				case CSVLexer.StringDecision:
					currentDecisionType = DecisionType.STRING;
					break;
				}
			}
		}
	}

	@Override
	public void exitDecisionType(DecisionTypeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterRule(RuleContext ctx) {
		expressionStack.clear();
		
	}

	@Override
	public void exitRule(RuleContext ctx) {
		if(expressionStack.isEmpty()) {
			return;
		}
		currentRules.add(new Rule(expressionStack.pop(), currentActions));
		expressionStack.clear();
		currentActions.clear();
		
	}

	@Override
	public void enterAction(ActionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitAction(ActionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterValueRestrictionAction(ValueRestrictionActionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitValueRestrictionAction(ValueRestrictionActionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterAllows(AllowsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitAllows(AllowsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDisallows(DisallowsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitDisallows(DisallowsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterEnForce(EnForceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitEnForce(EnForceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterEnumEnForce(EnumEnForceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitEnumEnForce(EnumEnForceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterStringEnForce(StringEnForceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitStringEnForce(StringEnForceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterBooleanEnForce(BooleanEnForceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitBooleanEnForce(BooleanEnForceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDoubleEnForce(DoubleEnForceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitDoubleEnForce(DoubleEnForceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterAndExpression(AndExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitAndExpression(AndExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new AND(left, right));
	}

	@Override
	public void enterOrExpression(OrExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitOrExpression(OrExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new OR(left, right));
	}

	@Override
	public void enterXorExpression(XorExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitXorExpression(XorExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new XOR(left, right));
	}

	@Override
	public void enterEqualityExpression(EqualityExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitEqualityExpression(EqualityExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new Equals(left, right));
	}

	@Override
	public void enterGreaterThanExpression(GreaterThanExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitGreaterThanExpression(GreaterThanExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new GreatherThan(left, right));
	}

	@Override
	public void enterLessThanExpression(LessThanExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitLessThanExpression(LessThanExpressionContext ctx) {
		IExpression right = expressionStack.pop();
		IExpression left = expressionStack.pop();
		expressionStack.push(new LessThan(left, right));
	}

	@Override
	public void enterGreaterEqualsExpression(GreaterEqualsExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitGreaterEqualsExpression(GreaterEqualsExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterLessEqualsExpression(LessEqualsExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitLessEqualsExpression(LessEqualsExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterRangeItem(RangeItemContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitRangeItem(RangeItemContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterSpecialCharacter(SpecialCharacterContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitSpecialCharacter(SpecialCharacterContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterSubrange(SubrangeContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitSubrange(SubrangeContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
