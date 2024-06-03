package edu.kit.dopler.model;

import java.util.stream.Stream;

public class EnumeratorLiteralExpression extends DecisionCallExpression{


    public EnumeratorLiteralExpression(IDecision decision) {
        super(decision);
    }

    @Override
    public boolean evaluate() {
      return false;
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
        builder.add(" " + getDecision().getValue().getValue().toString() + " ");
    }
}
