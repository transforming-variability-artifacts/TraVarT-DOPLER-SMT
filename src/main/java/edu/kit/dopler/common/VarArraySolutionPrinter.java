package edu.kit.dopler.common;

import com.google.ortools.sat.CpSolverSolutionCallback;
import com.google.ortools.sat.IntVar;

import java.util.List;

public final class VarArraySolutionPrinter extends CpSolverSolutionCallback {
    private final List<IntVar> vars;
    private int solutionCount = 0;

    public VarArraySolutionPrinter(List<IntVar> vars) {
        this.vars = vars;
    }

    @Override
    public void onSolutionCallback() {
        System.out.printf("Solution #%d, time = %.2f s%n", solutionCount, wallTime());
        for (IntVar v : vars) {
            System.out.printf("  %s = %d%n", v.getName(), value(v));
        }
        solutionCount++;
    }

    public int getSolutionCount() {
        return solutionCount;
    }
}