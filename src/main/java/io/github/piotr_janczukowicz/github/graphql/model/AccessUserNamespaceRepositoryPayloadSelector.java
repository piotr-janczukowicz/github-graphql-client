package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AccessUserNamespaceRepositoryPayload}. */
public interface AccessUserNamespaceRepositoryPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable Instant expiresAt();

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);
}
