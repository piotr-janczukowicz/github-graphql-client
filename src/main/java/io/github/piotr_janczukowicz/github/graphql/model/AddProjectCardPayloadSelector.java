package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddProjectCardPayload}. */
public interface AddProjectCardPayloadSelector {

    <R> @Nullable R cardEdge(Function<ProjectCardEdgeSelector, R> selection);

    @Nullable String clientMutationId();

    <R> @Nullable R projectColumn(Function<ProjectColumnSelector, R> selection);
}
