package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * The optional arguments of {@code ContributionsCollection.pullRequestContributions}; an argument left {@code null} is
 * not sent.
 */
@RecordBuilder
public record ContributionsCollectionPullRequestContributionsFilter(
        @Nullable Boolean excludeFirst,
        @Nullable Boolean excludePopular,
        @Nullable ContributionOrder orderBy) {}
