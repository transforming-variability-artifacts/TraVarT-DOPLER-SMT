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
import edu.kit.dopler.common.CpUtils;
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
    public void createCPVariables(CpModel model, Map<IDecision<?>, List<IntVar>> decisionVars) {
        IntVar intVar = model.newIntVar(0, 1_000_000, this.getDisplayId()); //todo later: eig müsste hier Long min und max rein (statt magic numbers) aber damit kann der solver nicht umgehen... man kann das problem nur lösen wenn man die range direkt parsed und hier als double variables zur verfügung stehen hat. So wie es jetzt gerade ist (als expressions) geht es nicht / bzw. man müsste halt wieder instanceoff benutzen und wenn mal mehr validity conditions kommen würde es crashen...

        decisionVars.put(this, List.of(intVar));
    }

    @Override
    public void enforceStandardValueInCP(CpModel model, Map<IDecision<?>, List<IntVar>> decisionVars, Map<IDecision<?>, Literal> isTakenVars) {
        model.addEquality(decisionVars.get(this).getFirst(), model.newConstant(CpUtils.scaleDoubleToLong(this.standardValue)))
                .onlyEnforceIf(isTakenVars.get(this).not());

        //add range constraints (only if the decision is taken)
        for (IExpression expression : this.getValidityConditions()) { //the range is encoded in the validityConditions
            model.addEquality(expression.toCPLiteral(model, decisionVars, isTakenVars), model.trueLiteral())
                    .onlyEnforceIf(isTakenVars.get(this));
        }
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
