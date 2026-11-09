package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Team}. */
public interface TeamSelector {

    <R> Page<R> ancestors(Paging paging, Function<TeamSelector, R> selection);

    @Nullable String avatarUrl(TeamAvatarUrlFilter arguments);

    @Nullable String avatarUrl();

    <R> Page<R> childTeams(Paging paging, TeamChildTeamsFilter arguments, Function<TeamSelector, R> selection);

    <R> Page<R> childTeams(Paging paging, Function<TeamSelector, R> selection);

    String combinedSlug();

    Instant createdAt();

    @Nullable Integer databaseId();

    @Nullable String description();

    String editTeamResourcePath();

    String editTeamUrl();

    String id();

    <R> Page<R> invitations(Paging paging, Function<OrganizationInvitationSelector, R> selection);

    <R> Page<R> memberStatuses(
            Paging paging, TeamMemberStatusesFilter arguments, Function<UserStatusSelector, R> selection);

    <R> Page<R> memberStatuses(Paging paging, Function<UserStatusSelector, R> selection);

    <R> Page<R> members(Paging paging, TeamMembersFilter arguments, Function<UserSelector, R> selection);

    <R> Page<R> members(Paging paging, Function<UserSelector, R> selection);

    String membersResourcePath();

    String membersUrl();

    String name();

    String newTeamResourcePath();

    String newTeamUrl();

    TeamNotificationSetting notificationSetting();

    <R> R organization(Function<OrganizationSelector, R> selection);

    <R> @Nullable R parentTeam(Function<TeamSelector, R> selection);

    TeamPrivacy privacy();

    <R> @Nullable R projectV2(int number, Function<ProjectV2Selector, R> selection);

    <R> Page<R> projectsV2(Paging paging, TeamProjectsV2Filter arguments, Function<ProjectV2Selector, R> selection);

    <R> Page<R> projectsV2(Paging paging, Function<ProjectV2Selector, R> selection);

    <R> Page<R> repositories(
            Paging paging, TeamRepositoriesFilter arguments, Function<RepositorySelector, R> selection);

    <R> Page<R> repositories(Paging paging, Function<RepositorySelector, R> selection);

    String repositoriesResourcePath();

    String repositoriesUrl();

    String resourcePath();

    @Nullable TeamReviewAssignmentAlgorithm reviewRequestDelegationAlgorithm();

    boolean reviewRequestDelegationEnabled();

    @Nullable Integer reviewRequestDelegationMemberCount();

    boolean reviewRequestDelegationNotifyTeam();

    String slug();

    String teamsResourcePath();

    String teamsUrl();

    Instant updatedAt();

    String url();

    boolean viewerCanAdminister();

    /**
     * @deprecated `Team.viewerCanSubscribe` will be removed. Team notifications subscriptions are being deprecated.
     *     Removal on 2026-07-01 UTC.
     */
    @Deprecated(forRemoval = true)
    boolean viewerCanSubscribe();

    /**
     * @deprecated `Team.viewerSubscription` will be removed. Team notifications subscriptions are being deprecated.
     *     Removal on 2026-07-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable SubscriptionState viewerSubscription();
}
