package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorRole;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class EnterpriseAdministratorInvitationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"email\":\"x\""
            + "," + "\"enterprise\":{\"avatarUrl\": \"x\"}" + "," + "\"id\":\"x\"" + ","
            + "\"invitee\":{\"anyPinnableItems\": true}" + "," + "\"inviter\":{\"anyPinnableItems\": true}" + ","
            + "\"role\":\"BILLING_MANAGER\"" + "}";

    private static List<Object> readWithArguments(final EnterpriseAdministratorInvitationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.email());
        values.add(selector.enterprise(EnterpriseSelector::avatarUrl));
        values.add(selector.id());
        values.add(selector.invitee(UserSelector::anyPinnableItems));
        values.add(selector.inviter(UserSelector::anyPinnableItems));
        values.add(selector.role());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new EnterpriseAdministratorInvitationSelectorImpl(new RecordingCursor(root)));
        final EnterpriseAdministratorInvitationSelectorImpl selector =
                new EnterpriseAdministratorInvitationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        "x",
                        true,
                        true,
                        EnterpriseAdministratorRole.BILLING_MANAGER);
    }
}
