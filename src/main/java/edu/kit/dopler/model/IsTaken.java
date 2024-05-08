package edu.kit.dopler.model;

import java.util.stream.Stream;

public class IsTaken extends DecisionCallExpression{



    private boolean taken;

    public IsTaken(IDecisionType decision, boolean taken) {
        super(decision);
        this.taken = taken;
    }
    // ???? klingt eher nach einer Methode


    @Override
    public boolean evaluate() {
        return taken;
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        //not yet implemented
    }
}
