package edu.kit.dopler.model;

import java.util.stream.Stream;

public class NOT extends UnaryExpression{

    public NOT(IExpression child) {
        super(child);
    }


    @Override
    public boolean evaluate() {
        return !getChild().evaluate();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(not");
        getChild().toSMTStream(builder);
        builder.add(")");
    }


}
