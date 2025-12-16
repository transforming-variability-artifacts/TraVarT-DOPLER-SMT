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
 *    @author Johannes von Geisau
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.model;

import com.google.ortools.sat.CpModel;
import com.google.ortools.sat.IntVar;
import com.google.ortools.sat.Literal;
import edu.kit.dopler.exceptions.EvaluationException;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DecisionVisibilityCallExpression extends DecisionCallExpression {

    public DecisionVisibilityCallExpression(IDecision decision) {
        super(decision);
    }

    @Override
    public boolean evaluate() throws EvaluationException {
        return getDecision().isVisible();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
        if (getDecision().getVisibilityCondition() instanceof LiteralExpression) {
            try {
                if (getDecision().getVisibilityCondition().evaluate()) {
                    builder.add("(= " + "true" + " " + "true" + ")");
                } else {
                    builder.add("(= " + "true" + " " + "false" + ")");
                }
            } catch (EvaluationException e) {
                throw new RuntimeException(e);
            }
        } else {
            getDecision().getVisibilityCondition().toSMTStream(builder, callingDecisionConst);
        }
    }

    @Override
    public Literal toCPLiteral(CpModel model, Map<IDecision<?>, List<IntVar>> cpVars) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return String.format("getValue(%s)", getDecision());
    }
}
