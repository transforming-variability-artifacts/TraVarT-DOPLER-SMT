package edu.kit.dopler.model;

import java.util.stream.Stream;

public class DecisionValueCallExpression extends DecisionCallExpression{


    public DecisionValueCallExpression(IDecision decision) {
        super(decision);
    }


    @Override
    public boolean evaluate() {
        return getDecision().isTaken();
    }

    public IValue<?> getValue(){
       return getDecision().getValue();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {

        builder.add(" " + callingDecisionConst + "_" + getDecision().toStringConstforSMT() + "_PRE ");




    }
}
