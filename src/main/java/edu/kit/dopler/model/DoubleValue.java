package edu.kit.dopler.model;

import java.util.Objects;

public class DoubleValue extends AbstractValue<Double>{

    public DoubleValue(final double value) {
        super(Objects.requireNonNull(value));
    }


    @Override
    public Double getSMTValue() {
        return getValue();
    }
}
