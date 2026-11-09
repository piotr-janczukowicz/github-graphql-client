package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateProjectV2Payload}. */
public interface UpdateProjectV2PayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R projectV2(Function<ProjectV2Selector, R> selection);
}
