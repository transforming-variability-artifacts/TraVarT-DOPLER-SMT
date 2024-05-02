package edu.kit.dopler.model;

import java.util.Set;

public interface IDecisionType {

    String getQuestion();
    void setQuestion(String question);

    String getDescription();
    void setDescription(String description);

    Set<Rule> getRules();
    void addRule(Rule rule);
    void removeRule(Rule rule);
    void executeRules();

    IExpression getVisibilityCondition();
    void setVisibilityCondition(IExpression visibilityCondition);

    boolean isVisible();

}