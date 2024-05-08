package edu.kit.dopler.model;

import java.util.Set;
import java.util.stream.Stream;

public class NumberDecision extends ValueDecision{


    public NumberDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules, Set<IExpression> validityConditions) {
        super(question, description, visibilityCondition, taken, rules, validityConditions);
    }

    // as it stands this could be moved to abstract class ValueDecision and use of a decorator to add behaviour
    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        //not yet implemented
        builder.add("(ite");
        getVisibilityCondition().toSMTStream(builder);
        if(!getValidityConditions().isEmpty()) {
            builder.add("(ite");
            //may check if size == 1 because i dont know what happens if in Smt and only gets one parameter
            builder.add("(and");
            for (IExpression expression : getValidityConditions()){
                expression.toSMTStream(builder);
            }
            builder.add(")"); // closing the and of the ValidityExpressions
            builder.add(")"); //closing the ite of validityConditions
        }
        builder.add(")"); //closing the ite of the visibilityDecision
    }
}
