package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UnmarkedAsDuplicateEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"canonical\":{\"__typename\": \"Issue\", \"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"duplicate\":{\"__typename\": \"Issue\", \"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"id\":\"x\""
            + "," + "\"isCrossRepository\":true" + "}";

    private static List<Object> readWithArguments(final UnmarkedAsDuplicateEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.canonical(child -> child.on(IssueSelector.class, IssueSelector::activeLockReason)));
        values.add(selector.createdAt());
        values.add(selector.duplicate(child -> child.on(IssueSelector.class, IssueSelector::activeLockReason)));
        values.add(selector.id());
        values.add(selector.isCrossRepository());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UnmarkedAsDuplicateEventSelectorImpl(new RecordingCursor(root)));
        final UnmarkedAsDuplicateEventSelectorImpl selector =
                new UnmarkedAsDuplicateEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        LockReason.OFF_TOPIC,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        LockReason.OFF_TOPIC,
                        "x",
                        true);
    }
}
