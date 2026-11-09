package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateDeploymentPayload}. */
public interface CreateDeploymentPayloadSelector {

    @Nullable Boolean autoMerged();

    @Nullable String clientMutationId();

    <R> @Nullable R deployment(Function<DeploymentSelector, R> selection);
}
