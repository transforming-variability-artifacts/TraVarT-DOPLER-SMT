/*******************************************************************************
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 * 	@author Fabian Eger
 * 	@author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 * All rights reserved
 *******************************************************************************/
package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;
import edu.kit.dopler.exceptions.InvalidTypeInLiteralExpressionCheckException;

import java.util.stream.Stream;

public class Equals extends BinaryExpression {

	private static final String SYMBOL = "=";

	public Equals(IExpression leftExpression, IExpression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public boolean evaluate() throws EvaluationException {

		try {
			if (getLeftExpression() instanceof LiteralExpression
					&& getRightExpression() instanceof DecisionValueCallExpression) {
				IValue<?> right = ((DecisionValueCallExpression) getRightExpression()).getValue();
				return ((LiteralExpression) getLeftExpression()).equalsForLiteralExpressions(right);
			}
			if (getLeftExpression() instanceof DecisionValueCallExpression
					&& getRightExpression() instanceof LiteralExpression) {
				IValue<?> left = ((DecisionValueCallExpression) getLeftExpression()).getValue();
				return ((LiteralExpression) getRightExpression()).equalsForLiteralExpressions(left);
			}

			return getLeftExpression() == getRightExpression();
		} catch (InvalidTypeInLiteralExpressionCheckException e) {
			throw new EvaluationException(e);
		}

	}

	public void toSMTStreamEquals(Stream.Builder<String> builder, String callingDecision, IDecision<?> decision,
			IExpression expression) {
		if (decision.getDecisionType() == Decision.DecisionType.ENUM) {
			EnumeratorLiteralExpression enumeratorLiteralExpression = (EnumeratorLiteralExpression) expression;
			builder.add("(= ");
			builder.add(" " + callingDecision + "_" + decision.toStringConstforSMT() + "_"
					+ enumeratorLiteralExpression.getEnumerationLiteral().getValue() + "_PRE");
			builder.add("true");
			builder.add(")");
		} else {
			builder.add("(= ");
			getLeftExpression().toSMTStream(builder, callingDecision);
			getRightExpression().toSMTStream(builder, callingDecision);
			builder.add(")");
		}
	}

	@Override
	public void toSMTStream(Stream.Builder<String> builder, String callingDecision) {
		if (getRightExpression() instanceof DecisionValueCallExpression) {
			builder.add("(and");
			IDecision<?> decision = ((DecisionValueCallExpression) getRightExpression()).getDecision();
			builder.add("(= " + decision.toStringConstforSMT() + "_TAKEN_POST" + " " + "true" + ")"); // checks that the
																										// decision also
																										// needs to be
																										// taken because
																										// of the
																										// encoding
			toSMTStreamEquals(builder, callingDecision, decision, getLeftExpression());
			builder.add(")"); // closing and
		} else if (getLeftExpression() instanceof DecisionValueCallExpression) {
			builder.add("(and");
			IDecision<?> decision = ((DecisionValueCallExpression) getLeftExpression()).getDecision();
			builder.add("(= " + decision.toStringConstforSMT() + "_TAKEN_POST" + " " + "true" + ")"); // checks that the
																										// decision also
																										// needs to be
																										// taken because
																										// of the
																										// encoding
			toSMTStreamEquals(builder, callingDecision, decision, getRightExpression());
			builder.add(")"); // closing and
		} else {
			builder.add("(= ");
			getLeftExpression().toSMTStream(builder, callingDecision);
			getRightExpression().toSMTStream(builder, callingDecision);
			builder.add(")");
		}
	}

	@Override
	public String toString() {
		return String.format("(%s " + SYMBOL + " %s)", getLeftExpression(), getRightExpression());
	}
}
