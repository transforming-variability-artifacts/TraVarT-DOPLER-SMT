package edu.kit.dopler.io.antlr.resources;

// Generated from CSV.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

***REMOVED****
 * This interface defines a complete listener for a parse tree produced by
 * {@link CSVParser}.
 ***REMOVED***
public interface CSVListener extends ParseTreeListener {
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#csvFile}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterCsvFile(CSVParser.CsvFileContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#csvFile}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitCsvFile(CSVParser.CsvFileContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#hdr}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterHdr(CSVParser.HdrContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#hdr}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitHdr(CSVParser.HdrContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#row}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterRow(CSVParser.RowContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#row}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitRow(CSVParser.RowContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#field}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterField(CSVParser.FieldContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#field}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitField(CSVParser.FieldContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#id}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterId(CSVParser.IdContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#id}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitId(CSVParser.IdContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#cardinality}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterCardinality(CSVParser.CardinalityContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#cardinality}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitCardinality(CSVParser.CardinalityContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#question}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterQuestion(CSVParser.QuestionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#question}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitQuestion(CSVParser.QuestionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#expression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterExpression(CSVParser.ExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#expression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitExpression(CSVParser.ExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#unaryExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterUnaryExpression(CSVParser.UnaryExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#unaryExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitUnaryExpression(CSVParser.UnaryExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#range}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterRange(CSVParser.RangeContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#range}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitRange(CSVParser.RangeContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#decisionCallExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterDecisionCallExpression(CSVParser.DecisionCallExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#decisionCallExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitDecisionCallExpression(CSVParser.DecisionCallExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#decisionVisibilityCallExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterDecisionVisibilityCallExpression(CSVParser.DecisionVisibilityCallExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#decisionVisibilityCallExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitDecisionVisibilityCallExpression(CSVParser.DecisionVisibilityCallExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#isTaken}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterIsTaken(CSVParser.IsTakenContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#isTaken}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitIsTaken(CSVParser.IsTakenContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#decisionValueCallExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterDecisionValueCallExpression(CSVParser.DecisionValueCallExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#decisionValueCallExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitDecisionValueCallExpression(CSVParser.DecisionValueCallExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#binaryExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterBinaryExpression(CSVParser.BinaryExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#binaryExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitBinaryExpression(CSVParser.BinaryExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#literalExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterLiteralExpression(CSVParser.LiteralExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#literalExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitLiteralExpression(CSVParser.LiteralExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#decisionType}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterDecisionType(CSVParser.DecisionTypeContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#decisionType}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitDecisionType(CSVParser.DecisionTypeContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#rule}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterRule(CSVParser.RuleContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#rule}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitRule(CSVParser.RuleContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#action}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterAction(CSVParser.ActionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#action}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitAction(CSVParser.ActionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#valueRestrictionAction}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterValueRestrictionAction(CSVParser.ValueRestrictionActionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#valueRestrictionAction}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitValueRestrictionAction(CSVParser.ValueRestrictionActionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#allows}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterAllows(CSVParser.AllowsContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#allows}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitAllows(CSVParser.AllowsContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#disallows}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterDisallows(CSVParser.DisallowsContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#disallows}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitDisallows(CSVParser.DisallowsContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#enForce}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterEnForce(CSVParser.EnForceContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#enForce}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitEnForce(CSVParser.EnForceContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#enumEnForce}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterEnumEnForce(CSVParser.EnumEnForceContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#enumEnForce}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitEnumEnForce(CSVParser.EnumEnForceContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#stringEnForce}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterStringEnForce(CSVParser.StringEnForceContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#stringEnForce}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitStringEnForce(CSVParser.StringEnForceContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#booleanEnForce}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterBooleanEnForce(CSVParser.BooleanEnForceContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#booleanEnForce}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitBooleanEnForce(CSVParser.BooleanEnForceContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#doubleEnForce}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterDoubleEnForce(CSVParser.DoubleEnForceContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#doubleEnForce}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitDoubleEnForce(CSVParser.DoubleEnForceContext ctx);
}