package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateProjectColumnPayload}. */
public interface UpdateProjectColumnPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R projectColumn(Function<ProjectColumnSelector, R> selection);
}
