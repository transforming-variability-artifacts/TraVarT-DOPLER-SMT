package edu.kit.dopler.model;

public final class BooleanValue extends AbstractValue<Boolean> {

    public BooleanValue(Boolean value) {
        super(value);
    }

    public static BooleanValue getTrue() {
        return new BooleanValue(true);
    }

    public static BooleanValue getFalse() {
        return new BooleanValue(false);
    }

    @Override
    public Boolean getSMTValue() {
        return getValue();
    }
}
