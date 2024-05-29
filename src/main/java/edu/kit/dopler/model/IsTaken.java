package edu.kit.dopler.model;

import java.util.stream.Stream;

public class IsTaken extends DecisionCallExpression{



    public IsTaken(IDecision decision) {
        super(decision);
    }


    @Override
    public boolean evaluate() {
        return getDecision().isTaken();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
        builder.add("(distinct");
        builder.add(getDecision().getValue().getValue().toString());
        builder.add(" ");
        builder.add(getDecision().getStandardValue().toString());
        builder.add(")");
    }
}
