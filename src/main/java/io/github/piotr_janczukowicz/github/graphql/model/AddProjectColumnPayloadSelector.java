package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddProjectColumnPayload}. */
public interface AddProjectColumnPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R columnEdge(Function<ProjectColumnEdgeSelector, R> selection);

    <R> @Nullable R project(Function<ProjectSelector, R> selection);
}
