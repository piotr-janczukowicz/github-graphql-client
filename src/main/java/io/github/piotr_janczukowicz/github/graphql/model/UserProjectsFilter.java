package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code User.projects}; an argument left {@code null} is not sent. */
@RecordBuilder
public record UserProjectsFilter(
        @Nullable ProjectOrder orderBy,
        @Nullable String search,
        @Nullable List<ProjectState> states) {

    public UserProjectsFilter {
        states = ListUtils.copyOrNull(states);
    }
}
