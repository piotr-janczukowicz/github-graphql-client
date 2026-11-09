package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;

/** Selection of the GraphQL type {@code CreatedPullRequestContribution}. */
public interface CreatedPullRequestContributionSelector {

    boolean isRestricted();

    Instant occurredAt();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    String resourcePath();

    String url();

    <R> R user(Function<UserSelector, R> selection);
}
