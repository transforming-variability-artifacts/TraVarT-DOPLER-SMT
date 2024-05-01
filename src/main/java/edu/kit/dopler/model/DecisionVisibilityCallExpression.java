package edu.kit.dopler.model;

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
}
