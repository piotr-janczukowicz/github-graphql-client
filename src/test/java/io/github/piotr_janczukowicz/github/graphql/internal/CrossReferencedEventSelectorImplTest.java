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
class CrossReferencedEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + "," + "\"isCrossRepository\":true" + ","
            + "\"referencedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"source\":{\"__typename\": \"Issue\", \"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"target\":{\"__typename\": \"Issue\", \"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"url\":\"x\""
            + "," + "\"willCloseTarget\":true" + "}";

    private static List<Object> readWithArguments(final CrossReferencedEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.isCrossRepository());
        values.add(selector.referencedAt());
        values.add(selector.resourcePath());
        values.add(selector.source(child -> child.on(IssueSelector.class, IssueSelector::activeLockReason)));
        values.add(selector.target(child -> child.on(IssueSelector.class, IssueSelector::activeLockReason)));
        values.add(selector.url());
        values.add(selector.willCloseTarget());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CrossReferencedEventSelectorImpl(new RecordingCursor(root)));
        final CrossReferencedEventSelectorImpl selector =
                new CrossReferencedEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        true,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        LockReason.OFF_TOPIC,
                        LockReason.OFF_TOPIC,
                        "x",
                        true);
    }
}
