package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

public abstract class ValueDecision<T> extends Decision<T> {



    private Set<IExpression> validityConditions = Collections.emptySet();

    public ValueDecision(String id,String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules, Set<IExpression> validityConditions, DecisionType decisionType) {
        super(id, question, description, visibilityCondition, taken, rules,decisionType);
        this.validityConditions = validityConditions;
    }


    public Set<IExpression> getValidityConditions() {
        return validityConditions;
    }

    public void setValidityConditions(Set<IExpression> validityConditions) {
        this.validityConditions = validityConditions;
    }

    public boolean checkValidity() throws EvaluationException {
        for(IExpression expression: validityConditions){
            if(! expression.evaluate()){
                return false;
            }
        }
        return true;
    }


    @Override
    void toSMTStreamDecisionSpecific(Stream.Builder<String> builder) {
        if(!getValidityConditions().isEmpty()) {
            builder.add("(ite");
            //may check if size == 1 because i dont know what happens if in Smt and only gets one parameter
            builder.add("(and");
            for (IExpression expression : getValidityConditions()){
                expression.toSMTStream(builder);
            }
            builder.add(")"); // closing and of the ValidityExpressions
            toSMTStreamValueDecisionSpecific(builder);
            builder.add(")"); //closing the ite of validityConditions
        }else{
            toSMTStreamValueDecisionSpecific(builder);
        }


    }

    abstract void toSMTStreamValueDecisionSpecific(Stream.Builder<String> builder);
}
