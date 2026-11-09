package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UserContentEdit}. */
public interface UserContentEditSelector {

    Instant createdAt();

    @Nullable Instant deletedAt();

    <R> @Nullable R deletedBy(Function<ActorSelector, R> selection);

    @Nullable String diff();

    Instant editedAt();

    <R> @Nullable R editor(Function<ActorSelector, R> selection);

    String id();

    Instant updatedAt();
}
