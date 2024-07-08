package edu.kit.dopler.model;

import java.util.stream.Stream;

public class IsTaken extends DecisionCallExpression{



    public static final String FUNCTION_NAME = "isTaken";

	public IsTaken(IDecision decision) {
        super(decision);
    }


    @Override
    public boolean evaluate() {
        return getDecision().isTaken();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
        builder.add("(= ");
        builder.add(getDecision().toStringConstforSMT() + "_TAKEN_POST");
        builder.add(" ");
        builder.add("true");
        builder.add(")");
    }
}
