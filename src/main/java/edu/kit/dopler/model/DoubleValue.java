package edu.kit.dopler.model;

import java.util.Objects;

public class DoubleValue extends AbstractValue<Double>{

    protected DoubleValue(Double value) {
        super(Objects.requireNonNull(value));
    }


}
