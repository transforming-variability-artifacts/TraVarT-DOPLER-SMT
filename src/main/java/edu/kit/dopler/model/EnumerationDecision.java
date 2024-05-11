package edu.kit.dopler.model;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class EnumerationDecision extends Decision<String> {


    private Enum enumeration;
    private int minCardinality;
    private int maxCardinaltiy;
    private Range<String> range;
    private AbstractValue<String> value;


    public EnumerationDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules, Enum enumeration, int minCardinality, int maxCardinaltiy) {
        super(question, description, visibilityCondition, taken, rules, DecisionType.ENUM);
        this.enumeration = enumeration;
        this.minCardinality = minCardinality;
        this.maxCardinaltiy = maxCardinaltiy;
        range = new Range<>();
        value = new StringValue("None");
    }

    @Override
    public Range<String> getRange() {
        return range;
    }

    @Override
    public void setRange(Range<String> range) {
        this.range = Objects.requireNonNull(range);
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



    @Override
    void toSMTStreamDecisionSpecific(Stream.Builder<String> builder) {

    }
}
