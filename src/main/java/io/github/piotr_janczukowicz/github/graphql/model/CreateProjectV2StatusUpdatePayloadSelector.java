package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateProjectV2StatusUpdatePayload}. */
public interface CreateProjectV2StatusUpdatePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R statusUpdate(Function<ProjectV2StatusUpdateSelector, R> selection);
}
