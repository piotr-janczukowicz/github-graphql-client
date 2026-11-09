package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeployedEvent}. */
public interface DeployedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    @Nullable Integer databaseId();

    <R> R deployment(Function<DeploymentSelector, R> selection);

    String id();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    <R> @Nullable R ref(Function<RefSelector, R> selection);
}
