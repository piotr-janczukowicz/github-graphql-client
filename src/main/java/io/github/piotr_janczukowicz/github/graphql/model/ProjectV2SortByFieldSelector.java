package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code ProjectV2SortByField}. */
public interface ProjectV2SortByFieldSelector {

    OrderDirection direction();

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);
}
