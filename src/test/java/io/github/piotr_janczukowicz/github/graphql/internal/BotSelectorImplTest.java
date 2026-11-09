package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.BotAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class BotSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"avatarUrl\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\""
            + "," + "\"databaseId\":1" + "," + "\"id\":\"x\"" + "," + "\"login\":\"x\"" + "," + "\"resourcePath\":\"x\""
            + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final BotSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(
                selector.avatarUrl(BotAvatarUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.login());
        values.add(selector.resourcePath());
        values.add(selector.updatedAt());
        values.add(selector.url());
        return values;
    }

    private static List<Object> readWithoutArguments(final BotSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new BotSelectorImpl(new RecordingCursor(root)));
        final BotSelectorImpl selector = new BotSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        1,
                        "x",
                        "x",
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new BotSelectorImpl(new RecordingCursor(root)));
        final BotSelectorImpl selector = new BotSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
