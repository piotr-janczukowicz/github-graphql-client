package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewEffortLevel;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryCopilotCodeReviewEffortSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"configured\":\"AUTO\"" + "," + "\"effective\":\"AUTO\"" + "}";

    private static List<Object> readWithArguments(final RepositoryCopilotCodeReviewEffortSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.configured());
        values.add(selector.effective());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryCopilotCodeReviewEffortSelectorImpl(new RecordingCursor(root)));
        final RepositoryCopilotCodeReviewEffortSelectorImpl selector =
                new RepositoryCopilotCodeReviewEffortSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(CopilotCodeReviewEffortLevel.AUTO, CopilotCodeReviewEffortLevel.AUTO);
    }
}
