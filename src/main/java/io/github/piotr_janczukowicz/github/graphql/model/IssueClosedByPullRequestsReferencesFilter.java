package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * The optional arguments of {@code Issue.closedByPullRequestsReferences}; an argument left {@code null} is not sent.
 */
@RecordBuilder
public record IssueClosedByPullRequestsReferencesFilter(
        @Nullable Boolean excludeUserLinked,
        @Nullable Boolean includeClosedPrs,
        @Nullable Boolean orderByState,
        @Nullable Boolean userLinkedOnly) {}
