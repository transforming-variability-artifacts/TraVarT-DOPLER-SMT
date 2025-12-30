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
import edu.kit.dopler.common.CpEncodingResult;
import edu.kit.dopler.exceptions.EvaluationException;
import edu.kit.dopler.exceptions.ValidityConditionException;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class NumberDecision extends ValueDecision<Double> {

    private final AbstractValue<Double> value;
    private final double standardValue = 0.0;

    public NumberDecision(String displayId, String question, String description, IExpression visibilityCondition,
                          Set<Rule> rules, Set<IExpression> validityConditions) {
        super(displayId, question, description, visibilityCondition, rules, validityConditions, DecisionType.NUMBER);
        value = new DoubleValue(standardValue);
    }

    @Override
    public void createCPVariables(CpModel model, Map<IDecision<?>, List<IntVar>> cpVars) {
        IntVar intVar = model.newIntVar(0, 120000, this.getDisplayId()); //todo later eig müsste hier Long min und max rein aber damit kann der solver nicht umgehen... - desshalb grad magic numbers -> bessere überlegen: Besser gehts nur wenn man den unteren todo umsetzt

        cpVars.put(this, List.of(intVar));

        for (IExpression expression : this.getValidityConditions()) { //the range is encoded in the validityConditions
            //todo later: hier könnte man wenn man für die range halt auch ganz easy model.addLinearConstraint() nutzen ohne extra overhead (vor allem da bei der range immer konkrete variablen genutzt werden) -> aber wsh nicht umsetzbar wegen dem dopler metamodell... (?)
            model.addEquality(expression.toCPLiteral(model, cpVars), 1);
        }
    }

    @Override
    public void enforceStandardValueInCP(CpModel model, Map<IDecision<?>, List<IntVar>> cpVars, Map<IDecision<?>, Literal> isTakenVars) {
        Literal decisionVisibleLiteral = this.getVisibilityCondition().toCPLiteral(model, cpVars);

        //only enforce std value if dec is not visible and was not enforced by a rule-action (from another decision, of course)
        model.addEquality(cpVars.get(this).getFirst(), model.newConstant(CpEncodingResult.scaleDoubleToCp(this.standardValue))) //todo later es ist design mäßig evtl. nicht so schön, dass dass CpEncodingResult diese scaling funktionalität static anbietet... ggf auslagern(?)
                .onlyEnforceIf(new Literal[]{decisionVisibleLiteral.not(), isTakenVars.get(this) != null ? isTakenVars.get(this).not() : model.trueLiteral()});
    }

    @Override
    public Double getStandardValue() {
        return standardValue;
    }

    @Override
    public IValue<Double> getValue() {
        return value;
    }

    @Override
    public void setValue(IValue<Double> value) throws ValidityConditionException {
        Double v = Objects.requireNonNull(value.getValue());
        this.value.setValue(v);
        try {
            if (checkValidity()) {
                setTaken(true);
            } else {

                this.value.setValue(standardValue);
                throw new ValidityConditionException("Value: " + v + "does not fullfil validity condition");
            }
        } catch (EvaluationException e) {
            throw new ValidityConditionException(e);
        }

    }

    @Override
    public void setDefaultValueInSMT(Stream.Builder<String> builder) {
        builder.add(
                "(= " + toStringConstforSMT() + "_" + toStringConstforSMT() + "_POST" + " " + getStandardValue() + ")");
    }
}
