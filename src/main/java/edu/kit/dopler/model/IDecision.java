/*******************************************************************************
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 * 	@author Fabian Eger
 * 	@author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 * All rights reserved
 *******************************************************************************/
package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;
import edu.kit.dopler.exceptions.EvaluationException;
import edu.kit.dopler.exceptions.ValidityConditionException;

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

    void setSelected(final boolean select);
    boolean isSelected();

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
}