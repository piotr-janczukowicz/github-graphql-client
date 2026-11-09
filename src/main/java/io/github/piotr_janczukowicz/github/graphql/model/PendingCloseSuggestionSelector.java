package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PendingCloseSuggestion}. */
public interface PendingCloseSuggestionSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    <R> @Nullable R duplicateOf(Function<IssueOrPullRequestSelector, R> selection);

    String id();

    @Nullable String rationale();

    @Nullable IssueStateReason stateReason();

    @Nullable Instant updatedAt();
}
