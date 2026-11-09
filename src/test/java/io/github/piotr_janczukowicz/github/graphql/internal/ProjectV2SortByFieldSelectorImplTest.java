package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2SortByFieldSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"direction\":\"ASC\"" + ","
            + "\"field\":{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + "}";

    private static List<Object> readWithArguments(final ProjectV2SortByFieldSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.direction());
        values.add(selector.field(child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2SortByFieldSelectorImpl(new RecordingCursor(root)));
        final ProjectV2SortByFieldSelectorImpl selector =
                new ProjectV2SortByFieldSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(OrderDirection.ASC, Instant.parse("2024-05-01T10:15:30Z"));
    }
}
