package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdateSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UpdateProjectV2StatusUpdatePayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"clientMutationId\":\"x\"" + "," + "\"statusUpdate\":{\"body\": \"x\"}" + "}";

    private static List<Object> readWithArguments(final UpdateProjectV2StatusUpdatePayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.statusUpdate(ProjectV2StatusUpdateSelector::body));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UpdateProjectV2StatusUpdatePayloadSelectorImpl(new RecordingCursor(root)));
        final UpdateProjectV2StatusUpdatePayloadSelectorImpl selector =
                new UpdateProjectV2StatusUpdatePayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x");
    }
}
