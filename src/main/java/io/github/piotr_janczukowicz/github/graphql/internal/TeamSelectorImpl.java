package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.TeamAvatarUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.TeamAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamChildTeamsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.TeamChildTeamsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamMemberStatusesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.TeamMemberStatusesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamMembersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.TeamMembersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamNotificationSetting;
import io.github.piotr_janczukowicz.github.graphql.model.TeamPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.TeamProjectsV2Filter;
import io.github.piotr_janczukowicz.github.graphql.model.TeamProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamRepositoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.TeamRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamReviewAssignmentAlgorithm;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Team}; used by the generated selection code only. */
final class TeamSelectorImpl implements TeamSelector {

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String ARGUMENTS = "arguments";

    private static final String ORDER_BY = "orderBy";

    private static final String QUERY = "query";

    private final Cursor cursor;

    TeamSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> ancestors(final Paging paging, final Function<TeamSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "ancestors",
                child -> selection.apply(new TeamSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public @Nullable String avatarUrl(final TeamAvatarUrlFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.get("avatarUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public @Nullable String avatarUrl() {
        return avatarUrl(TeamAvatarUrlFilterBuilder.builder().build());
    }

    @Override
    public <R> Page<R> childTeams(
            final Paging paging, final TeamChildTeamsFilter arguments, final Function<TeamSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "childTeams",
                child -> selection.apply(new TeamSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("immediateOnly", "Boolean", arguments.immediateOnly()),
                Argument.of(
                        ORDER_BY,
                        "TeamOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("userLogins", "[String!]", arguments.userLogins()));
    }

    @Override
    public <R> Page<R> childTeams(final Paging paging, final Function<TeamSelector, R> selection) {
        return childTeams(paging, TeamChildTeamsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String combinedSlug() {
        return cursor.getRequired("combinedSlug", ScalarType.STRING);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public String editTeamResourcePath() {
        return cursor.getRequired("editTeamResourcePath", ScalarType.STRING);
    }

    @Override
    public String editTeamUrl() {
        return cursor.getRequired("editTeamUrl", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> invitations(final Paging paging, final Function<OrganizationInvitationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "invitations",
                child -> selection.apply(new OrganizationInvitationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> memberStatuses(
            final Paging paging,
            final TeamMemberStatusesFilter arguments,
            final Function<UserStatusSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "memberStatuses",
                child -> selection.apply(new UserStatusSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "UserStatusOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> memberStatuses(final Paging paging, final Function<UserStatusSelector, R> selection) {
        return memberStatuses(paging, TeamMemberStatusesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> members(
            final Paging paging, final TeamMembersFilter arguments, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "members",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("membership", "TeamMembershipType", arguments.membership()),
                Argument.of(
                        ORDER_BY,
                        "TeamMemberOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()),
                Argument.of("role", "TeamMemberRole", arguments.role()));
    }

    @Override
    public <R> Page<R> members(final Paging paging, final Function<UserSelector, R> selection) {
        return members(paging, TeamMembersFilterBuilder.builder().build(), selection);
    }

    @Override
    public String membersResourcePath() {
        return cursor.getRequired("membersResourcePath", ScalarType.STRING);
    }

    @Override
    public String membersUrl() {
        return cursor.getRequired("membersUrl", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String newTeamResourcePath() {
        return cursor.getRequired("newTeamResourcePath", ScalarType.STRING);
    }

    @Override
    public String newTeamUrl() {
        return cursor.getRequired("newTeamUrl", ScalarType.STRING);
    }

    @Override
    public TeamNotificationSetting notificationSetting() {
        return cursor.getRequired(
                "notificationSetting",
                ScalarType.enumeration(
                        TeamNotificationSetting::fromWire, TeamNotificationSetting.NOTIFICATIONS_DISABLED));
    }

    @Override
    public <R> R organization(final Function<OrganizationSelector, R> selection) {
        return cursor.objectRequired("organization", child -> selection.apply(new OrganizationSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R parentTeam(final Function<TeamSelector, R> selection) {
        return cursor.object("parentTeam", child -> selection.apply(new TeamSelectorImpl(child)));
    }

    @Override
    public TeamPrivacy privacy() {
        return cursor.getRequired("privacy", ScalarType.enumeration(TeamPrivacy::fromWire, TeamPrivacy.SECRET));
    }

    @Override
    public <R> @Nullable R projectV2(final int number, final Function<ProjectV2Selector, R> selection) {
        return cursor.object(
                "projectV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of("number", INT, number));
    }

    @Override
    public <R> Page<R> projectsV2(
            final Paging paging, final TeamProjectsV2Filter arguments, final Function<ProjectV2Selector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "projectsV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        "filterBy",
                        "ProjectV2Filters",
                        arguments.filterBy() == null
                                ? null
                                : arguments.filterBy().toVariable()),
                Argument.of("minPermissionLevel", "ProjectV2PermissionLevel", arguments.minPermissionLevel()),
                Argument.of(
                        ORDER_BY,
                        "ProjectV2Order",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> projectsV2(final Paging paging, final Function<ProjectV2Selector, R> selection) {
        return projectsV2(paging, TeamProjectsV2FilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> repositories(
            final Paging paging,
            final TeamRepositoriesFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositories",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "TeamRepositoryOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> repositories(final Paging paging, final Function<RepositorySelector, R> selection) {
        return repositories(paging, TeamRepositoriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public String repositoriesResourcePath() {
        return cursor.getRequired("repositoriesResourcePath", ScalarType.STRING);
    }

    @Override
    public String repositoriesUrl() {
        return cursor.getRequired("repositoriesUrl", ScalarType.STRING);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public @Nullable TeamReviewAssignmentAlgorithm reviewRequestDelegationAlgorithm() {
        return cursor.get(
                "reviewRequestDelegationAlgorithm",
                ScalarType.enumeration(
                        TeamReviewAssignmentAlgorithm::fromWire, TeamReviewAssignmentAlgorithm.LOAD_BALANCE));
    }

    @Override
    public boolean reviewRequestDelegationEnabled() {
        return cursor.getRequired("reviewRequestDelegationEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Integer reviewRequestDelegationMemberCount() {
        return cursor.get("reviewRequestDelegationMemberCount", ScalarType.INT);
    }

    @Override
    public boolean reviewRequestDelegationNotifyTeam() {
        return cursor.getRequired("reviewRequestDelegationNotifyTeam", ScalarType.BOOLEAN);
    }

    @Override
    public String slug() {
        return cursor.getRequired("slug", ScalarType.STRING);
    }

    @Override
    public String teamsResourcePath() {
        return cursor.getRequired("teamsResourcePath", ScalarType.STRING);
    }

    @Override
    public String teamsUrl() {
        return cursor.getRequired("teamsUrl", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public boolean viewerCanAdminister() {
        return cursor.getRequired("viewerCanAdminister", ScalarType.BOOLEAN);
    }

    /**
     * @deprecated `Team.viewerCanSubscribe` will be removed. Team notifications subscriptions are being deprecated.
     *     Removal on 2026-07-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public boolean viewerCanSubscribe() {
        return cursor.getRequired("viewerCanSubscribe", ScalarType.BOOLEAN);
    }

    /**
     * @deprecated `Team.viewerSubscription` will be removed. Team notifications subscriptions are being deprecated.
     *     Removal on 2026-07-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public @Nullable SubscriptionState viewerSubscription() {
        return cursor.get(
                "viewerSubscription", ScalarType.enumeration(SubscriptionState::fromWire, SubscriptionState.IGNORED));
    }
}
