package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldType;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2IterationFieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2IterationFieldSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"configuration\":{\"duration\": 1}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"dataType\":\"ASSIGNEES\"" + "," + "\"databaseId\":1"
            + "," + "\"id\":\"x\"" + "," + "\"isIssueField\":true" + "," + "\"name\":\"x\"" + ","
            + "\"project\":{\"closed\": true}" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final ProjectV2IterationFieldSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.configuration(ProjectV2IterationFieldConfigurationSelector::duration));
        values.add(selector.createdAt());
        values.add(selector.dataType());
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.isIssueField());
        values.add(selector.name());
        values.add(selector.project(ProjectV2Selector::closed));
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2IterationFieldSelectorImpl(new RecordingCursor(root)));
        final ProjectV2IterationFieldSelectorImpl selector =
                new ProjectV2IterationFieldSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        1,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        ProjectV2FieldType.ASSIGNEES,
                        1,
                        "x",
                        true,
                        "x",
                        true,
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
