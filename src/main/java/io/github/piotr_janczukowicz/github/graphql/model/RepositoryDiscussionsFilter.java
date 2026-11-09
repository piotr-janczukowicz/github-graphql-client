package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Repository.discussions}; an argument left {@code null} is not sent. */
@RecordBuilder
public record RepositoryDiscussionsFilter(
        @Nullable Boolean answered,
        @Nullable String categoryId,
        @Nullable DiscussionOrder orderBy,
        @Nullable List<DiscussionState> states) {

    public RepositoryDiscussionsFilter {
        states = ListUtils.copyOrNull(states);
    }
}
