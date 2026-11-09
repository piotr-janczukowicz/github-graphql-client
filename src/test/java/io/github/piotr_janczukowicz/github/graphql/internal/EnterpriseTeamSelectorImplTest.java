package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamAssignedOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamEnterpriseTeamMembersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamMemberOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamMemberOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamOrganizationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamOrganizationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamOrganizationSelectionType;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamNotificationSetting;
import io.github.piotr_janczukowicz.github.graphql.model.TeamPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class EnterpriseTeamSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"assignedOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"combinedSlug\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"description\":\"x\"" + "," + "\"enterprise\":{\"avatarUrl\": \"x\"}" + ","
            + "\"enterpriseTeamMembers\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"fullDatabaseId\":\"1\"" + "," + "\"id\":\"x\"" + "," + "\"isViewerMember\":true" + ","
            + "\"name\":\"x\"" + "," + "\"notificationSetting\":\"NOTIFICATIONS_DISABLED\"" + ","
            + "\"organizationSelectionType\":\"ALL\"" + "," + "\"privacy\":\"SECRET\"" + "," + "\"slug\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"viewerCanAdminister\":true" + "}";

    private static List<Object> readWithArguments(final EnterpriseTeamSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.assignedOrganizations(
                Paging.first(1),
                EnterpriseTeamAssignedOrganizationsFilterBuilder.builder()
                        .orderBy(EnterpriseTeamOrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseTeamOrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.combinedSlug());
        values.add(selector.createdAt());
        values.add(selector.description());
        values.add(selector.enterprise(EnterpriseSelector::avatarUrl));
        values.add(selector.enterpriseTeamMembers(
                Paging.first(1),
                EnterpriseTeamEnterpriseTeamMembersFilterBuilder.builder()
                        .orderBy(EnterpriseTeamMemberOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseTeamMemberOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                UserSelector::anyPinnableItems));
        values.add(selector.fullDatabaseId());
        values.add(selector.id());
        values.add(selector.isViewerMember());
        values.add(selector.name());
        values.add(selector.notificationSetting());
        values.add(selector.organizationSelectionType());
        values.add(selector.privacy());
        values.add(selector.slug());
        values.add(selector.updatedAt());
        values.add(selector.viewerCanAdminister());
        return values;
    }

    private static List<Object> readWithoutArguments(final EnterpriseTeamSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.assignedOrganizations(Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.enterpriseTeamMembers(Paging.first(1), UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new EnterpriseTeamSelectorImpl(new RecordingCursor(root)));
        final EnterpriseTeamSelectorImpl selector =
                new EnterpriseTeamSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(true), false, null),
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        new Page<>(List.of(true), false, null),
                        BigInteger.ONE,
                        "x",
                        true,
                        "x",
                        TeamNotificationSetting.NOTIFICATIONS_DISABLED,
                        EnterpriseTeamOrganizationSelectionType.ALL,
                        TeamPrivacy.SECRET,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new EnterpriseTeamSelectorImpl(new RecordingCursor(root)));
        final EnterpriseTeamSelectorImpl selector =
                new EnterpriseTeamSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(new Page<>(List.of(true), false, null), new Page<>(List.of(true), false, null));
    }
}
