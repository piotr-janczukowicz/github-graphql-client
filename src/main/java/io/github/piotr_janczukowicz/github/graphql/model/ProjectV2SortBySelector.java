package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code ProjectV2SortBy}. */
public interface ProjectV2SortBySelector {

    OrderDirection direction();

    <R> R field(Function<ProjectV2FieldSelector, R> selection);
}
