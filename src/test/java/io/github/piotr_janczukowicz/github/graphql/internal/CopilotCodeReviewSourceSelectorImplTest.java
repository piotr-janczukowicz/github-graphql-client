package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewSourceKind;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CopilotCodeReviewSourceSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"kind\":\"CUSTOM_INSTRUCTIONS\"" + "," + "\"name\":\"x\"" + "," + "\"path\":\"x\"" + "}";

    private static List<Object> readWithArguments(final CopilotCodeReviewSourceSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.kind());
        values.add(selector.name());
        values.add(selector.path());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CopilotCodeReviewSourceSelectorImpl(new RecordingCursor(root)));
        final CopilotCodeReviewSourceSelectorImpl selector =
                new CopilotCodeReviewSourceSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(CopilotCodeReviewSourceKind.CUSTOM_INSTRUCTIONS, "x", "x");
    }
}
