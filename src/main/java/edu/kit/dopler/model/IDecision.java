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
import edu.kit.dopler.exceptions.EvaluationException;
import edu.kit.dopler.exceptions.ValidityConditionException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public interface IDecision<T> {

    String getDisplayId();

    void setDisplayId(String displayId);

    String getQuestion();

    void setQuestion(String question);

    String getDescription();

    void setDescription(String description);

    Set<Rule> getRules();

    void addRule(Rule rule);

    void removeRule(Rule rule);

    void executeRules() throws ActionExecutionException, EvaluationException;

    T getStandardValue();

    IValue<T> getValue();

    void setValue(IValue<T> value) throws ValidityConditionException;

    boolean isSelected();

    void setSelected(final boolean select);

    IExpression getVisibilityCondition();

    void setVisibilityCondition(IExpression visibilityCondition);

    boolean isVisible() throws EvaluationException;

    void toSMTStream(Stream.Builder<String> builder, Set<? super IDecision<?>> decisions);

    boolean isTaken();

    void setTaken(boolean taken);

    String toStringConstforSMT();

    void setDefaultValueInSMT(Stream.Builder<String> builder);

    void toSMTStreamRules(Stream.Builder<String> builder, Set<? super IDecision<?>> decisions);

    Decision.DecisionType getDecisionType();

    /**
     * Creates CP variable(s) representing the current decision.
     * The variables are added to the CP model and stored in the decisionVars map.
     *
     * @param model        the constraint programming model to which the variables will be added
     * @param decisionVars a map associating each decision of a dopler model with a list of CP variables representing it
     */
    void createCPVariables(CpModel model, Map<IDecision<?>, List<IntVar>> decisionVars);

    /**
     * Maps the rules associated with the current decisions into the CP model.
     * This involves adding constraints, representing the rules and their actions, to the model.
     * Additionally, the isTakenConditions map gets filled with CP literals, each indicating whether a rule-action did enforce the value of a decision or not
     *
     * @param model             the constraint programming model to which the constraints will be added
     * @param decisionVars      a map associating each decision of a dopler model with a list of CP variables representing it
     * @param isTakenVars       a map associating each decision of a dopler model with a boolean literal indicating whether the decision is taken
     * @param isTakenConditions a (helper) map associating each decision of a dopler model with a list of boolean literals that can later be used to add constraints for isTakenVars to be logically correct in the model
     */
    void mapRulesToCP(CpModel model, Map<IDecision<?>, List<IntVar>> decisionVars, Map<IDecision<?>, Literal> isTakenVars, Map<IDecision<?>, List<Literal>> isTakenConditions);

    /**
     * Adds constraints that enforce a standard (default) value for the current decision if necessary (= if it is not taken).
     *
     * @param model        the constraint programming model to which the constraints will be added
     * @param decisionVars a map associating each decision of a dopler model with a list of CP variables representing it
     * @param isTakenVars  a map associating each decision of a dopler model with a boolean literal indicating whether the decision is taken
     */
    void enforceStandardValueInCP(CpModel model, Map<IDecision<?>, List<IntVar>> decisionVars, Map<IDecision<?>, Literal> isTakenVars);
}