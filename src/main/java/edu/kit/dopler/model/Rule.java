package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;
import edu.kit.dopler.exceptions.EvaluationException;

import java.util.Set;

public class Rule {

    private IExpression condition;
    private Set<IAction> actions;

    public Rule(IExpression condition, Set<IAction> actions) {
        this.condition = condition;
        this.actions = actions;
    }


    public IExpression getCondition() {
        return condition;
    }

    public void setCondition(IExpression condition) {
        this.condition = condition;
    }

    public Set<IAction> getActions() {
        return actions;
    }

    public void setActions(Set<IAction> actions) {
        this.actions = actions;
    }

    public void executeActions() throws ActionExecutionException, EvaluationException {

        if(condition.evaluate()){
            for(IAction action: actions){
                action.execute();
            }
        }

    }

}
