package edu.kit.dopler.model;

public class EnumeratorExpression extends DecisionCallExpression{


    public EnumeratorExpression(IDecisionType decision) {
        super(decision);
    }

    @Override
    public boolean evaluate() {
      return false;
    }
}
