package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldType;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2MultiSelectFieldMultiSelectOptionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2MultiSelectFieldOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SingleSelectFieldOptionColor;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2MultiSelectFieldSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"dataType\":\"ASSIGNEES\"" + ","
                    + "\"databaseId\":1" + "," + "\"id\":\"x\"" + "," + "\"isIssueField\":true" + ","
                    + "\"issueField\":{\"__typename\": \"IssueFieldDate\", \"createdAt\": \"2024-05-01T10:15:30Z\"}"
                    + "," + "\"multiSelectOptions\":[{\"color\": \"BLUE\"}]" + "," + "\"name\":\"x\"" + ","
                    + "\"project\":{\"closed\": true}" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final ProjectV2MultiSelectFieldSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.dataType());
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.isIssueField());
        values.add(selector.issueField(
                child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        values.add(selector.multiSelectOptions(
                ProjectV2MultiSelectFieldMultiSelectOptionsFilterBuilder.builder()
                        .names(List.of("x"))
                        .build(),
                ProjectV2MultiSelectFieldOptionSelector::color));
        values.add(selector.name());
        values.add(selector.project(ProjectV2Selector::closed));
        values.add(selector.updatedAt());
        return values;
    }

    private static List<Object> readWithoutArguments(final ProjectV2MultiSelectFieldSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.multiSelectOptions(ProjectV2MultiSelectFieldOptionSelector::color));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2MultiSelectFieldSelectorImpl(new RecordingCursor(root)));
        final ProjectV2MultiSelectFieldSelectorImpl selector =
                new ProjectV2MultiSelectFieldSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        ProjectV2FieldType.ASSIGNEES,
                        1,
                        "x",
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        List.of(ProjectV2SingleSelectFieldOptionColor.BLUE),
                        "x",
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ProjectV2MultiSelectFieldSelectorImpl(new RecordingCursor(root)));
        final ProjectV2MultiSelectFieldSelectorImpl selector =
                new ProjectV2MultiSelectFieldSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(List.of(ProjectV2SingleSelectFieldOptionColor.BLUE));
    }
}
