package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PendingFieldSuggestion}. */
public interface PendingFieldSuggestionSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    <R> @Nullable R issueField(Function<IssueFieldsSelector, R> selection);

    @Nullable String rationale();

    @Nullable String suggestedValue();

    @Nullable Instant updatedAt();
}
