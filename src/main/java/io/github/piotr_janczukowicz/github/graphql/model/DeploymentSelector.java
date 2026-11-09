package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Deployment}. */
public interface DeploymentSelector {

    <R> @Nullable R commit(Function<CommitSelector, R> selection);

    String commitOid();

    Instant createdAt();

    <R> R creator(Function<ActorSelector, R> selection);

    @Nullable Integer databaseId();

    @Nullable String description();

    @Nullable String environment();

    String id();

    @Nullable String latestEnvironment();

    <R> @Nullable R latestStatus(Function<DeploymentStatusSelector, R> selection);

    @Nullable String originalEnvironment();

    @Nullable String payload();

    <R> @Nullable R ref(Function<RefSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    @Nullable DeploymentState state();

    <R> Page<R> statuses(Paging paging, Function<DeploymentStatusSelector, R> selection);

    @Nullable String task();

    Instant updatedAt();
}
