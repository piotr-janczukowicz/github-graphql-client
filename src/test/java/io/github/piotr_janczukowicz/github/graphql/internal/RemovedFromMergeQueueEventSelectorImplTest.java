package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RemovedFromMergeQueueEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + "," + "\"beforeCommit\":{\"abbreviatedOid\": \"x\"}" + ","
                    + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"enqueuer\":{\"anyPinnableItems\": true}" + ","
                    + "\"id\":\"x\"" + "," + "\"mergeQueue\":{\"id\": \"x\"}" + ","
                    + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"reason\":\"x\"" + "}";

    private static List<Object> readWithArguments(final RemovedFromMergeQueueEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.beforeCommit(CommitSelector::abbreviatedOid));
        values.add(selector.createdAt());
        values.add(selector.enqueuer(UserSelector::anyPinnableItems));
        values.add(selector.id());
        values.add(selector.mergeQueue(MergeQueueSelector::id));
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.reason());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RemovedFromMergeQueueEventSelectorImpl(new RecordingCursor(root)));
        final RemovedFromMergeQueueEventSelectorImpl selector =
                new RemovedFromMergeQueueEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x", "x", Instant.parse("2024-05-01T10:15:30Z"), true, "x", "x", LockReason.OFF_TOPIC, "x");
    }
}
