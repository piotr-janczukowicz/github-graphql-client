package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PendingTypeSuggestion}. */
public interface PendingTypeSuggestionSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    <R> @Nullable R issueType(Function<IssueTypeSelector, R> selection);

    @Nullable String rationale();

    @Nullable Instant updatedAt();
}
