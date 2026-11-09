package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Milestone.issues}; an argument left {@code null} is not sent. */
@RecordBuilder
public record MilestoneIssuesFilter(
        @Nullable IssueFilters filterBy,
        @Nullable List<String> labels,
        @Nullable IssueOrder orderBy,
        @Nullable List<IssueState> states) {

    public MilestoneIssuesFilter {
        labels = ListUtils.copyOrNull(labels);
        states = ListUtils.copyOrNull(states);
    }
}
