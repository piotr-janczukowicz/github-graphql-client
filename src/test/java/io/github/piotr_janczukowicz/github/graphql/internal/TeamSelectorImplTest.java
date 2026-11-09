package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FiltersBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2PermissionLevel;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.TeamAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamChildTeamsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamMemberOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamMemberOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.TeamMemberRole;
import io.github.piotr_janczukowicz.github.graphql.model.TeamMemberStatusesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamMembersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamMembershipType;
import io.github.piotr_janczukowicz.github.graphql.model.TeamNotificationSetting;
import io.github.piotr_janczukowicz.github.graphql.model.TeamOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.TeamPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.TeamProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamRepositoryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamRepositoryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.TeamReviewAssignmentAlgorithm;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class TeamSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"ancestors\":{\"nodes\": [{\"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"avatarUrl\":\"x\"" + ","
            + "\"childTeams\":{\"nodes\": [{\"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"combinedSlug\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1"
            + "," + "\"description\":\"x\"" + "," + "\"editTeamResourcePath\":\"x\"" + "," + "\"editTeamUrl\":\"x\""
            + "," + "\"id\":\"x\"" + ","
            + "\"invitations\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"memberStatuses\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"members\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"membersResourcePath\":\"x\"" + "," + "\"membersUrl\":\"x\"" + "," + "\"name\":\"x\"" + ","
            + "\"newTeamResourcePath\":\"x\"" + "," + "\"newTeamUrl\":\"x\"" + ","
            + "\"notificationSetting\":\"NOTIFICATIONS_DISABLED\"" + ","
            + "\"organization\":{\"anyPinnableItems\": true}" + "," + "\"parentTeam\":{\"avatarUrl\": \"x\"}" + ","
            + "\"privacy\":\"SECRET\"" + "," + "\"projectV2\":{\"closed\": true}" + ","
            + "\"projectsV2\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"repositories\":{\"nodes\": [{\"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repositoriesResourcePath\":\"x\"" + "," + "\"repositoriesUrl\":\"x\"" + ","
            + "\"resourcePath\":\"x\"" + "," + "\"reviewRequestDelegationAlgorithm\":\"LOAD_BALANCE\"" + ","
            + "\"reviewRequestDelegationEnabled\":true" + "," + "\"reviewRequestDelegationMemberCount\":1" + ","
            + "\"reviewRequestDelegationNotifyTeam\":true" + "," + "\"slug\":\"x\"" + ","
            + "\"teamsResourcePath\":\"x\"" + "," + "\"teamsUrl\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "," + "\"viewerCanAdminister\":true"
            + "," + "\"viewerCanSubscribe\":true" + "," + "\"viewerSubscription\":\"IGNORED\"" + "}";

    private static List<Object> readWithArguments(final TeamSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.ancestors(Paging.first(1), TeamSelector::avatarUrl));
        values.add(
                selector.avatarUrl(TeamAvatarUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.childTeams(
                Paging.first(1),
                TeamChildTeamsFilterBuilder.builder()
                        .immediateOnly(true)
                        .orderBy(TeamOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(TeamOrderField.NAME)
                                .build())
                        .userLogins(List.of("x"))
                        .build(),
                TeamSelector::avatarUrl));
        values.add(selector.combinedSlug());
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.description());
        values.add(selector.editTeamResourcePath());
        values.add(selector.editTeamUrl());
        values.add(selector.id());
        values.add(selector.invitations(Paging.first(1), OrganizationInvitationSelector::createdAt));
        values.add(selector.memberStatuses(
                Paging.first(1),
                TeamMemberStatusesFilterBuilder.builder()
                        .orderBy(UserStatusOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(UserStatusOrderField.UPDATED_AT)
                                .build())
                        .build(),
                UserStatusSelector::createdAt));
        values.add(selector.members(
                Paging.first(1),
                TeamMembersFilterBuilder.builder()
                        .membership(TeamMembershipType.ALL)
                        .orderBy(TeamMemberOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(TeamMemberOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .role(TeamMemberRole.MAINTAINER)
                        .build(),
                UserSelector::anyPinnableItems));
        values.add(selector.membersResourcePath());
        values.add(selector.membersUrl());
        values.add(selector.name());
        values.add(selector.newTeamResourcePath());
        values.add(selector.newTeamUrl());
        values.add(selector.notificationSetting());
        values.add(selector.organization(OrganizationSelector::anyPinnableItems));
        values.add(selector.parentTeam(TeamSelector::avatarUrl));
        values.add(selector.privacy());
        values.add(selector.projectV2(1, ProjectV2Selector::closed));
        values.add(selector.projectsV2(
                Paging.first(1),
                TeamProjectsV2FilterBuilder.builder()
                        .filterBy(ProjectV2FiltersBuilder.builder().build())
                        .minPermissionLevel(ProjectV2PermissionLevel.ADMIN)
                        .orderBy(ProjectV2OrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2OrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                ProjectV2Selector::closed));
        values.add(selector.repositories(
                Paging.first(1),
                TeamRepositoriesFilterBuilder.builder()
                        .orderBy(TeamRepositoryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(TeamRepositoryOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.repositoriesResourcePath());
        values.add(selector.repositoriesUrl());
        values.add(selector.resourcePath());
        values.add(selector.reviewRequestDelegationAlgorithm());
        values.add(selector.reviewRequestDelegationEnabled());
        values.add(selector.reviewRequestDelegationMemberCount());
        values.add(selector.reviewRequestDelegationNotifyTeam());
        values.add(selector.slug());
        values.add(selector.teamsResourcePath());
        values.add(selector.teamsUrl());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.viewerCanAdminister());
        values.add(selector.viewerCanSubscribe());
        values.add(selector.viewerSubscription());
        return values;
    }

    private static List<Object> readWithoutArguments(final TeamSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl());
        values.add(selector.childTeams(Paging.first(1), TeamSelector::avatarUrl));
        values.add(selector.memberStatuses(Paging.first(1), UserStatusSelector::createdAt));
        values.add(selector.members(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.projectsV2(Paging.first(1), ProjectV2Selector::closed));
        values.add(selector.repositories(Paging.first(1), RepositorySelector::allowUpdateBranch));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new TeamSelectorImpl(new RecordingCursor(root)));
        final TeamSelectorImpl selector = new TeamSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of("x"), false, null),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        "x",
                        "x",
                        "x",
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        TeamNotificationSetting.NOTIFICATIONS_DISABLED,
                        true,
                        "x",
                        TeamPrivacy.SECRET,
                        true,
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        "x",
                        "x",
                        "x",
                        TeamReviewAssignmentAlgorithm.LOAD_BALANCE,
                        true,
                        1,
                        true,
                        "x",
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true,
                        true,
                        SubscriptionState.IGNORED);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new TeamSelectorImpl(new RecordingCursor(root)));
        final TeamSelectorImpl selector = new TeamSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null));
    }
}
