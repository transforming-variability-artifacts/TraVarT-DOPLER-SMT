package edu.kit.dopler.model;

import java.util.Collections;
import java.util.Set;

public abstract class ValueDecision<T> extends DecisionType<T>{



    private Set<IExpression> validityConditions = Collections.emptySet();

    public ValueDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules, Set<IExpression> validityConditions) {
        super(question, description, visibilityCondition, taken, rules);
        this.validityConditions = validityConditions;
    }


    public Set<IExpression> getValidityConditions() {
        return validityConditions;
    }

    public void setValidityConditions(Set<IExpression> validityConditions) {
        this.validityConditions = validityConditions;
    }

}
