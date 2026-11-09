package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AbortRepositoryMigrationPayload}. */
public interface AbortRepositoryMigrationPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable Boolean success();
}
