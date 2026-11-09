package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;

/** Selection of the GraphQL type {@code CreatedPullRequestReviewContribution}. */
public interface CreatedPullRequestReviewContributionSelector {

    boolean isRestricted();

    Instant occurredAt();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    <R> R pullRequestReview(Function<PullRequestReviewSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    String url();

    <R> R user(Function<UserSelector, R> selection);
}
