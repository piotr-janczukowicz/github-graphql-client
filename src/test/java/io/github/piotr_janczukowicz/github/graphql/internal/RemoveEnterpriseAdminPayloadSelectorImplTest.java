package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RemoveEnterpriseAdminPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"admin\":{\"anyPinnableItems\": true}" + ","
            + "\"clientMutationId\":\"x\"" + "," + "\"enterprise\":{\"avatarUrl\": \"x\"}" + "," + "\"message\":\"x\""
            + "," + "\"viewer\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final RemoveEnterpriseAdminPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.admin(UserSelector::anyPinnableItems));
        values.add(selector.clientMutationId());
        values.add(selector.enterprise(EnterpriseSelector::avatarUrl));
        values.add(selector.message());
        values.add(selector.viewer(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RemoveEnterpriseAdminPayloadSelectorImpl(new RecordingCursor(root)));
        final RemoveEnterpriseAdminPayloadSelectorImpl selector =
                new RemoveEnterpriseAdminPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, "x", "x", "x", true);
    }
}
