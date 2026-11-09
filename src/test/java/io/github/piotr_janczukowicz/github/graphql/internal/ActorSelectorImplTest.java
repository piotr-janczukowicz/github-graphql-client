package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ActorSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"avatarUrl\":\"x\"" + "," + "\"login\":\"x\"" + ","
            + "\"resourcePath\":\"x\"" + "," + "\"url\":\"x\"" + "," + "\"__typename\":\"Bot\"" + "}";

    private static List<Object> readWithArguments(final ActorSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(
                selector.avatarUrl(ActorAvatarUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.login());
        values.add(selector.resourcePath());
        values.add(selector.url());
        values.add(selector.on(BotSelector.class, BotSelector::avatarUrl));
        return values;
    }

    private static List<Object> readWithoutArguments(final ActorSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ActorSelectorImpl(new RecordingCursor(root)));
        final ActorSelectorImpl selector = new ActorSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", "x", "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ActorSelectorImpl(new RecordingCursor(root)));
        final ActorSelectorImpl selector = new ActorSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
