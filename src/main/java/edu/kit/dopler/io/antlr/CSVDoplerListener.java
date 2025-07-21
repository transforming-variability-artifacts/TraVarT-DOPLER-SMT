package edu.kit.dopler.io.antlr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.kit.dopler.model.NumberDecision;
import edu.kit.dopler.model.Rule;
import edu.kit.dopler.model.StringDecision;
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
import edu.kit.dopler.io.antlr.resources.CSVParser.RowContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.RuleContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.StringEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.UnaryExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.ValueRestrictionActionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.XorExpressionContext;
import edu.kit.dopler.model.Action;
import edu.kit.dopler.model.BooleanDecision;
import edu.kit.dopler.model.Decision;
import edu.kit.dopler.model.Decision.DecisionType;
import edu.kit.dopler.model.DecisionValueCallExpression;
import edu.kit.dopler.model.DecisionVisibilityCallExpression;
import edu.kit.dopler.model.Dopler;
import edu.kit.dopler.model.DoubleLiteralExpression;
import edu.kit.dopler.model.Enumeration;
import edu.kit.dopler.model.EnumerationDecision;
import edu.kit.dopler.model.EnumerationLiteral;
import edu.kit.dopler.model.Expression;
import edu.kit.dopler.model.GreatherThan;
import edu.kit.dopler.model.IAction;
import edu.kit.dopler.model.IDecision;
import edu.kit.dopler.model.IExpression;
import edu.kit.dopler.model.LessThan;
import edu.kit.dopler.model.LiteralExpression;

public class CSVDoplerListener implements CSVListener {
	private Dopler dopler;
	
	private String currentID = "";
	private String currentQuestion = "";
	private String currentDescription = "";
	private DecisionType currentDecisionType;
	private Enumeration currentEnumeration;
	private Set<IExpression> currentValidityConditions;
	
	//Current Rules variables
	private Set<Rule> currentRules;
	private Rule currentRule;
	private IExpression currentExpression;
	private Set<IAction> currentActions;
	private IAction currentAction;
	
	//Current Expression
	private LiteralExpression currentLiteralExpression;
	
	
	private int currentMinCardinality = 1;
	private int currentMaxCardinality = 1;
	private IExpression currentVisibilityCondition;
	
	private Set<IDecision<?>> decisions = new HashSet<>();

	private final int column_ID = 0;
	private final int column_VisibilityCondition = 6;
	
	// Context variables
	private ParserRuleContext currentContext;

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
		dopler.setDecisions(decisions);
		dopler.setAssets(null);
		dopler.setEnumSet(null);
		dopler.setName("Name");
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
		switch(currentDecisionType) {
		case BOOLEAN:
			decisions.add(new BooleanDecision(currentID, currentQuestion, currentDescription, currentVisibilityCondition, currentRules));
			break;
		case STRING:
			decisions.add(new StringDecision(currentID, currentQuestion, currentDescription, currentVisibilityCondition, currentRules, currentValidityConditions));
			break;
		case NUMBER:
			decisions.add(new NumberDecision(currentID, currentQuestion, currentDescription, currentVisibilityCondition, currentRules, currentValidityConditions));
			break;
		case ENUM:
			decisions.add(new EnumerationDecision(currentID, currentQuestion, currentDescription, currentVisibilityCondition, currentRules, currentEnumeration, currentMinCardinality, currentMaxCardinality));
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
		currentContext = null;
	}

	@Override
	public void enterId(IdContext ctx) {
		if (matchesColumn(ctx, column_ID) && ctx.IDENTIFIER() != null) {
			currentID = ctx.IDENTIFIER().getText();
		} else if(matchesColumn(ctx, column_VisibilityCondition) && ctx.IDENTIFIER() != null) {
			TerminalNode id = ctx.IDENTIFIER();
			IDecision<?> decision = getDecisionWithID(id.getText());
			if(decision != null) {
				currentVisibilityCondition = new DecisionValueCallExpression(decision);
			}
		}
	}
	
	private IDecision<?> getDecisionWithID(String ID){
		for(IDecision<?> decision : decisions) {
			if(decision.getDisplayId() ***REMOVED*** ID) {
				return decision;
			}
		}
		return null;
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
		if(cardinals.size() >= 2 ) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void enterRange(RangeContext ctx) {
		switch(currentDecisionType) {
		case BOOLEAN:
			return;
		case STRING:
			// The same way as in NUMBER trough ValidityConditions
			break;
		case NUMBER:
			List<TerminalNode> AllExpressions = ctx.DoubleLiteralExpression();
			if(AllExpressions.size() % 2 ***REMOVED*** 0) {
				for(int i = 0; i < AllExpressions.size(); i+=2 ) {
					TerminalNode left = ctx.DoubleLiteralExpression(i);
					TerminalNode right = ctx.DoubleLiteralExpression(i+1);
					//currentValidityConditions.add(new GreatherThan(new DoubleLiteralExpression(Double.parseDouble(left.getText()) - 1 )));
					//currentValidityConditions.add(new LessThan(new DoubleLiteralExpression(Double.parseDouble(right.getText()) + 1)));
				}
			}
			break;
		case ENUM:
			List<ParseTree> children = ctx.children;
			List<TerminalNode> leafs = new ArrayList<>();
			for(ParseTree child : children) {
				leafs.addAll(getAllTerminalNodes(child));
			}
			
			Set<EnumerationLiteral> enumerationLiterals = new HashSet<>();
			String currentLiteral = "";
			
			for(int i = 0; i < leafs.size(); i++ ) {
				if(leafs.get(i).getSymbol().getType() ***REMOVED*** CSVLexer.PIPE) {
					enumerationLiterals.add(new EnumerationLiteral(currentLiteral));
					currentLiteral = "";
				} else {
					currentLiteral += leafs.get(i).getSymbol().getText();
				}
			}
			currentEnumeration = new Enumeration(enumerationLiterals);
		}
	}
	
	private List<TerminalNode> getAllTerminalNodes(ParseTree tree){
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

	}

	@Override
	public void enterDecisionVisibilityCallExpression(DecisionVisibilityCallExpressionContext ctx) {
		List<ParseTree> children = ctx.children;
		
		if(children.size() ***REMOVED*** 1) {
			
		} else {
			ctx.children.get(1);
		}
		
//		DecisionVisibilityCallExpression expression = new DecisionVisibilityCallExpression(currentDecision);
		
	}

	@Override
	public void exitDecisionVisibilityCallExpression(DecisionVisibilityCallExpressionContext ctx) {

	}

	@Override
	public void enterIsTaken(IsTakenContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitIsTaken(IsTakenContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDecisionValueCallExpression(DecisionValueCallExpressionContext ctx) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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
		currentContext = ctx;
	}

	@Override
	public void exitRule(RuleContext ctx) {
		currentContext = null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterOrExpression(OrExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitOrExpression(OrExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterXorExpression(XorExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitXorExpression(XorExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEqualityExpression(EqualityExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEqualityExpression(EqualityExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterGreaterThanExpression(GreaterThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitGreaterThanExpression(GreaterThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterLessThanExpression(LessThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitLessThanExpression(LessThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		
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

}
