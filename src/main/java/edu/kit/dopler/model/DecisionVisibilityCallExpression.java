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
        try {
            builder.add("(= ");
            builder.add(String.valueOf(getDecision().isVisible()));
            builder.add(" true");
            builder.add(")");
        } catch (EvaluationException ignored) {

        }


    }
}
