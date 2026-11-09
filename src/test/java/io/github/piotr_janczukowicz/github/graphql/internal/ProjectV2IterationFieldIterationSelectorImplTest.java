package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2IterationFieldIterationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"duration\":1" + "," + "\"id\":\"x\"" + ","
            + "\"startDate\":\"2024-05-01\"" + "," + "\"title\":\"x\"" + "," + "\"titleHTML\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ProjectV2IterationFieldIterationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.duration());
        values.add(selector.id());
        values.add(selector.startDate());
        values.add(selector.title());
        values.add(selector.titleHTML());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2IterationFieldIterationSelectorImpl(new RecordingCursor(root)));
        final ProjectV2IterationFieldIterationSelectorImpl selector =
                new ProjectV2IterationFieldIterationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1, "x", LocalDate.of(2024, 5, 1), "x", "x");
    }
}
