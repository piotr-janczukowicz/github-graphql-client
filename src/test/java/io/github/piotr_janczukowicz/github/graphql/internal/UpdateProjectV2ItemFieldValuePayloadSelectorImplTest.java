package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UpdateProjectV2ItemFieldValuePayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientMutationId\":\"x\"" + ","
            + "\"projectV2Item\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "}";

    private static List<Object> readWithArguments(final UpdateProjectV2ItemFieldValuePayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.projectV2Item(ProjectV2ItemSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UpdateProjectV2ItemFieldValuePayloadSelectorImpl(new RecordingCursor(root)));
        final UpdateProjectV2ItemFieldValuePayloadSelectorImpl selector =
                new UpdateProjectV2ItemFieldValuePayloadSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", Instant.parse("2024-05-01T10:15:30Z"));
    }
}
