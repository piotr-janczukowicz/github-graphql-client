package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeleteProjectV2WorkflowPayload}. */
public interface DeleteProjectV2WorkflowPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable String deletedWorkflowId();

    <R> @Nullable R projectV2(Function<ProjectV2Selector, R> selection);
}
