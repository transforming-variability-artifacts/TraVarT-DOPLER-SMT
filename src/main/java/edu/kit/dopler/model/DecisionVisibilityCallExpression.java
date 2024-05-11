package edu.kit.dopler.model;

import java.util.stream.Stream;

public class DecisionVisibilityCallExpression extends DecisionCallExpression{



    public DecisionVisibilityCallExpression(IDecision decision) {
        super(decision);
    }

    @Override
    public boolean evaluate() {
        return getDecision().isVisible();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        //not yet implemented
    }
}
