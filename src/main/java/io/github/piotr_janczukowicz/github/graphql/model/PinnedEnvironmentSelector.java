package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PinnedEnvironment}. */
public interface PinnedEnvironmentSelector {

    Instant createdAt();

    @Nullable Integer databaseId();

    <R> R environment(Function<EnvironmentSelector, R> selection);

    String id();

    int position();

    <R> R repository(Function<RepositorySelector, R> selection);
}
