package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ReviewDismissedEvent}. */
public interface ReviewDismissedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    @Nullable Integer databaseId();

    @Nullable String dismissalMessage();

    @Nullable String dismissalMessageHTML();

    String id();

    PullRequestReviewState previousReviewState();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    <R> @Nullable R pullRequestCommit(Function<PullRequestCommitSelector, R> selection);

    String resourcePath();

    <R> @Nullable R review(Function<PullRequestReviewSelector, R> selection);

    String url();
}
