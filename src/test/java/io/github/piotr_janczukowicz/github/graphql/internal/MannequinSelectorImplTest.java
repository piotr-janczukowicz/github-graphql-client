package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.MannequinAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MannequinSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"avatarUrl\":\"x\"" + ","
            + "\"claimant\":{\"anyPinnableItems\": true}" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"databaseId\":1" + "," + "\"email\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"login\":\"x\"" + ","
            + "\"name\":\"x\"" + "," + "\"resourcePath\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final MannequinSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl(
                MannequinAvatarUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.claimant(UserSelector::anyPinnableItems));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.email());
        values.add(selector.id());
        values.add(selector.login());
        values.add(selector.name());
        values.add(selector.resourcePath());
        values.add(selector.updatedAt());
        values.add(selector.url());
        return values;
    }

    private static List<Object> readWithoutArguments(final MannequinSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new MannequinSelectorImpl(new RecordingCursor(root)));
        final MannequinSelectorImpl selector =
                new MannequinSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        true,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        1,
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new MannequinSelectorImpl(new RecordingCursor(root)));
        final MannequinSelectorImpl selector =
                new MannequinSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
