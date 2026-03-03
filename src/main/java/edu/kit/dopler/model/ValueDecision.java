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

import com.google.ortools.sat.CpModel;
import com.google.ortools.sat.IntVar;
import com.google.ortools.sat.Literal;
import edu.kit.dopler.exceptions.EvaluationException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public abstract class ValueDecision<T> extends Decision<T> {

    private Set<IExpression> validityConditions = Collections.emptySet();

    protected ValueDecision(String displayId, String question, String description, IExpression visibilityCondition,
                            Set<Rule> rules, Set<IExpression> validityConditions, DecisionType decisionType) {
        super(displayId, question, description, visibilityCondition, rules, decisionType);
        this.validityConditions = validityConditions;
    }

    public Set<IExpression> getValidityConditions() {
        return validityConditions;
    }

    public void setValidityConditions(Set<IExpression> validityConditions) {
        this.validityConditions = validityConditions;
    }

    public boolean checkValidity() throws EvaluationException {
        for (IExpression expression : validityConditions) {
            if (!expression.evaluate()) {
                return false;
            }
        }
        return true;
    }

    @Override
    void toSMTStreamDecisionSpecific(Stream.Builder<String> builder, Set<? super IDecision<?>> decisions) {
        if (!getValidityConditions().isEmpty()) {
            builder.add("(ite ");
            builder.add("(and");
            for (IExpression expression : getValidityConditions()) {
                expression.toSMTStream(builder, toStringConstforSMT());
            }
            builder.add(")"); // closing and of the ValidityExpressions
            toSMTStreamRules(builder, decisions); // if part
            mapPreToPostConstants(builder, decisions); // else part
            builder.add(")"); // closing the ite of validityConditions

        } else {
            toSMTStreamRules(builder, decisions);
        }
    }

    /**
     * Adds constraints that enforce validity conditions for a decision if necessary (= if it is taken)
     *
     * @param model        the constraint programming model to which the constraints will be added
     * @param decisionVars a map associating each decision of a dopler model with a list of CP variables representing it
     * @param isTakenVars  a map associating each decision of a dopler model with a boolean literal indicating whether the decision is taken
     */
    protected abstract void enforceValidityConditionsInCp(CpModel model, Map<IDecision<?>, List<IntVar>> decisionVars, Map<IDecision<?>, Literal> isTakenVars);
}
