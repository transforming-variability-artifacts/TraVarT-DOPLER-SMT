package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

public abstract class ValueDecision<T> extends Decision<T> {



    private Set<IExpression> validityConditions = Collections.emptySet();

    public ValueDecision(String displayId, String question, String description, IExpression visibilityCondition, Set<Rule> rules, Set<IExpression> validityConditions, DecisionType decisionType) {
        super(displayId, question, description, visibilityCondition, rules,decisionType);
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
    void toSMTStreamValidityConditions(Stream.Builder<String> builder, Set<? super IDecision<?>> decisions) {
        if(!getValidityConditions().isEmpty()) {
            builder.add("(ite ");
            builder.add("(and");
            for (IExpression expression : getValidityConditions()){
                expression.toSMTStream(builder, toStringConstforSMT());
            }
            builder.add(")"); // closing and of the ValidityExpressions
            toSMTStreamRules(builder, decisions); //if part
            mapPreToPostConstants(builder, decisions); //else part
            builder.add(")"); //closing the ite of validityConditions

        }else{
            toSMTStreamRules(builder,decisions);
        }
    }
}
