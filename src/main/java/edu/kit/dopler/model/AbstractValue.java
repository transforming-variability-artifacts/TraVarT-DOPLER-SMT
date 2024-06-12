/**
 * This abstract class implements the basic method's every implementation of IValue should have
 *
 *
 */
package edu.kit.dopler.model;

import java.util.Objects;

public abstract class AbstractValue<T> implements IValue<T> {

    private T value;
    
    protected AbstractValue(final T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(final T value) {
        this.value = Objects.requireNonNull(value);
    }


}
