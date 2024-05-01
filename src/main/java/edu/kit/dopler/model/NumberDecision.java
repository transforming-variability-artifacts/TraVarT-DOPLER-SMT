package edu.kit.dopler.model;

import java.util.Set;

public class NumberDecision extends ValueDecision{


    public NumberDecision(String question, String description, IExpression visibilityCondition, Set<IExpression> validityConditions) {
        super(question, description, visibilityCondition, validityConditions);
    }
}
