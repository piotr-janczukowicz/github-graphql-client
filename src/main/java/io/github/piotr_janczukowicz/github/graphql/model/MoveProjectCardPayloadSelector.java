package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MoveProjectCardPayload}. */
public interface MoveProjectCardPayloadSelector {

    <R> @Nullable R cardEdge(Function<ProjectCardEdgeSelector, R> selection);

    @Nullable String clientMutationId();
}
