package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ApproveDeploymentsPayload}. */
public interface ApproveDeploymentsPayloadSelector {

    @Nullable String clientMutationId();

    <R> List<R> deployments(Function<DeploymentSelector, R> selection);
}
