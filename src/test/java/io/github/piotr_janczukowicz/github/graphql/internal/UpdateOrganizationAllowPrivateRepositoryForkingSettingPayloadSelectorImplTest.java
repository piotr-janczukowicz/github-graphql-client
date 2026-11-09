package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientMutationId\":\"x\"" + "," + "\"message\":\"x\"" + ","
            + "\"organization\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(
            final UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.message());
        values.add(selector.organization(OrganizationSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadSelectorImpl(
                new RecordingCursor(root)));
        final UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadSelectorImpl selector =
                new UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", true);
    }
}
