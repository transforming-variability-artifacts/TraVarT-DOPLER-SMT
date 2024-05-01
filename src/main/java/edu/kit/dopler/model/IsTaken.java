package edu.kit.dopler.model;

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
}
