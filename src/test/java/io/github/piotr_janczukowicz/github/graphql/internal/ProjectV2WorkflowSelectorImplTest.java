package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ProjectV2WorkflowSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1" + "," + "\"enabled\":true" + ","
                    + "\"fullDatabaseId\":\"1\"" + "," + "\"id\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"number\":1"
                    + "," + "\"project\":{\"closed\": true}" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final ProjectV2WorkflowSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.enabled());
        values.add(selector.fullDatabaseId());
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.number());
        values.add(selector.project(ProjectV2Selector::closed));
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2WorkflowSelectorImpl(new RecordingCursor(root)));
        final ProjectV2WorkflowSelectorImpl selector =
                new ProjectV2WorkflowSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"),
                        1,
                        true,
                        BigInteger.ONE,
                        "x",
                        "x",
                        1,
                        true,
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
