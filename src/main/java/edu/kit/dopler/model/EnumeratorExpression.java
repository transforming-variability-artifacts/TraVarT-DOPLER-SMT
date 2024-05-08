package edu.kit.dopler.model;

import java.util.stream.Stream;

public class EnumeratorExpression extends DecisionCallExpression{


    public EnumeratorExpression(IDecisionType decision) {
        super(decision);
    }

    @Override
    public boolean evaluate() {
      return false;
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        //not yet implemented
    }
}
