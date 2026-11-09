package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code User.repositoryDiscussions}; an argument left {@code null} is not sent. */
@RecordBuilder
public record UserRepositoryDiscussionsFilter(
        @Nullable Boolean answered,
        @Nullable DiscussionOrder orderBy,
        @Nullable String repositoryId,
        @Nullable List<DiscussionState> states) {

    public UserRepositoryDiscussionsFilter {
        states = ListUtils.copyOrNull(states);
    }
}
