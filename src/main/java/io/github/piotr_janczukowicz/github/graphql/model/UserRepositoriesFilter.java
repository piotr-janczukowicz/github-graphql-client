package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code User.repositories}; an argument left {@code null} is not sent. */
@RecordBuilder
public record UserRepositoriesFilter(
        @Nullable List<RepositoryAffiliation> affiliations,
        @Nullable Boolean hasIssuesEnabled,
        @Nullable Boolean isArchived,
        @Nullable Boolean isFork,
        @Nullable Boolean isLocked,
        @Nullable RepositoryOrder orderBy,
        @Nullable List<RepositoryAffiliation> ownerAffiliations,
        @Nullable RepositoryPrivacy privacy,
        @Nullable RepositoryVisibility visibility) {

    public UserRepositoriesFilter {
        affiliations = ListUtils.copyOrNull(affiliations);
        ownerAffiliations = ListUtils.copyOrNull(ownerAffiliations);
    }
}
