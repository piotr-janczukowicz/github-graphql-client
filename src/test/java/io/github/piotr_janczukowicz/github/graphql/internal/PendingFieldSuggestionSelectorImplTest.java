package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PendingFieldSuggestionSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + ","
            + "\"issueField\":{\"__typename\": \"IssueFieldDate\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"rationale\":\"x\"" + "," + "\"suggestedValue\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\""
            + "}";

    private static List<Object> readWithArguments(final PendingFieldSuggestionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.issueField(
                child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        values.add(selector.rationale());
        values.add(selector.suggestedValue());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PendingFieldSuggestionSelectorImpl(new RecordingCursor(root)));
        final PendingFieldSuggestionSelectorImpl selector =
                new PendingFieldSuggestionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }
}
