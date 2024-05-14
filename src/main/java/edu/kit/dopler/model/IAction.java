package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

public interface IAction {

    public void execute() throws ActionExecutionException;
}
