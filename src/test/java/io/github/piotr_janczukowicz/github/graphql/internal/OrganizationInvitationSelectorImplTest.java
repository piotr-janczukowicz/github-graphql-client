package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationRole;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSource;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationType;
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
class OrganizationInvitationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"email\":\"x\""
            + "," + "\"id\":\"x\"" + "," + "\"invitationSource\":\"ENTERPRISE_ORGANIZATION_CREATION\"" + ","
            + "\"invitationType\":\"EMAIL\"" + "," + "\"invitee\":{\"anyPinnableItems\": true}" + ","
            + "\"inviter\":{\"anyPinnableItems\": true}" + "," + "\"inviterActor\":{\"anyPinnableItems\": true}" + ","
            + "\"organization\":{\"anyPinnableItems\": true}" + "," + "\"role\":\"ADMIN\"" + "}";

    private static List<Object> readWithArguments(final OrganizationInvitationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.email());
        values.add(selector.id());
        values.add(selector.invitationSource());
        values.add(selector.invitationType());
        values.add(selector.invitee(UserSelector::anyPinnableItems));
        values.add(selector.inviter(UserSelector::anyPinnableItems));
        values.add(selector.inviterActor(UserSelector::anyPinnableItems));
        values.add(selector.organization(OrganizationSelector::anyPinnableItems));
        values.add(selector.role());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrganizationInvitationSelectorImpl(new RecordingCursor(root)));
        final OrganizationInvitationSelectorImpl selector =
                new OrganizationInvitationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        OrganizationInvitationSource.ENTERPRISE_ORGANIZATION_CREATION,
                        OrganizationInvitationType.EMAIL,
                        true,
                        true,
                        true,
                        true,
                        OrganizationInvitationRole.ADMIN);
    }
}
