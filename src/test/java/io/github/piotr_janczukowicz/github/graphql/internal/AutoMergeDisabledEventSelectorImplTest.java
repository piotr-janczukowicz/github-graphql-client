package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class AutoMergeDisabledEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"disabler\":{\"anyPinnableItems\": true}" + ","
            + "\"id\":\"x\"" + "," + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"reason\":\"x\""
            + "," + "\"reasonCode\":\"x\"" + "}";

    private static List<Object> readWithArguments(final AutoMergeDisabledEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.createdAt());
        values.add(selector.disabler(UserSelector::anyPinnableItems));
        values.add(selector.id());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.reason());
        values.add(selector.reasonCode());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new AutoMergeDisabledEventSelectorImpl(new RecordingCursor(root)));
        final AutoMergeDisabledEventSelectorImpl selector =
                new AutoMergeDisabledEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly("x", Instant.parse("2024-05-01T10:15:30Z"), true, "x", LockReason.OFF_TOPIC, "x", "x");
    }
}
