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

import java.util.ArrayList;
import java.util.Collections;
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
    public void createCPVariables(CpModel model, ArrayList<IntVar> variables) {
        BoolVar boolVar = model.newBoolVar(this.getDisplayId());

        variables.add(boolVar);
        this.cpVars = new ArrayList<>(Collections.singleton(boolVar));
    }

    @Override
    public void mapRulesToCP(CpModel model) { //TODO nur temporär hier zum austesten!!!! -> Frage: wie macht man das generell bei anderen concrete decisions bzw dann in der Decision class?
        Literal decisionVisibleLiteral = this.getVisibilityCondition().toCPLiteral(model);

        for (Rule rule : this.getRules()) {
            Literal ruleCondtionLiteral = rule.getCondition().toCPLiteral(model);

            Literal l = model.newBoolVar("decisionVisible_AND_ruleCondition");
            // assure that: l <=> (decisionVisibleLiteral and ruleCondtionLiteral)
            // =>
            model.addImplication(l, decisionVisibleLiteral);
            model.addImplication(l, ruleCondtionLiteral);
            // <=
            model.addBoolOr(new Literal[]{decisionVisibleLiteral.not(), ruleCondtionLiteral.not(), l});

            for (IAction action : rule.getActions()) {
                action.executeAsCP(model, l);
            }

        }

        //TODO das ist grad das wichtige hier:
        //only enforce std value if dec is not visible and was not already enforced by a rule-action
        model.addEquality(this.getCPVars().getFirst(), this.getStandardValue() ? model.trueLiteral() : model.falseLiteral())
                .onlyEnforceIf(new Literal[]{decisionVisibleLiteral.not(), this.getTakenInCP() != null ? this.getTakenInCP().not() : model.trueLiteral()});
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
