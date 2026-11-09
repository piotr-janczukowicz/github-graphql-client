package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UserContentEditSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"deletedAt\":\"2024-05-01T10:15:30Z\"" + ","
                    + "\"deletedBy\":{\"avatarUrl\": \"x\"}" + "," + "\"diff\":\"x\"" + ","
                    + "\"editedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"editor\":{\"avatarUrl\": \"x\"}" + ","
                    + "\"id\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final UserContentEditSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.deletedAt());
        values.add(selector.deletedBy(ActorSelector::avatarUrl));
        values.add(selector.diff());
        values.add(selector.editedAt());
        values.add(selector.editor(ActorSelector::avatarUrl));
        values.add(selector.id());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UserContentEditSelectorImpl(new RecordingCursor(root)));
        final UserContentEditSelectorImpl selector =
                new UserContentEditSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }
}
