package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueStateReason;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PendingCloseSuggestionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
                    + "\"duplicateOf\":{\"__typename\": \"Issue\", \"activeLockReason\": \"OFF_TOPIC\"}" + ","
                    + "\"id\":\"x\"" + "," + "\"rationale\":\"x\"" + "," + "\"stateReason\":\"COMPLETED\"" + ","
                    + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final PendingCloseSuggestionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.createdAt());
        values.add(selector.duplicateOf(child -> child.on(IssueSelector.class, IssueSelector::activeLockReason)));
        values.add(selector.id());
        values.add(selector.rationale());
        values.add(selector.stateReason());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PendingCloseSuggestionSelectorImpl(new RecordingCursor(root)));
        final PendingCloseSuggestionSelectorImpl selector =
                new PendingCloseSuggestionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        LockReason.OFF_TOPIC,
                        "x",
                        "x",
                        IssueStateReason.COMPLETED,
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
