package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PendingLabelSuggestionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + "," + "\"label\":{\"color\": \"x\"}"
            + "," + "\"rationale\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final PendingLabelSuggestionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.label(LabelSelector::color));
        values.add(selector.rationale());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PendingLabelSuggestionSelectorImpl(new RecordingCursor(root)));
        final PendingLabelSuggestionSelectorImpl selector =
                new PendingLabelSuggestionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
