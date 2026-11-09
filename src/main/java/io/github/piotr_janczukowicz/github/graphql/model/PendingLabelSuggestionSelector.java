package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PendingLabelSuggestion}. */
public interface PendingLabelSuggestionSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    <R> @Nullable R label(Function<LabelSelector, R> selection);

    @Nullable String rationale();

    @Nullable Instant updatedAt();
}
