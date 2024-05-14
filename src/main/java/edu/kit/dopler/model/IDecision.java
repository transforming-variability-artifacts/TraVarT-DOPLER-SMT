package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.InvalidCardinalityException;
import edu.kit.dopler.exceptions.NotInRangeException;

import java.util.Set;
import java.util.stream.Stream;

public interface IDecision<T> {

    String getQuestion();
    void setQuestion(String question);

    String getDescription();
    void setDescription(String description);

    Set<Rule> getRules();
    void addRule(Rule rule);
    void removeRule(Rule rule);
    void executeRules();


    Range<T> getRange();
    void setRange(Range<T> range) throws InvalidCardinalityException;


    IValue<T> getValue();
    void setValue(T value) throws NotInRangeException;

    void setSelected(final boolean select);
    boolean isSelected();

    IExpression getVisibilityCondition();
    void setVisibilityCondition(IExpression visibilityCondition);

    boolean isVisible();
    void toSMTStream(Stream.Builder<String> builder);

    boolean isTaken();
    void setTaken(boolean taken);

    String toStringConstforSMT();
}