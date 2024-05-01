package edu.kit.dopler.model;

import java.util.Set;

abstract class DecisionType implements IDecisionType {

    private String question;
    private String description;
    private IExpression visibilityCondition;
    private Set<Rule> rules;
    private boolean taken;

    public DecisionType(String question, String description, IExpression visibilityCondition, boolean taken,Set<Rule> rules) {
        this.question = question;
        this.description = description;
        this.visibilityCondition = visibilityCondition;
        this.taken = taken;
        this.rules = rules;
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
    public IExpression getVisibilityCondition() {
        return visibilityCondition;
    }

    @Override
    public void setVisibilityCondition(IExpression visibilityCondition) {
        this.visibilityCondition = visibilityCondition;
    }


    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}