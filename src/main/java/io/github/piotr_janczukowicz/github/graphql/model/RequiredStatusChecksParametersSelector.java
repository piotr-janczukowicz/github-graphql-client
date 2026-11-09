package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code RequiredStatusChecksParameters}. */
public interface RequiredStatusChecksParametersSelector {

    boolean doNotEnforceOnCreate();

    <R> List<R> requiredStatusChecks(Function<StatusCheckConfigurationSelector, R> selection);

    boolean strictRequiredStatusChecksPolicy();
}
