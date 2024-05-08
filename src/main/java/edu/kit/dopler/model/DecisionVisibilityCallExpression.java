package edu.kit.dopler.model;

import java.util.stream.Stream;

public class DecisionVisibilityCallExpression extends DecisionCallExpression{




    private boolean visible;

    public DecisionVisibilityCallExpression(IDecisionType decision, boolean visible) {
        super(decision);
        this.visible = visible;
    }

    @Override
    public boolean evaluate() {
        return visible;
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        //not yet implemented
    }
}
