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
    public void toSMTStream(Stream.Builder<String> builder) {
        //not yet implemented
    }
}
