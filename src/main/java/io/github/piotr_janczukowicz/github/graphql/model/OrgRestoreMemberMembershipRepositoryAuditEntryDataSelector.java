package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code OrgRestoreMemberMembershipRepositoryAuditEntryData}. */
public interface OrgRestoreMemberMembershipRepositoryAuditEntryDataSelector {

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);

    @Nullable String repositoryName();

    @Nullable String repositoryResourcePath();

    @Nullable String repositoryUrl();
}
