package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentitySamlAttributesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentityScimAttributesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ExternalIdentitySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"guid\":\"x\"" + "," + "\"id\":\"x\"" + ","
            + "\"organizationInvitation\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"samlIdentity\":{\"familyName\": \"x\"}" + "," + "\"scimIdentity\":{\"familyName\": \"x\"}" + ","
            + "\"user\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final ExternalIdentitySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.guid());
        values.add(selector.id());
        values.add(selector.organizationInvitation(OrganizationInvitationSelector::createdAt));
        values.add(selector.samlIdentity(ExternalIdentitySamlAttributesSelector::familyName));
        values.add(selector.scimIdentity(ExternalIdentityScimAttributesSelector::familyName));
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ExternalIdentitySelectorImpl(new RecordingCursor(root)));
        final ExternalIdentitySelectorImpl selector =
                new ExternalIdentitySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", Instant.parse("2024-05-01T10:15:30Z"), "x", "x", true);
    }
}
