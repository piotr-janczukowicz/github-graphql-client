package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code ProjectV2IterationFieldConfiguration}. */
public interface ProjectV2IterationFieldConfigurationSelector {

    <R> List<R> completedIterations(Function<ProjectV2IterationFieldIterationSelector, R> selection);

    int duration();

    <R> List<R> iterations(Function<ProjectV2IterationFieldIterationSelector, R> selection);

    int startDay();
}
