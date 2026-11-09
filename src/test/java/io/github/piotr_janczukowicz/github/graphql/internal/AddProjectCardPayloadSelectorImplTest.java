package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class AddProjectCardPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"cardEdge\":{\"cursor\": \"x\"}" + "," + "\"clientMutationId\":\"x\""
            + "," + "\"projectColumn\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "}";

    private static List<Object> readWithArguments(final AddProjectCardPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.cardEdge(ProjectCardEdgeSelector::cursor));
        values.add(selector.clientMutationId());
        values.add(selector.projectColumn(ProjectColumnSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new AddProjectCardPayloadSelectorImpl(new RecordingCursor(root)));
        final AddProjectCardPayloadSelectorImpl selector =
                new AddProjectCardPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", Instant.parse("2024-05-01T10:15:30Z"));
    }
}
