package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateProjectV2StatusUpdatePayload}. */
public interface UpdateProjectV2StatusUpdatePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R statusUpdate(Function<ProjectV2StatusUpdateSelector, R> selection);
}
