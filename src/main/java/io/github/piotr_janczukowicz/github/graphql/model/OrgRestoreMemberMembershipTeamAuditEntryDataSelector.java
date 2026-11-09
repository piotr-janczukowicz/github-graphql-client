package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code OrgRestoreMemberMembershipTeamAuditEntryData}. */
public interface OrgRestoreMemberMembershipTeamAuditEntryDataSelector {

    <R> @Nullable R team(Function<TeamSelector, R> selection);

    @Nullable String teamName();

    @Nullable String teamResourcePath();

    @Nullable String teamUrl();
}
