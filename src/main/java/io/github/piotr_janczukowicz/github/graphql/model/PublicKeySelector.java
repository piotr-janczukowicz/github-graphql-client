package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PublicKey}. */
public interface PublicKeySelector {

    @Nullable Instant accessedAt();

    @Nullable Instant createdAt();

    String fingerprint();

    String id();

    @Nullable Boolean isReadOnly();

    String key();

    @Nullable Instant updatedAt();
}
