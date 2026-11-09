package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ClosableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueEventConfidenceLevel;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueStateReason;
import io.github.piotr_janczukowicz.github.graphql.model.IssueUpdateIntentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ClosedEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + "," + "\"closable\":{\"closed\": true}" + ","
                    + "\"closer\":{\"__typename\": \"Commit\", \"abbreviatedOid\": \"x\"}" + ","
                    + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
                    + "\"duplicateOf\":{\"__typename\": \"Issue\", \"activeLockReason\": \"OFF_TOPIC\"}" + ","
                    + "\"id\":\"x\"" + "," + "\"intent\":{\"confidence\": \"HIGH\"}" + "," + "\"resourcePath\":\"x\""
                    + "," + "\"stateReason\":\"COMPLETED\"" + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ClosedEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.closable(ClosableSelector::closed));
        values.add(selector.closer(child -> child.on(CommitSelector.class, CommitSelector::abbreviatedOid)));
        values.add(selector.createdAt());
        values.add(selector.duplicateOf(child -> child.on(IssueSelector.class, IssueSelector::activeLockReason)));
        values.add(selector.id());
        values.add(selector.intent(IssueUpdateIntentSelector::confidence));
        values.add(selector.resourcePath());
        values.add(selector.stateReason());
        values.add(selector.url());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ClosedEventSelectorImpl(new RecordingCursor(root)));
        final ClosedEventSelectorImpl selector =
                new ClosedEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        true,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        LockReason.OFF_TOPIC,
                        "x",
                        IssueEventConfidenceLevel.HIGH,
                        "x",
                        IssueStateReason.COMPLETED,
                        "x");
    }
}
