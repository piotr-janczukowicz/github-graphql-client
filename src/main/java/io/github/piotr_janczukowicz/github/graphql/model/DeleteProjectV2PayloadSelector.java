package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeleteProjectV2Payload}. */
public interface DeleteProjectV2PayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R projectV2(Function<ProjectV2Selector, R> selection);
}
