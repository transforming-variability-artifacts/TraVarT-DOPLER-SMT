package edu.kit.dopler.model;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class StringDecision extends ValueDecision<String>{

    private Range<String> range;
    private AbstractValue<String> value;

    public StringDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules, Set<IExpression> validityConditions) {
        super(question, description, visibilityCondition, taken, rules, validityConditions);
        range = new Range<>();
        value = new StringValue("");
    }

    @Override
    void toSMTStreamValueDecisionSpecific(Stream.Builder<String> builder) {

    }


    @Override
    public Range<String> getRange() {
        return range;
    }

    @Override
    public void setRange(Range<String> range) {
        this.range = range;
    }

    @Override
    public IValue<String> getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        String v = Objects.requireNonNull(value);
        if(inRange(v)){
            this.value = new StringValue(v);
            setSelected(true);
        }
    }

    private boolean inRange(String value){
        for (AbstractValue<String> r : range) {
            if (r.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }


}
