package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorInvitationSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class AcceptEnterpriseAdministratorInvitationPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientMutationId\":\"x\"" + ","
            + "\"invitation\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "," + "\"message\":\"x\"" + "}";

    private static List<Object> readWithArguments(
            final AcceptEnterpriseAdministratorInvitationPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.invitation(EnterpriseAdministratorInvitationSelector::createdAt));
        values.add(selector.message());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new AcceptEnterpriseAdministratorInvitationPayloadSelectorImpl(new RecordingCursor(root)));
        final AcceptEnterpriseAdministratorInvitationPayloadSelectorImpl selector =
                new AcceptEnterpriseAdministratorInvitationPayloadSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", Instant.parse("2024-05-01T10:15:30Z"), "x");
    }
}
