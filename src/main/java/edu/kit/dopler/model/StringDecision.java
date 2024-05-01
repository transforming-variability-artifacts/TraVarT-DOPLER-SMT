package edu.kit.dopler.model;

import java.util.Set;

public class StringDecision extends ValueDecision{


    public StringDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules, Set<IExpression> validityConditions) {
        super(question, description, visibilityCondition, taken, rules, validityConditions);
    }
}
