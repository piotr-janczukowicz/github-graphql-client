package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateProjectV2ItemFieldValuePayload}. */
public interface UpdateProjectV2ItemFieldValuePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R projectV2Item(Function<ProjectV2ItemSelector, R> selection);
}
