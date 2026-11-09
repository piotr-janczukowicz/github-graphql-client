package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ProjectCardEdgeSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"cursor\":\"x\"" + "," + "\"node\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "}";

    private static List<Object> readWithArguments(final ProjectCardEdgeSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.cursor());
        values.add(selector.node(ProjectCardSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectCardEdgeSelectorImpl(new RecordingCursor(root)));
        final ProjectCardEdgeSelectorImpl selector =
                new ProjectCardEdgeSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", Instant.parse("2024-05-01T10:15:30Z"));
    }
}
