package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SavedReplySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"body\":\"x\"" + "," + "\"bodyHTML\":\"x\"" + "," + "\"databaseId\":1" + "," + "\"id\":\"x\"" + ","
                    + "\"title\":\"x\"" + "," + "\"user\":{\"avatarUrl\": \"x\"}" + "}";

    private static List<Object> readWithArguments(final SavedReplySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.body());
        values.add(selector.bodyHTML());
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.title());
        values.add(selector.user(ActorSelector::avatarUrl));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SavedReplySelectorImpl(new RecordingCursor(root)));
        final SavedReplySelectorImpl selector =
                new SavedReplySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", 1, "x", "x", "x");
    }
}
