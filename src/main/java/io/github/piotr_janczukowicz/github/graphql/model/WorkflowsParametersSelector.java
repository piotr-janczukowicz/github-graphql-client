package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code WorkflowsParameters}. */
public interface WorkflowsParametersSelector {

    boolean doNotEnforceOnCreate();

    <R> List<R> workflows(Function<WorkflowFileReferenceSelector, R> selection);
}
