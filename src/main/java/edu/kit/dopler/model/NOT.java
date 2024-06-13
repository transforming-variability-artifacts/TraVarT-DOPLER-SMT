package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.stream.Stream;

public class NOT extends UnaryExpression{

    public NOT(IExpression child) {
        super(child);
    }


    @Override
    public boolean evaluate() throws EvaluationException {
        return !getChild().evaluate();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
        builder.add("(not ");
        getChild().toSMTStream(builder, callingDecisionConst);
        builder.add(")");
    }


}
