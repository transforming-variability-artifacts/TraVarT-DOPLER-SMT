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
        throw new UnsupportedOperationException("Not supported yet.");
        //PROBLEM: keine double unterstützung von CP solver...
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
