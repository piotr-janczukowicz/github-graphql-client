package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Ref.associatedPullRequests}; an argument left {@code null} is not sent. */
@RecordBuilder
public record RefAssociatedPullRequestsFilter(
        @Nullable String baseRefName,
        @Nullable String headRefName,
        @Nullable List<String> labels,
        @Nullable IssueOrder orderBy,
        @Nullable List<PullRequestState> states) {

    public RefAssociatedPullRequestsFilter {
        labels = ListUtils.copyOrNull(labels);
        states = ListUtils.copyOrNull(states);
    }
}
