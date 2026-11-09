package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DiscussionCategorySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"description\":\"x\"" + "," + "\"emoji\":\"x\""
                    + "," + "\"emojiHTML\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"isAnswerable\":true" + ","
                    + "\"name\":\"x\"" + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"slug\":\"x\""
                    + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final DiscussionCategorySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.description());
        values.add(selector.emoji());
        values.add(selector.emojiHTML());
        values.add(selector.id());
        values.add(selector.isAnswerable());
        values.add(selector.name());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.slug());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DiscussionCategorySelectorImpl(new RecordingCursor(root)));
        final DiscussionCategorySelectorImpl selector =
                new DiscussionCategorySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        "x",
                        "x",
                        true,
                        "x",
                        true,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
