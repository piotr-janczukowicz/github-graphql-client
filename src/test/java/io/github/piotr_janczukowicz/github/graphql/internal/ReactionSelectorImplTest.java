package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ReactableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ReactionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"content\":\"CONFUSED\"" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1" + "," + "\"id\":\"x\"" + ","
            + "\"reactable\":{\"databaseId\": 1}" + "," + "\"user\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final ReactionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.content());
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.reactable(ReactableSelector::databaseId));
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReactionSelectorImpl(new RecordingCursor(root)));
        final ReactionSelectorImpl selector =
                new ReactionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(ReactionContent.CONFUSED, Instant.parse("2024-05-01T10:15:30Z"), 1, "x", 1, true);
    }
}
