/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 * 	@author David Kowal
 * 	@author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/

// Generated from DoplerParser.g4 by ANTLR 4.13.2
package edu.kit.dopler.io.antlr.resources;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DoplerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DoplerParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DoplerParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(DoplerParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#jsonDocument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonDocument(DoplerParser.JsonDocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#jsonValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonValue(DoplerParser.JsonValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#jsonObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonObject(DoplerParser.JsonObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#jsonPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonPair(DoplerParser.JsonPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#csvFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCsvFile(DoplerParser.CsvFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#hdr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHdr(DoplerParser.HdrContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(DoplerParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(DoplerParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(DoplerParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(DoplerParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#cardinality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCardinality(DoplerParser.CardinalityContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(DoplerParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(DoplerParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#rangeItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeItem(DoplerParser.RangeItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#specialCharacter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialCharacter(DoplerParser.SpecialCharacterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#subrange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubrange(DoplerParser.SubrangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DoplerParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(DoplerParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#decisionVisibilityCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecisionVisibilityCallExpression(DoplerParser.DecisionVisibilityCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#isTaken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsTaken(DoplerParser.IsTakenContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#decisionValueCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecisionValueCallExpression(DoplerParser.DecisionValueCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#binaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(DoplerParser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(DoplerParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(DoplerParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#xorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXorExpression(DoplerParser.XorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(DoplerParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanExpression(DoplerParser.GreaterThanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#lessThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanExpression(DoplerParser.LessThanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#greaterEqualsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterEqualsExpression(DoplerParser.GreaterEqualsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#lessEqualsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessEqualsExpression(DoplerParser.LessEqualsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(DoplerParser.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#enumerationLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationLiteralExpression(DoplerParser.EnumerationLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#booleanLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteralExpression(DoplerParser.BooleanLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#stringLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteralExpression(DoplerParser.StringLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#doubleLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleLiteralExpression(DoplerParser.DoubleLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#decisionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecisionType(DoplerParser.DecisionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(DoplerParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(DoplerParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#valueRestrictionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueRestrictionAction(DoplerParser.ValueRestrictionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#allows}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllows(DoplerParser.AllowsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#disallows}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisallows(DoplerParser.DisallowsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#enForce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnForce(DoplerParser.EnForceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#enumEnForce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumEnForce(DoplerParser.EnumEnForceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#stringEnForce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringEnForce(DoplerParser.StringEnForceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#booleanEnForce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanEnForce(DoplerParser.BooleanEnForceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DoplerParser#doubleEnForce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleEnForce(DoplerParser.DoubleEnForceContext ctx);
}