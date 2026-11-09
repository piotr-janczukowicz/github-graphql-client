package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class AutomaticBaseChangeFailedEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + "," + "\"newBase\":\"x\"" + ","
            + "\"oldBase\":\"x\"" + "," + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "}";

    private static List<Object> readWithArguments(final AutomaticBaseChangeFailedEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.newBase());
        values.add(selector.oldBase());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new AutomaticBaseChangeFailedEventSelectorImpl(new RecordingCursor(root)));
        final AutomaticBaseChangeFailedEventSelectorImpl selector =
                new AutomaticBaseChangeFailedEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly("x", Instant.parse("2024-05-01T10:15:30Z"), "x", "x", "x", LockReason.OFF_TOPIC);
    }
}
