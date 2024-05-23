package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

import java.util.stream.Stream;

public interface IAction {

    void execute() throws ActionExecutionException;

    void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString);
}
