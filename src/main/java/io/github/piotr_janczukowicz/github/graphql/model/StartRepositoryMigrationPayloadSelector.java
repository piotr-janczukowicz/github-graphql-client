package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code StartRepositoryMigrationPayload}. */
public interface StartRepositoryMigrationPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R repositoryMigration(Function<RepositoryMigrationSelector, R> selection);
}
