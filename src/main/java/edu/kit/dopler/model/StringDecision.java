package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;
import edu.kit.dopler.exceptions.ValidityConditionException;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class StringDecision extends ValueDecision<String>{

    private AbstractValue<String> value;
    private String standardValue = "null";

    public StringDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules, Set<IExpression> validityConditions) {
        super(question, description, visibilityCondition, taken, rules, validityConditions, DecisionType.STRING);
        value = new StringValue("");
    }

    @Override
    void toSMTStreamValueDecisionSpecific(Stream.Builder<String> builder) {

    }


    @Override
    public String getStandardValue() {
        return standardValue;
    }

    @Override
    public IValue<String> getValue() {
        return value;
    }

    @Override
    public void setValue(IValue<String> value) throws ValidityConditionException {
        String v = Objects.requireNonNull(value.getValue());
        this.value.setValue(v);
        try {
            if(checkValidity()){
                setSelected(true);
            } else {
                this.value.setValue(standardValue);
                throw new ValidityConditionException("Value: " + v + "does not fullfil validity condition");
            }
        }catch (EvaluationException e){
            throw new ValidityConditionException(e);
        }

    }




}
