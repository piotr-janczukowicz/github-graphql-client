package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeploymentEnvironmentChangedEvent}. */
public interface DeploymentEnvironmentChangedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    <R> R deploymentStatus(Function<DeploymentStatusSelector, R> selection);

    String id();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);
}
