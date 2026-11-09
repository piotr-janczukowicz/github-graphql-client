package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ProjectProgressSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"doneCount\":1" + "," + "\"donePercentage\":1.5" + ","
            + "\"enabled\":true" + "," + "\"inProgressCount\":1" + "," + "\"inProgressPercentage\":1.5" + ","
            + "\"todoCount\":1" + "," + "\"todoPercentage\":1.5" + "}";

    private static List<Object> readWithArguments(final ProjectProgressSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.doneCount());
        values.add(selector.donePercentage());
        values.add(selector.enabled());
        values.add(selector.inProgressCount());
        values.add(selector.inProgressPercentage());
        values.add(selector.todoCount());
        values.add(selector.todoPercentage());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectProgressSelectorImpl(new RecordingCursor(root)));
        final ProjectProgressSelectorImpl selector =
                new ProjectProgressSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1, 1.5, true, 1, 1.5, 1, 1.5);
    }
}
