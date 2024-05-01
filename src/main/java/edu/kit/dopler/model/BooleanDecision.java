package edu.kit.dopler.model;

import java.util.Set;

public class BooleanDecision extends DecisionType {


    public BooleanDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules) {
        super(question, description, visibilityCondition, taken, rules);
    }
}
