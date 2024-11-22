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

import java.util.stream.Stream;

public class OR extends BinaryExpression {
	
	private static final String SYMBOL = "||";

	public OR(IExpression leftExpression, IExpression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public boolean evaluate() throws EvaluationException {
		if (getLeftExpression() instanceof BooleanLiteralExpression
				&& getRightExpression() instanceof DecisionValueCallExpression) {
			boolean left = ((BooleanLiteralExpression) getLeftExpression()).getLiteral();
			boolean right = (boolean) ((DecisionValueCallExpression) getRightExpression()).getValue().getValue();
			return left || right;
		} else if (getLeftExpression() instanceof DecisionValueCallExpression
				&& getRightExpression() instanceof BooleanLiteralExpression) {
			boolean left = (boolean) ((DecisionValueCallExpression) getLeftExpression()).getValue().getValue();
			boolean right = ((BooleanLiteralExpression) getRightExpression()).getLiteral();
			return left || right;
		} else if (getLeftExpression() instanceof BooleanLiteralExpression
				&& getRightExpression() instanceof BooleanLiteralExpression) {
			boolean right = ((BooleanLiteralExpression) getRightExpression()).getLiteral();
			boolean left = ((BooleanLiteralExpression) getLeftExpression()).getLiteral();
			return left || right;
		} else if (getLeftExpression() instanceof BinaryExpression
				&& getRightExpression() instanceof BinaryExpression) {
			return getLeftExpression().evaluate() && getRightExpression().evaluate();
		} else {
			throw new EvaluationException("Only Boolean Values Supported");
		}
	}

	@Override
	public void toSMTStream(Stream.Builder<String> builder, String callingDecision) {
		builder.add("(or ");
		getLeftExpression().toSMTStream(builder, callingDecision);
		getRightExpression().toSMTStream(builder, callingDecision);
		builder.add(")");

	}

	@Override
	public String toString() {
		return String.format("(%s " + SYMBOL + " %s)", getLeftExpression(), getRightExpression());
	}
}
