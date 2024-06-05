package edu.kit.dopler.model;

import java.util.Objects;

public class DoubleValue extends AbstractValue<Double>{

    protected DoubleValue(final double value) {
        super(value);
    }


    @Override
    public Double getSMTValue() {
        return getValue();
    }
}
