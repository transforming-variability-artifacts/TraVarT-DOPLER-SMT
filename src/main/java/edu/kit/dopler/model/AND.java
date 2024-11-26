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

import java.util.stream.Stream;

import edu.kit.dopler.exceptions.EvaluationException;

public class AND extends BinaryExpression {

	private static final String SYMBOL = "&&";

	public AND(final IExpression leftExpression, final IExpression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public boolean evaluate() throws EvaluationException {
		if (getLeftExpression() instanceof final BooleanLiteralExpression leftExpression
				&& getRightExpression() instanceof final DecisionValueCallExpression rightExpression) {
			final boolean left = leftExpression.getLiteral();
			final boolean right = (boolean) rightExpression.getValue().getValue();
			return left && right;
		}
		if (getLeftExpression() instanceof final DecisionValueCallExpression leftExpression
				&& getRightExpression() instanceof final BooleanLiteralExpression rightExpression) {
			final boolean left = (boolean) leftExpression.getValue().getValue();
			final boolean right = rightExpression.getLiteral();
			return left && right;
		}
		if (getLeftExpression() instanceof final BooleanLiteralExpression leftExpression
				&& getRightExpression() instanceof final BooleanLiteralExpression rightExpression) {
			final boolean right = rightExpression.getLiteral();
			final boolean left = leftExpression.getLiteral();
			return left && right;
		}
		if (getLeftExpression() instanceof BinaryExpression
				&& getRightExpression() instanceof BinaryExpression) {
			return getLeftExpression().evaluate() && getRightExpression().evaluate();
		}
		throw new EvaluationException("Only Boolean Values Supported");
	}

	/**
	 * The boolean AND can be encoded to the SMT Encoding by simply adding (and
	 * (leftExpression) (rightExpression))
	 *
	 * @param builder the stream builder, where the condition is added
	 */
	@Override
	public void toSMTStream(final Stream.Builder<String> builder, final String callingDecision) {
		builder.add("(and ");
		getLeftExpression().toSMTStream(builder, callingDecision);
		getRightExpression().toSMTStream(builder, callingDecision);
		builder.add(")");
	}

	@Override
	public String toString() {
		return String.format("(%s " + SYMBOL + " %s)", getLeftExpression(), getRightExpression());
	}
}
