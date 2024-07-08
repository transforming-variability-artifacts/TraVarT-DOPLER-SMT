package edu.kit.dopler.model;

import java.util.Objects;

public class StringValue extends AbstractValue<String>{

    public StringValue(String value) {
        super(Objects.requireNonNull(value));
    }

    @Override
    public String getSMTValue() {
        return " \"" + getValue() + "\"";
    }
}
