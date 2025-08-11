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
	 * Enter a parse tree produced by {@link CSVParser#rangeItem}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterRangeItem(CSVParser.RangeItemContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#rangeItem}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitRangeItem(CSVParser.RangeItemContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#specialCharacter}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterSpecialCharacter(CSVParser.SpecialCharacterContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#specialCharacter}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitSpecialCharacter(CSVParser.SpecialCharacterContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#subrange}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterSubrange(CSVParser.SubrangeContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#subrange}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitSubrange(CSVParser.SubrangeContext ctx);
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
	 * Enter a parse tree produced by {@link CSVParser#andExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterAndExpression(CSVParser.AndExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#andExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitAndExpression(CSVParser.AndExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#orExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterOrExpression(CSVParser.OrExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#orExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitOrExpression(CSVParser.OrExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#xorExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterXorExpression(CSVParser.XorExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#xorExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitXorExpression(CSVParser.XorExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#equalityExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterEqualityExpression(CSVParser.EqualityExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#equalityExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitEqualityExpression(CSVParser.EqualityExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterGreaterThanExpression(CSVParser.GreaterThanExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitGreaterThanExpression(CSVParser.GreaterThanExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#lessThanExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterLessThanExpression(CSVParser.LessThanExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#lessThanExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitLessThanExpression(CSVParser.LessThanExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#greaterEqualsExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterGreaterEqualsExpression(CSVParser.GreaterEqualsExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#greaterEqualsExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitGreaterEqualsExpression(CSVParser.GreaterEqualsExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#lessEqualsExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterLessEqualsExpression(CSVParser.LessEqualsExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#lessEqualsExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitLessEqualsExpression(CSVParser.LessEqualsExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link CSVParser#enumerationLiteralExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterEnumerationLiteralExpression(CSVParser.EnumerationLiteralExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#enumerationLiteralExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitEnumerationLiteralExpression(CSVParser.EnumerationLiteralExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#booleanLiteralExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterBooleanLiteralExpression(CSVParser.BooleanLiteralExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#booleanLiteralExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitBooleanLiteralExpression(CSVParser.BooleanLiteralExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#stringLiteralExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterStringLiteralExpression(CSVParser.StringLiteralExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#stringLiteralExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitStringLiteralExpression(CSVParser.StringLiteralExpressionContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#doubleLiteralExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterDoubleLiteralExpression(CSVParser.DoubleLiteralExpressionContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#doubleLiteralExpression}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitDoubleLiteralExpression(CSVParser.DoubleLiteralExpressionContext ctx);
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