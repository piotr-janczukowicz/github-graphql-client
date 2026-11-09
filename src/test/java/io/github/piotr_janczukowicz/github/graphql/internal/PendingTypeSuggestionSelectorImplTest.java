package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeColor;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PendingTypeSuggestionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
                    + "\"id\":\"x\"" + "," + "\"issueType\":{\"color\": \"BLUE\"}" + "," + "\"rationale\":\"x\"" + ","
                    + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final PendingTypeSuggestionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.issueType(IssueTypeSelector::color));
        values.add(selector.rationale());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PendingTypeSuggestionSelectorImpl(new RecordingCursor(root)));
        final PendingTypeSuggestionSelectorImpl selector =
                new PendingTypeSuggestionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        IssueTypeColor.BLUE,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
