package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PendingAssigneeSuggestion}. */
public interface PendingAssigneeSuggestionSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    <R> @Nullable R assignee(Function<AssigneeSelector, R> selection);

    Instant createdAt();

    String id();

    @Nullable String rationale();

    @Nullable Instant updatedAt();
}
