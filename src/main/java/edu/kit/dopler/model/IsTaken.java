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

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class IsTaken extends DecisionCallExpression {

    public static final String FUNCTION_NAME = "isTaken";

    public IsTaken(IDecision decision) {
        super(decision);
    }

    @Override
    public boolean evaluate() {
        return getDecision().isTaken();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
        builder.add("(= ");
        builder.add(getDecision().toStringConstforSMT() + "_TAKEN_POST");
        builder.add(" ");
        builder.add("true");
        builder.add(")");
    }

    @Override
    public Literal toCPLiteral(CpModel model, Map<IDecision<?>, List<IntVar>> cpVars) {
        /*  for the CP encoding we assume: a decision is/must/"will be" be taken if it is visible (we ignore cases where a decision is enforced via a rule-action)
            otherwise we would need the isTakenVars map here, but this would lead to wierd special cases, for example (is the rule "if(!isTaken(Cheese)){Cheese=true;}" valid?)
            we don't care about this here because apparently "isTaken()" is not used in real world DOPLER-models... */
        return this.getDecision().getVisibilityCondition().toCPLiteral(model, cpVars);
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", FUNCTION_NAME, getDecision());
    }
}
