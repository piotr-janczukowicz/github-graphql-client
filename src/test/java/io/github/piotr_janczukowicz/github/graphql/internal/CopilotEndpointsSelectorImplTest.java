package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CopilotEndpointsSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"api\":\"x\"" + "," + "\"exp\":\"x\"" + ","
            + "\"originTracker\":\"x\"" + "," + "\"proxy\":\"x\"" + "," + "\"telemetry\":\"x\"" + "}";

    private static List<Object> readWithArguments(final CopilotEndpointsSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.api());
        values.add(selector.exp());
        values.add(selector.originTracker());
        values.add(selector.proxy());
        values.add(selector.telemetry());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CopilotEndpointsSelectorImpl(new RecordingCursor(root)));
        final CopilotEndpointsSelectorImpl selector =
                new CopilotEndpointsSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", "x", "x");
    }
}
