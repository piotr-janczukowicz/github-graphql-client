package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code EnterpriseTeam}. */
public interface EnterpriseTeamSelector {

    <R> Page<R> assignedOrganizations(
            Paging paging,
            EnterpriseTeamAssignedOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> assignedOrganizations(Paging paging, Function<OrganizationSelector, R> selection);

    String combinedSlug();

    Instant createdAt();

    @Nullable String description();

    <R> @Nullable R enterprise(Function<EnterpriseSelector, R> selection);

    <R> Page<R> enterpriseTeamMembers(
            Paging paging, EnterpriseTeamEnterpriseTeamMembersFilter arguments, Function<UserSelector, R> selection);

    <R> Page<R> enterpriseTeamMembers(Paging paging, Function<UserSelector, R> selection);

    @Nullable BigInteger fullDatabaseId();

    String id();

    boolean isViewerMember();

    String name();

    TeamNotificationSetting notificationSetting();

    EnterpriseTeamOrganizationSelectionType organizationSelectionType();

    TeamPrivacy privacy();

    String slug();

    Instant updatedAt();

    boolean viewerCanAdminister();
}
