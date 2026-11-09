package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorLocationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OperationType;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSelector;
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
class OrgInviteMemberAuditEntrySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"action\":\"x\"" + "," + "\"actor\":{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}" + ","
                    + "\"actorIp\":\"x\"" + "," + "\"actorLocation\":{\"city\": \"x\"}" + "," + "\"actorLogin\":\"x\""
                    + "," + "\"actorResourcePath\":\"x\"" + "," + "\"actorUrl\":\"x\"" + ","
                    + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"email\":\"x\"" + "," + "\"id\":\"x\"" + ","
                    + "\"operationType\":\"ACCESS\"" + "," + "\"organization\":{\"anyPinnableItems\": true}" + ","
                    + "\"organizationInvitation\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
                    + "\"organizationName\":\"x\"" + "," + "\"organizationResourcePath\":\"x\"" + ","
                    + "\"organizationUrl\":\"x\"" + "," + "\"user\":{\"anyPinnableItems\": true}" + ","
                    + "\"userLogin\":\"x\"" + "," + "\"userResourcePath\":\"x\"" + "," + "\"userUrl\":\"x\"" + "}";

    private static List<Object> readWithArguments(final OrgInviteMemberAuditEntrySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.action());
        values.add(selector.actor(child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.actorIp());
        values.add(selector.actorLocation(ActorLocationSelector::city));
        values.add(selector.actorLogin());
        values.add(selector.actorResourcePath());
        values.add(selector.actorUrl());
        values.add(selector.createdAt());
        values.add(selector.email());
        values.add(selector.id());
        values.add(selector.operationType());
        values.add(selector.organization(OrganizationSelector::anyPinnableItems));
        values.add(selector.organizationInvitation(OrganizationInvitationSelector::createdAt));
        values.add(selector.organizationName());
        values.add(selector.organizationResourcePath());
        values.add(selector.organizationUrl());
        values.add(selector.user(UserSelector::anyPinnableItems));
        values.add(selector.userLogin());
        values.add(selector.userResourcePath());
        values.add(selector.userUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrgInviteMemberAuditEntrySelectorImpl(new RecordingCursor(root)));
        final OrgInviteMemberAuditEntrySelectorImpl selector =
                new OrgInviteMemberAuditEntrySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

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
                        "x",
                        OperationType.ACCESS,
                        true,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        "x",
                        true,
                        "x",
                        "x",
                        "x");
    }
}
