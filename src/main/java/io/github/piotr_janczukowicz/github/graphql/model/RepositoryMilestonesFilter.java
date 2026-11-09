package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Repository.milestones}; an argument left {@code null} is not sent. */
@RecordBuilder
public record RepositoryMilestonesFilter(
        @Nullable MilestoneOrder orderBy,
        @Nullable String query,
        @Nullable List<MilestoneState> states) {

    public RepositoryMilestonesFilter {
        states = ListUtils.copyOrNull(states);
    }
}
