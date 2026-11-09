package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeleteProjectV2StatusUpdatePayload}. */
public interface DeleteProjectV2StatusUpdatePayloadSelector {

    @Nullable String clientMutationId();

    @Nullable String deletedStatusUpdateId();

    <R> @Nullable R projectV2(Function<ProjectV2Selector, R> selection);
}
