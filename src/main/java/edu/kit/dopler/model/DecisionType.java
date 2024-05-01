package edu.kit.dopler.model;

import java.util.Set;

abstract class DecisionType implements IDecisionType {

    private String question;
    private String description;
    private IExpression visibilityCondition;

    public DecisionType(String question, String description, IExpression visibilityCondition) {
        this.question = question;
        this.description = description;
        this.visibilityCondition = visibilityCondition;
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
        return Set.of();
    }

    @Override
    public void addRule(Rule rule) {

    }

    @Override
    public void removeRule(Rule rule) {

    }

    @Override
    public IExpression getVisibilityCondition() {
        return visibilityCondition;
    }

    @Override
    public void setVisibilityCondition(IExpression visibilityCondition) {
        this.visibilityCondition = visibilityCondition;
    }
}