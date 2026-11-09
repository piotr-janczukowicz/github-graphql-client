package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2ItemFieldNumberValueSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"creator\":{\"avatarUrl\": \"x\"}" + "," + "\"databaseId\":1" + ","
            + "\"field\":{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"id\":\"x\"" + "," + "\"item\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "," + "\"number\":1.5" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final ProjectV2ItemFieldNumberValueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.databaseId());
        values.add(selector.field(child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.id());
        values.add(selector.item(ProjectV2ItemSelector::createdAt));
        values.add(selector.number());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2ItemFieldNumberValueSelectorImpl(new RecordingCursor(root)));
        final ProjectV2ItemFieldNumberValueSelectorImpl selector =
                new ProjectV2ItemFieldNumberValueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1.5,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }
}
