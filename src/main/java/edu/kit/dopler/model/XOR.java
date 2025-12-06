/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 *    @author Fabian Eger
 *    @author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.stream.Stream;

public class XOR extends BinaryExpression {

    private static final String SYMBOL = "^";

    public XOR(final IExpression leftExpression, final IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() throws EvaluationException {
        if (getLeftExpression() instanceof final BooleanLiteralExpression leftExpression
                && getRightExpression() instanceof final DecisionValueCallExpression rightExpression) {
            final boolean left = leftExpression.getLiteral();
            final boolean right = (boolean) rightExpression.getValue().getValue();
            return left ^ right;
        }
        if (getLeftExpression() instanceof final DecisionValueCallExpression leftExpression
                && getRightExpression() instanceof final BooleanLiteralExpression rightExpression) {
            final boolean left = (boolean) leftExpression.getValue().getValue();
            final boolean right = rightExpression.getLiteral();
            return left ^ right;
        } else if (getLeftExpression() instanceof final BooleanLiteralExpression leftExpression
                && getRightExpression() instanceof final BooleanLiteralExpression rightExpression) {
            final boolean right = rightExpression.getLiteral();
            final boolean left = leftExpression.getLiteral();
            return left ^ right;
        } else {
            throw new EvaluationException("Only Boolean Values Supported");
        }

    }

    @Override
    public void toSMTStream(final Stream.Builder<String> builder, final String callingDecision) {
        if (getLeftExpression() instanceof BooleanLiteralExpression
                || getLeftExpression() instanceof DecisionValueCallExpression
                || getRightExpression() instanceof DecisionValueCallExpression
                || getRightExpression() instanceof BooleanLiteralExpression) {
            builder.add("(xor ");
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
