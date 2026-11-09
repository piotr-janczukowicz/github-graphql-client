package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class WorkflowSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1"
            + "," + "\"id\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"runs\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"state\":\"ACTIVE\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\""
            + "}";

    private static List<Object> readWithArguments(final WorkflowSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.resourcePath());
        values.add(selector.runs(
                Paging.first(1),
                WorkflowRunsFilterBuilder.builder()
                        .orderBy(WorkflowRunOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(WorkflowRunOrderField.CREATED_AT)
                                .build())
                        .build(),
                WorkflowRunSelector::createdAt));
        values.add(selector.state());
        values.add(selector.updatedAt());
        values.add(selector.url());
        return values;
    }

    private static List<Object> readWithoutArguments(final WorkflowSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.runs(Paging.first(1), WorkflowRunSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new WorkflowSelectorImpl(new RecordingCursor(root)));
        final WorkflowSelectorImpl selector =
                new WorkflowSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        "x",
                        "x",
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        WorkflowState.ACTIVE,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new WorkflowSelectorImpl(new RecordingCursor(root)));
        final WorkflowSelectorImpl selector =
                new WorkflowSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }
}
