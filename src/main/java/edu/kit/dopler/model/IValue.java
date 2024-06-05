package edu.kit.dopler.model;

public interface IValue<T>{

    T getValue();

    void setValue(T value);

    T getSMTValue();
}
