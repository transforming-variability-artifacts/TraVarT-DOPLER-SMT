package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.stream.Stream;

public class DecisionVisibilityCallExpression extends DecisionCallExpression{



    public DecisionVisibilityCallExpression(IDecision decision) {
        super(decision);
    }

    @Override
    public boolean evaluate() throws EvaluationException {
        return getDecision().isVisible();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
        //not yet implemented
    }
}
