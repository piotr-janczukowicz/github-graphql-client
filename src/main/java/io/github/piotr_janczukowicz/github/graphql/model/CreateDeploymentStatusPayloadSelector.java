package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateDeploymentStatusPayload}. */
public interface CreateDeploymentStatusPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R deploymentStatus(Function<DeploymentStatusSelector, R> selection);
}
