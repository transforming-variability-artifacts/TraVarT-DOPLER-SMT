package edu.kit.dopler.io.antlr.resources;
// Generated from CSV.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

***REMOVED****
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CSVParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 ***REMOVED***
public interface CSVVisitor<T> extends ParseTreeVisitor<T> {
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#csvFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitCsvFile(CSVParser.CsvFileContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#hdr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitHdr(CSVParser.HdrContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitRow(CSVParser.RowContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitField(CSVParser.FieldContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitId(CSVParser.IdContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#cardinality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitCardinality(CSVParser.CardinalityContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitQuestion(CSVParser.QuestionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitRange(CSVParser.RangeContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#rangeItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitRangeItem(CSVParser.RangeItemContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#specialCharacter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitSpecialCharacter(CSVParser.SpecialCharacterContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#subrange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitSubrange(CSVParser.SubrangeContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitExpression(CSVParser.ExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitUnaryExpression(CSVParser.UnaryExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#decisionVisibilityCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitDecisionVisibilityCallExpression(CSVParser.DecisionVisibilityCallExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#isTaken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitIsTaken(CSVParser.IsTakenContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#decisionValueCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitDecisionValueCallExpression(CSVParser.DecisionValueCallExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#binaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitBinaryExpression(CSVParser.BinaryExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitAndExpression(CSVParser.AndExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitOrExpression(CSVParser.OrExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#xorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitXorExpression(CSVParser.XorExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitEqualityExpression(CSVParser.EqualityExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitGreaterThanExpression(CSVParser.GreaterThanExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#lessThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitLessThanExpression(CSVParser.LessThanExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#greaterEqualsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitGreaterEqualsExpression(CSVParser.GreaterEqualsExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#lessEqualsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitLessEqualsExpression(CSVParser.LessEqualsExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitLiteralExpression(CSVParser.LiteralExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#enumerationLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitEnumerationLiteralExpression(CSVParser.EnumerationLiteralExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#booleanLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitBooleanLiteralExpression(CSVParser.BooleanLiteralExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#stringLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitStringLiteralExpression(CSVParser.StringLiteralExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#doubleLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitDoubleLiteralExpression(CSVParser.DoubleLiteralExpressionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#decisionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitDecisionType(CSVParser.DecisionTypeContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitRule(CSVParser.RuleContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitAction(CSVParser.ActionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#valueRestrictionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitValueRestrictionAction(CSVParser.ValueRestrictionActionContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#allows}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitAllows(CSVParser.AllowsContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#disallows}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitDisallows(CSVParser.DisallowsContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#enForce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitEnForce(CSVParser.EnForceContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#enumEnForce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitEnumEnForce(CSVParser.EnumEnForceContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#stringEnForce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitStringEnForce(CSVParser.StringEnForceContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#booleanEnForce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitBooleanEnForce(CSVParser.BooleanEnForceContext ctx);
	***REMOVED****
	 * Visit a parse tree produced by {@link CSVParser#doubleEnForce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 ***REMOVED***
	T visitDoubleEnForce(CSVParser.DoubleEnForceContext ctx);
}