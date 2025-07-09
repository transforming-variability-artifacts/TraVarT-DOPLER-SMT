package edu.kit.dopler.io.antlr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.kit.dopler.model.NumberDecision;
import edu.kit.dopler.model.StringDecision;
import edu.kit.dopler.io.antlr.resources.CSVLexer;
import edu.kit.dopler.io.antlr.resources.CSVListener;
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
import edu.kit.dopler.model.BooleanDecision;
import edu.kit.dopler.model.Decision;
import edu.kit.dopler.model.DecisionVisibilityCallExpression;
import edu.kit.dopler.model.Dopler;
import edu.kit.dopler.model.EnumerationDecision;
import edu.kit.dopler.model.IDecision;

public class CSVDoplerListener implements CSVListener {
	private Dopler dopler;
	private String currentID = "";
	private String currentQuestion = "";
	private Decision currentDecision;
	private Set<IDecision<?>> decisions = new HashSet<>();

	private final int column_ID = 0;
	private final int column_QUESTION = 1;
	private final int column_TYPE = 2;
	private final int column_RANGE = 3;
	private final int column_CARDINALITY = 4;
	private final int column_CONSTRAINT = 5;
	private final int column_VISIBILITY = 6;

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
		if (currentDecision != null) {
			decisions.add(currentDecision);
			currentDecision = null;
			currentID = "";
			currentQuestion = "";
		}
	}

	@Override
	public void enterField(FieldContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitField(FieldContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterId(IdContext ctx) {
		if (matchesColumn(ctx, column_ID)) {
			ParseTree child = ctx.children.get(0);
			if (child instanceof TerminalNode) {
				TerminalNode node = (TerminalNode) child;
				if (node.getSymbol().getType() ***REMOVED*** CSVLexer.IDENTIFIER) {
					currentID = node.getSymbol().getText();
				}
			}
		}
	}

	@Override
	public void exitId(IdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterCardinality(CardinalityContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitCardinality(CardinalityContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterQuestion(QuestionContext ctx) {
		for (ParseTree child : ctx.children) {
			if (child instanceof TerminalNode) {
				TerminalNode node = (TerminalNode) child;
				if (node.getSymbol().getType() ***REMOVED*** CSVLexer.QUESTION) {
					currentQuestion = node.getSymbol().getText();
				}
			}
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
		// No range class in the model exists
	}

	@Override
	public void exitRange(RangeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDecisionVisibilityCallExpression(DecisionVisibilityCallExpressionContext ctx) {
		List<ParseTree> children = ctx.children;
		new DecisionVisibilityCallExpression(currentDecision);
		currentDecision.setVisibilityCondition(null);
		
		for(ParseTree child : children) {
			
		}

	}

	@Override
	public void exitDecisionVisibilityCallExpression(DecisionVisibilityCallExpressionContext ctx) {
		// TODO Auto-generated method stub

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
		// Decision Type is already implicitly set when choosing the correct decision
		// class
		for (ParseTree child : ctx.children) {
			if (child instanceof TerminalNode) {
				TerminalNode node = (TerminalNode) child;
				switch (node.getSymbol().getType()) {
				case CSVLexer.NumberDecision:
					currentDecision = new NumberDecision(currentID, currentQuestion, "description", null, null, null);
					break;
				case CSVLexer.EnumerationDecision:
					currentDecision = new EnumerationDecision(currentID, currentQuestion, "description", null, null,
							null, 0, 0);
					break;
				case CSVLexer.BooleanDecision:
					currentDecision = new BooleanDecision(currentID, currentQuestion, "description", null, null);
					break;
				case CSVLexer.StringDecision:
					currentDecision = new StringDecision(currentID, currentQuestion, "description", null, null, null);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void exitRule(RuleContext ctx) {
		// TODO Auto-generated method stub

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

	private boolean matchesColumn(ParserRuleContext ctx, int column) {
		return ctx ***REMOVED*** ctx.getParent().children.get(column_ID);
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
