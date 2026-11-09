package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeploymentStatus}. */
public interface DeploymentStatusSelector {

    Instant createdAt();

    <R> R creator(Function<ActorSelector, R> selection);

    <R> R deployment(Function<DeploymentSelector, R> selection);

    @Nullable String description();

    @Nullable String environment();

    @Nullable String environmentUrl();

    String id();

    @Nullable String logUrl();

    DeploymentStatusState state();

    Instant updatedAt();
}
