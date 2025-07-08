package edu.kit.dopler.io.antlr;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.kit.dopler.io.antlr.resources.CSVListener;
import edu.kit.dopler.io.antlr.resources.CSVParser.ActionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.AllowsContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.BinaryExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.BooleanEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.CardinalityContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.CsvFileContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DecisionCallExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DecisionTypeContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DecisionValueCallExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DecisionVisibilityCallExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DisallowsContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.DoubleEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.EnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.EnumEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.ExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.FieldContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.HdrContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.IdContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.IsTakenContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.LiteralExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.QuestionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.RangeContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.RowContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.RuleContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.StringEnForceContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.UnaryExpressionContext;
import edu.kit.dopler.io.antlr.resources.CSVParser.ValueRestrictionActionContext;

public class CSVDoplerListener implements CSVListener{

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitCsvFile(CsvFileContext ctx) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitRow(RowContext ctx) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitRange(RangeContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterDecisionCallExpression(DecisionCallExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitDecisionCallExpression(DecisionCallExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterDecisionVisibilityCallExpression(DecisionVisibilityCallExpressionContext ctx) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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

}
