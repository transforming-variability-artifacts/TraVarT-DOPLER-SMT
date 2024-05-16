package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

public interface IAction {

    void execute() throws ActionExecutionException;
}
