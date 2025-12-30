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

import com.google.ortools.sat.BoolVar;
import com.google.ortools.sat.CpModel;
import com.google.ortools.sat.IntVar;
import com.google.ortools.sat.Literal;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class BooleanDecision extends Decision<Boolean> {

    private AbstractValue<Boolean> value;

    public BooleanDecision(String displayId, String question, String description, IExpression visibilityCondition,
                           Set<Rule> rules) {
        super(displayId, question, description, visibilityCondition, rules, DecisionType.BOOLEAN);
        value = BooleanValue.getFalse();

    }

    @Override
    public void createCPVariables(CpModel model, Map<IDecision<?>, List<IntVar>> cpVars) {
        BoolVar boolVar = model.newBoolVar(this.getDisplayId());

        cpVars.put(this, List.of(boolVar));
    }

    @Override
    public void enforceStandardValueInCP(CpModel model, Map<IDecision<?>, List<IntVar>> cpVars, Map<IDecision<?>, Literal> isTakenVars) {
        Literal decisionVisibleLiteral = this.getVisibilityCondition().toCPLiteral(model, cpVars);

        //only enforce std value if dec is not visible and was not enforced by a rule-action (from another decision, of course)
        model.addEquality(cpVars.get(this).getFirst(), this.getStandardValue() ? model.trueLiteral() : model.falseLiteral())
                .onlyEnforceIf(new Literal[]{decisionVisibleLiteral.not(), isTakenVars.get(this) != null ? isTakenVars.get(this).not() : model.trueLiteral()});
    }

    @Override
    public Boolean getStandardValue() {
        return false;
    }

    @Override
    public IValue<Boolean> getValue() {
        return value;
    }

    @Override
    public void setValue(IValue<Boolean> value) {
        this.value = (Objects.requireNonNull(value.getValue())) ? BooleanValue.getTrue() : BooleanValue.getFalse();
        setSelected(value.getValue());
    }

    @Override
    public void setDefaultValueInSMT(Stream.Builder<String> builder) {
        builder.add(
                "(= " + toStringConstforSMT() + "_" + toStringConstforSMT() + "_POST" + " " + getStandardValue() + ")");
    }
}
