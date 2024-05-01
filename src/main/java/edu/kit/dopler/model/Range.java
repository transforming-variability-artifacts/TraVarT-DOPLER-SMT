package edu.kit.dopler.model;

public class Range extends Expression{



    private double min = 0.0;
    private double max = 0.0;

    public Range(double min, double max) {
        this.min = min;
        this.max = max;
    }


    @Override
    public boolean evaluate() {
        return false;
    }
}
