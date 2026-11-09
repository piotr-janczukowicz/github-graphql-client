package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code User.repositoriesContributedTo}; an argument left {@code null} is not sent. */
@RecordBuilder
public record UserRepositoriesContributedToFilter(
        @Nullable List<RepositoryContributionType> contributionTypes,
        @Nullable Boolean hasIssues,
        @Nullable Boolean includeUserRepositories,
        @Nullable Boolean isLocked,
        @Nullable RepositoryOrder orderBy,
        @Nullable RepositoryPrivacy privacy) {

    public UserRepositoriesContributedToFilter {
        contributionTypes = ListUtils.copyOrNull(contributionTypes);
    }
}
