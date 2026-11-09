package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Organization.repositoryDiscussions}; an argument left {@code null} is not sent. */
@RecordBuilder
public record OrganizationRepositoryDiscussionsFilter(
        @Nullable Boolean answered,
        @Nullable DiscussionOrder orderBy,
        @Nullable String repositoryId,
        @Nullable List<DiscussionState> states) {

    public OrganizationRepositoryDiscussionsFilter {
        states = ListUtils.copyOrNull(states);
    }
}
