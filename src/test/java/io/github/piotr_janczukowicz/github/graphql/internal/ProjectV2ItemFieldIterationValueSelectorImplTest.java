package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2ItemFieldIterationValueSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"creator\":{\"avatarUrl\": \"x\"}" + "," + "\"databaseId\":1" + "," + "\"duration\":1" + ","
            + "\"field\":{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"id\":\"x\"" + "," + "\"item\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"iterationId\":\"x\"" + "," + "\"startDate\":\"2024-05-01\"" + "," + "\"title\":\"x\"" + ","
            + "\"titleHTML\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final ProjectV2ItemFieldIterationValueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.databaseId());
        values.add(selector.duration());
        values.add(selector.field(child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.id());
        values.add(selector.item(ProjectV2ItemSelector::createdAt));
        values.add(selector.iterationId());
        values.add(selector.startDate());
        values.add(selector.title());
        values.add(selector.titleHTML());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2ItemFieldIterationValueSelectorImpl(new RecordingCursor(root)));
        final ProjectV2ItemFieldIterationValueSelectorImpl selector =
                new ProjectV2ItemFieldIterationValueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        1,
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        LocalDate.of(2024, 5, 1),
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }
}
