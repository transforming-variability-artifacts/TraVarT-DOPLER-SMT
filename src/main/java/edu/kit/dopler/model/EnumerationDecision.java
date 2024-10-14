package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ValidityConditionException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class EnumerationDecision extends Decision<String> {

    private final Enumeration enumeration;
    private final int minCardinality;
    private final int maxCardinality;
    private final AbstractValue<String> value;
    private final Set<EnumerationLiteral> disAllowed;


    public EnumerationDecision(String displayId, String question, String description, IExpression visibilityCondition, Set<Rule> rules, Enumeration enumeration, int minCardinality, int maxCardinality) {
        super(displayId, question, description, visibilityCondition, rules, DecisionType.ENUM);
        this.enumeration = enumeration;
        this.minCardinality = minCardinality;
        this.maxCardinality = maxCardinality;
        value = new StringValue("null");
        disAllowed = new HashSet<>();
    }


    @Override
    public String getStandardValue() {
        return "null";
    }

    @Override
    public IValue<String> getValue() {
        return value;
    }

    @Override
    public void setValue(IValue<String> value) throws ValidityConditionException {
        String v = Objects.requireNonNull(value.getValue());
        if(inRange(v) && allowed(v)){
            this.value.setValue(v);
            setTaken(true);
        }else {
            throw new ValidityConditionException("Value: " + v + " not in Range");
        }
    }

    @Override
    public void setDefaultValueInSMT(Stream.Builder<String> builder) {
        builder.add("(and");
        for (EnumerationLiteral enumerationLiteral : enumeration.getEnumerationLiterals()){
            builder.add("(= " + toStringConstforSMT() + "_" + toStringConstforSMT() + "_"+ enumerationLiteral.getValue() + "_POST" + " " + "false" + ")");
        }
        builder.add(")");
    }

    private boolean inRange(String value){
        return enumeration.enumerationLiterals.stream().anyMatch(enumerationLiteral -> enumerationLiteral.getValue().equals(value));
    }

    private boolean allowed(String value){
        return disAllowed.stream().noneMatch(enumerationLiteral -> enumerationLiteral.getValue().equals(value));
    }

    public void addDissallowed(EnumerationLiteral literal){
        disAllowed.add(literal);
    }

    public void removeDissallowed(EnumerationLiteral literal){disAllowed.remove(literal);}

    @Override
    void toSMTStreamValidityConditions(Stream.Builder<String> builder, Set<? super IDecision<?>> decisions) {

    }

    public Enumeration getEnumeration() {
        return enumeration;
    }

    public int getMaxCardinality() {
        return maxCardinality;
    }

    public int getMinCardinality() {
        return minCardinality;
    }
}
