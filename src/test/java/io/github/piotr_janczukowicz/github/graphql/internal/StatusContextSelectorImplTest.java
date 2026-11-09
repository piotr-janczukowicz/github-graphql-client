package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusContextAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.StatusContextIsRequiredFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.StatusState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class StatusContextSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"avatarUrl\":\"x\"" + "," + "\"commit\":{\"abbreviatedOid\": \"x\"}"
            + "," + "\"context\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"creator\":{\"avatarUrl\": \"x\"}" + "," + "\"description\":\"x\"" + "," + "\"id\":\"x\"" + ","
            + "\"isRequired\":true" + "," + "\"state\":\"ERROR\"" + "," + "\"targetUrl\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final StatusContextSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl(
                StatusContextAvatarUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.commit(CommitSelector::abbreviatedOid));
        values.add(selector.context());
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.description());
        values.add(selector.id());
        values.add(selector.isRequired(StatusContextIsRequiredFilterBuilder.builder()
                .pullRequestId("x")
                .pullRequestNumber(1)
                .build()));
        values.add(selector.state());
        values.add(selector.targetUrl());
        values.add(selector.updatedAt());
        return values;
    }

    private static List<Object> readWithoutArguments(final StatusContextSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl());
        values.add(selector.isRequired());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new StatusContextSelectorImpl(new RecordingCursor(root)));
        final StatusContextSelectorImpl selector =
                new StatusContextSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        "x",
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        "x",
                        true,
                        StatusState.ERROR,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new StatusContextSelectorImpl(new RecordingCursor(root)));
        final StatusContextSelectorImpl selector =
                new StatusContextSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly("x", true);
    }
}
