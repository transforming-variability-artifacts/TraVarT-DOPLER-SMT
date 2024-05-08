package edu.kit.dopler.model;

import java.util.Set;
import java.util.stream.Stream;

public class BooleanDecision extends DecisionType {


    public BooleanDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules) {
        super(question, description, visibilityCondition, taken, rules);
    }


    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(ite");
        getVisibilityCondition().toSMTStream(builder);


        builder.add(")");
    }
}
