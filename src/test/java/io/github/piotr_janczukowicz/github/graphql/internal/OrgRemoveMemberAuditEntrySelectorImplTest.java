package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorLocationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OperationType;
import io.github.piotr_janczukowicz.github.graphql.model.OrgRemoveMemberAuditEntryMembershipType;
import io.github.piotr_janczukowicz.github.graphql.model.OrgRemoveMemberAuditEntryReason;
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
class OrgRemoveMemberAuditEntrySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"action\":\"x\"" + ","
            + "\"actor\":{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}" + "," + "\"actorIp\":\"x\"" + ","
            + "\"actorLocation\":{\"city\": \"x\"}" + "," + "\"actorLogin\":\"x\"" + "," + "\"actorResourcePath\":\"x\""
            + "," + "\"actorUrl\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + ","
            + "\"membershipTypes\":[\"ADMIN\"]" + "," + "\"operationType\":\"ACCESS\"" + ","
            + "\"organization\":{\"anyPinnableItems\": true}" + "," + "\"organizationName\":\"x\"" + ","
            + "\"organizationResourcePath\":\"x\"" + "," + "\"organizationUrl\":\"x\"" + ","
            + "\"reason\":\"SAML_EXTERNAL_IDENTITY_MISSING\"" + "," + "\"user\":{\"anyPinnableItems\": true}" + ","
            + "\"userLogin\":\"x\"" + "," + "\"userResourcePath\":\"x\"" + "," + "\"userUrl\":\"x\"" + "}";

    private static List<Object> readWithArguments(final OrgRemoveMemberAuditEntrySelectorImpl selector) {
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
        values.add(selector.membershipTypes());
        values.add(selector.operationType());
        values.add(selector.organization(OrganizationSelector::anyPinnableItems));
        values.add(selector.organizationName());
        values.add(selector.organizationResourcePath());
        values.add(selector.organizationUrl());
        values.add(selector.reason());
        values.add(selector.user(UserSelector::anyPinnableItems));
        values.add(selector.userLogin());
        values.add(selector.userResourcePath());
        values.add(selector.userUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrgRemoveMemberAuditEntrySelectorImpl(new RecordingCursor(root)));
        final OrgRemoveMemberAuditEntrySelectorImpl selector =
                new OrgRemoveMemberAuditEntrySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

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
                        List.of(OrgRemoveMemberAuditEntryMembershipType.ADMIN),
                        OperationType.ACCESS,
                        true,
                        "x",
                        "x",
                        "x",
                        OrgRemoveMemberAuditEntryReason.SAML_EXTERNAL_IDENTITY_MISSING,
                        true,
                        "x",
                        "x",
                        "x");
    }
}
