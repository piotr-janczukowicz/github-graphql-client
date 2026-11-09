package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.AssignedEventSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class IssueTimelineItemEdgeSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"cursor\":\"x\"" + ","
            + "\"node\":{\"__typename\": \"AssignedEvent\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + "}";

    private static List<Object> readWithArguments(final IssueTimelineItemEdgeSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.cursor());
        values.add(selector.node(child -> child.on(AssignedEventSelector.class, AssignedEventSelector::createdAt)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueTimelineItemEdgeSelectorImpl(new RecordingCursor(root)));
        final IssueTimelineItemEdgeSelectorImpl selector =
                new IssueTimelineItemEdgeSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", Instant.parse("2024-05-01T10:15:30Z"));
    }
}
