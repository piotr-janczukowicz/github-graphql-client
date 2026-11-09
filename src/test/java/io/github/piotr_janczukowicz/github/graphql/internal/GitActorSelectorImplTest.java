package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.GitActorAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class GitActorSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"avatarUrl\":\"x\"" + "," + "\"date\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"email\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"user\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final GitActorSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl(
                GitActorAvatarUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.date());
        values.add(selector.email());
        values.add(selector.name());
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    private static List<Object> readWithoutArguments(final GitActorSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new GitActorSelectorImpl(new RecordingCursor(root)));
        final GitActorSelectorImpl selector =
                new GitActorSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", OffsetDateTime.parse("2024-05-01T10:15:30Z"), "x", "x", true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new GitActorSelectorImpl(new RecordingCursor(root)));
        final GitActorSelectorImpl selector =
                new GitActorSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
