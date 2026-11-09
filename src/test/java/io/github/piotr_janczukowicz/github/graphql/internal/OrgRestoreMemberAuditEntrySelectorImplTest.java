package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorLocationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OperationType;
import io.github.piotr_janczukowicz.github.graphql.model.OrgRestoreMemberMembershipOrganizationAuditEntryDataSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class OrgRestoreMemberAuditEntrySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"action\":\"x\"" + ","
            + "\"actor\":{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}" + "," + "\"actorIp\":\"x\"" + ","
            + "\"actorLocation\":{\"city\": \"x\"}" + "," + "\"actorLogin\":\"x\"" + "," + "\"actorResourcePath\":\"x\""
            + "," + "\"actorUrl\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + ","
            + "\"operationType\":\"ACCESS\"" + "," + "\"organization\":{\"anyPinnableItems\": true}" + ","
            + "\"organizationName\":\"x\"" + "," + "\"organizationResourcePath\":\"x\"" + ","
            + "\"organizationUrl\":\"x\"" + "," + "\"restoredCustomEmailRoutingsCount\":1" + ","
            + "\"restoredIssueAssignmentsCount\":1" + ","
            + "\"restoredMemberships\":[{\"__typename\": \"OrgRestoreMemberMembershipOrganizationAuditEntryData\", \"organizationName\": \"x\"}]"
            + "," + "\"restoredMembershipsCount\":1" + "," + "\"restoredRepositoriesCount\":1" + ","
            + "\"restoredRepositoryStarsCount\":1" + "," + "\"restoredRepositoryWatchesCount\":1" + ","
            + "\"user\":{\"anyPinnableItems\": true}" + "," + "\"userLogin\":\"x\"" + "," + "\"userResourcePath\":\"x\""
            + "," + "\"userUrl\":\"x\"" + "}";

    private static List<Object> readWithArguments(final OrgRestoreMemberAuditEntrySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.action());
        values.add(selector.actor(child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.actorIp());
        values.add(selector.actorLocation(ActorLocationSelector::city));
        values.add(selector.actorLogin());
        values.add(selector.actorResourcePath());
        values.add(selector.actorUrl());
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.operationType());
        values.add(selector.organization(OrganizationSelector::anyPinnableItems));
        values.add(selector.organizationName());
        values.add(selector.organizationResourcePath());
        values.add(selector.organizationUrl());
        values.add(selector.restoredCustomEmailRoutingsCount());
        values.add(selector.restoredIssueAssignmentsCount());
        values.add(selector.restoredMemberships(child -> child.on(
                OrgRestoreMemberMembershipOrganizationAuditEntryDataSelector.class,
                OrgRestoreMemberMembershipOrganizationAuditEntryDataSelector::organizationName)));
        values.add(selector.restoredMembershipsCount());
        values.add(selector.restoredRepositoriesCount());
        values.add(selector.restoredRepositoryStarsCount());
        values.add(selector.restoredRepositoryWatchesCount());
        values.add(selector.user(UserSelector::anyPinnableItems));
        values.add(selector.userLogin());
        values.add(selector.userResourcePath());
        values.add(selector.userUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrgRestoreMemberAuditEntrySelectorImpl(new RecordingCursor(root)));
        final OrgRestoreMemberAuditEntrySelectorImpl selector =
                new OrgRestoreMemberAuditEntrySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        OperationType.ACCESS,
                        true,
                        "x",
                        "x",
                        "x",
                        1,
                        1,
                        List.of("x"),
                        1,
                        1,
                        1,
                        1,
                        true,
                        "x",
                        "x",
                        "x");
    }
}
