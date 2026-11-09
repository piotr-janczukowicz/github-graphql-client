package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryMigration}. */
public interface RepositoryMigrationSelector {

    boolean continueOnError();

    Instant createdAt();

    @Nullable String databaseId();

    @Nullable String failureReason();

    String id();

    @Nullable String migrationLogUrl();

    <R> R migrationSource(Function<MigrationSourceSelector, R> selection);

    String repositoryName();

    String sourceUrl();

    MigrationState state();

    int warningsCount();
}
