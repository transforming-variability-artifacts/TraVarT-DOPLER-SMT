package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.InvalidCardinalityException;
import edu.kit.dopler.exceptions.NotInRangeException;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class EnumerationDecision extends Decision<String> {

    private final Enum enumeration;
    private final int minCardinality;
    private final int maxCardinality;
    private Range<String> range;
    private final AbstractValue<String> value;


    public EnumerationDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules, Enum enumeration, int minCardinality, int maxCardinality) {
        super(question, description, visibilityCondition, taken, rules, DecisionType.ENUM);
        this.enumeration = enumeration;
        this.minCardinality = minCardinality;
        this.maxCardinality = maxCardinality;
        range = new Range<>();
        value = new StringValue("None");
    }

    @Override
    public Range<String> getRange() {
        return range;
    }

    @Override
    public void setRange(Range<String> range) throws InvalidCardinalityException{
        if(range.size() < maxCardinality && range.size() > minCardinality){
            this.range = Objects.requireNonNull(range);
        }else {
            throw new InvalidCardinalityException("Range does not match the Min or Max Caridnality");
        }
    }


    @Override
    public IValue<String> getValue() {
        return value;
    }

    @Override
    public void setValue(IValue<String> value) throws NotInRangeException {
        String v = Objects.requireNonNull(value.getValue());
        if(inRange(v)){
            this.value.setValue(v);
            setSelected(true);
        }else {
            throw new NotInRangeException("Value: " + v + " not in Range" + getRange().toString());
        }
    }

    private boolean inRange(String value){
        for (IValue<String> r : range) {
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
