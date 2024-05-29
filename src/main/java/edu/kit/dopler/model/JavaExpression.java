package edu.kit.dopler.model;

import java.util.stream.Stream;

public class JavaExpression extends Expression{



    @Override
    public boolean evaluate() {
        return false;
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
        //not yet implemented
    }
}
