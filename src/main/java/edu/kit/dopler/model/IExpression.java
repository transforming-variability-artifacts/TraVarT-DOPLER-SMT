package edu.kit.dopler.model;

import java.util.stream.Stream;

public interface IExpression {

    boolean evaluate();

    void toSMTStream(Stream.Builder<String> builder);
}
