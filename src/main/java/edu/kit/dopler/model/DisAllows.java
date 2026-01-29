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
import edu.kit.dopler.exceptions.ActionExecutionException;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static edu.kit.dopler.common.CpUtils.getEnumDecisionLiteralVariableName;

public class DisAllows extends ValueRestrictionAction {

    public static final String FUNCTION_NAME = "disAllow";

    IValue<?> disAllowValue;

    public DisAllows(EnumerationDecision decisionType, IValue<?> disAllowValue) {
        super(decisionType);
        this.disAllowValue = disAllowValue;
    }

    @Override
    public void execute() throws ActionExecutionException {

        if (getDecision().getDecisionType() == Decision.DecisionType.ENUM) {
            EnumerationDecision decision = (EnumerationDecision) getDecision();
            decision.addDissallowed(new EnumerationLiteral((String) disAllowValue.getValue()));

        } else {
            throw new ActionExecutionException("Action only possible for EnumDecisions");
        }

    }

    @Override
    public void executeAsCP(CpModel model, Literal conditionLiteral, Map<IDecision<?>, List<IntVar>> decisionVars, Map<IDecision<?>, Literal> isTakenVars, Map<IDecision<?>, List<Literal>> isTakenConditions) {
        //dissallow can only be called on enum literals:

        String dissallowString = getEnumDecisionLiteralVariableName((EnumerationDecision) this.getDecision(), this.disAllowValue.getValue().toString());

        for (IntVar cpVar : decisionVars.get(this.getDecision())) {
            if (cpVar.getName().equals(dissallowString)) {
                model.addEquality(cpVar, model.falseLiteral())
                        .onlyEnforceIf(conditionLiteral);
            }
        }
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString) {
        builder.add("(distinct ");
        builder.add(selectedDecisionString + "_" + getDecision().toStringConstforSMT() + "_" + disAllowValue.getValue()
                + "_POST");
        builder.add("true");
        builder.add(")");
    }

    @Override
    public String toString() {
        return String.format("%s(%s.%s)", FUNCTION_NAME, getDecision().getDisplayId(), disAllowValue);
    }

    public IValue<?> getDisAllowValue() {
        return disAllowValue;
    }
}
