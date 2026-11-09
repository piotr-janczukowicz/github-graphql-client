package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * The optional arguments of {@code PullRequest.latestOpinionatedReviews}; an argument left {@code null} is not sent.
 */
@RecordBuilder
public record PullRequestLatestOpinionatedReviewsFilter(
        @Nullable Boolean writersOnly) {}
