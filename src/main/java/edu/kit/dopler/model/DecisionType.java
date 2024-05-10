package edu.kit.dopler.model;

import java.util.Set;
import java.util.stream.Stream;

abstract class DecisionType<T> implements IDecisionType<T> {


    private String question;
    private String description;
    private IExpression visibilityCondition;
    private Set<Rule> rules;
    private boolean taken;
    private boolean select;

    public DecisionType(String question, String description, IExpression visibilityCondition, boolean taken,Set<Rule> rules) {
        this.question = question;
        this.description = description;
        this.visibilityCondition = visibilityCondition;
        this.taken = taken;
        this.rules = rules;
    }

    @Override
    public final void setSelected(final boolean select) {
        this.select = select;
        setTaken(true);
    }

    @Override
    public final boolean isSelected() {
        return select;
    }


    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Set<Rule> getRules() {
        return rules;
    }

    @Override
    public void addRule(Rule rule) {
        rules.add(rule);
    }

    @Override
    public void removeRule(Rule rule) {
        rules.remove(rule);
    }

    @Override
    public void executeRules() {
        for(Rule rule : rules){
            if(rule.getCondition().evaluate()){

            }
        }
    }

    @Override
    public IExpression getVisibilityCondition() {
        return visibilityCondition;
    }

    @Override
    public void setVisibilityCondition(IExpression visibilityCondition) {
        this.visibilityCondition = visibilityCondition;
    }

    public boolean isVisible(){
        return visibilityCondition.evaluate();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {

        builder.add("(ite");
        getVisibilityCondition().toSMTStream(builder); //if condition
        toSMTStreamDecisionSpecific(builder);   //if part
        //else part needs to be added here
        builder.add(")"); //closing the ite of the visibilityDecision


    }

    abstract void toSMTStreamDecisionSpecific(Stream.Builder<String> builder);

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }


}