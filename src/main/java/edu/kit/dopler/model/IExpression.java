package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.stream.Stream;

public interface IExpression {

    boolean evaluate() throws EvaluationException;

    void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst);
}
