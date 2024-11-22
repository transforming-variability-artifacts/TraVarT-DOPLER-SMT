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

public class LessThan extends BinaryExpression {

	private static final String SYMBOL = "<";

	public LessThan(IExpression leftExpression, IExpression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public boolean evaluate() throws EvaluationException {

		if (getLeftExpression() instanceof DoubleLiteralExpression
				&& getRightExpression() instanceof DecisionValueCallExpression) {
			double left = ((DoubleLiteralExpression) getLeftExpression()).getLiteral();
			double right = (double) ((DecisionValueCallExpression) getRightExpression()).getValue().getValue();
			return left < right;
		} else if (getLeftExpression() instanceof DecisionValueCallExpression
				&& getRightExpression() instanceof DoubleLiteralExpression) {
			double left = (double) ((DecisionValueCallExpression) getLeftExpression()).getValue().getValue();
			double right = ((DoubleLiteralExpression) getRightExpression()).getLiteral();
			return left < right;
		} else if (getLeftExpression() instanceof DoubleLiteralExpression
				&& getRightExpression() instanceof DoubleLiteralExpression) {
			double right = ((DoubleLiteralExpression) getRightExpression()).getLiteral();
			double left = ((DoubleLiteralExpression) getLeftExpression()).getLiteral();
			return left < right;
		} else if (getLeftExpression() instanceof DecisionValueCallExpression
				&& getRightExpression() instanceof StringLiteralExpression) {
			String left = (String) ((DecisionValueCallExpression) getLeftExpression()).getValue().getValue();
			String right = ((StringLiteralExpression) getRightExpression()).getLiteral();
			return left.compareTo(right) < 0;
		} else if (getLeftExpression() instanceof StringLiteralExpression
				&& getRightExpression() instanceof StringLiteralExpression) {
			String left = ((StringLiteralExpression) getRightExpression()).getLiteral();
			String right = ((StringLiteralExpression) getLeftExpression()).getLiteral();
			return left.compareTo(right) < 0;
		} else if (getLeftExpression() instanceof StringLiteralExpression
				&& getRightExpression() instanceof DecisionValueCallExpression) {
			String left = ((StringLiteralExpression) getLeftExpression()).getLiteral();
			String right = (String) ((DecisionValueCallExpression) getRightExpression()).getValue().getValue();
			return left.compareTo(right) < 0;
		} else {
			throw new EvaluationException("Only Double and String Values Supported");
		}
	}

	/**
	 * lexicographically ordering is not supported for String in the SMT Encoding at
	 * the moment in z3 it is possible -> see
	 * https://microsoft.github.io/z3guide/docs/theories/Strings/ and
	 * https://link.springer.com/chapter/10.1007/978-3-030-90870-6_21 but we wanted
	 * to keep the Encoding open for all Solvers that support SMT Encoding
	 */
	@Override
	public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
		if (getLeftExpression() instanceof DoubleLiteralExpression
				|| getLeftExpression() instanceof DecisionValueCallExpression
				|| getRightExpression() instanceof DecisionValueCallExpression
				|| getRightExpression() instanceof DoubleLiteralExpression) {
			builder.add("(< ");
			getLeftExpression().toSMTStream(builder, callingDecisionConst);
			getRightExpression().toSMTStream(builder, callingDecisionConst);
			builder.add(")");
		}
	}

	@Override
	public String toString() {
		return String.format("(%s " + SYMBOL + " %s)", getLeftExpression(), getRightExpression());
	}
}
