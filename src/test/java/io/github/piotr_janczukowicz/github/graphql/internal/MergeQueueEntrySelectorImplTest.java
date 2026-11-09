package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueEntryState;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MergeQueueEntrySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"baseCommit\":{\"abbreviatedOid\": \"x\"}" + ","
            + "\"enqueuedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"enqueuer\":{\"avatarUrl\": \"x\"}" + ","
            + "\"estimatedTimeToMerge\":1" + "," + "\"headCommit\":{\"abbreviatedOid\": \"x\"}" + "," + "\"id\":\"x\""
            + "," + "\"jump\":true" + "," + "\"mergeQueue\":{\"id\": \"x\"}" + "," + "\"position\":1" + ","
            + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"solo\":true" + ","
            + "\"state\":\"AWAITING_CHECKS\"" + "}";

    private static List<Object> readWithArguments(final MergeQueueEntrySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.baseCommit(CommitSelector::abbreviatedOid));
        values.add(selector.enqueuedAt());
        values.add(selector.enqueuer(ActorSelector::avatarUrl));
        values.add(selector.estimatedTimeToMerge());
        values.add(selector.headCommit(CommitSelector::abbreviatedOid));
        values.add(selector.id());
        values.add(selector.jump());
        values.add(selector.mergeQueue(MergeQueueSelector::id));
        values.add(selector.position());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.solo());
        values.add(selector.state());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new MergeQueueEntrySelectorImpl(new RecordingCursor(root)));
        final MergeQueueEntrySelectorImpl selector =
                new MergeQueueEntrySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        1,
                        "x",
                        "x",
                        true,
                        "x",
                        1,
                        LockReason.OFF_TOPIC,
                        true,
                        MergeQueueEntryState.AWAITING_CHECKS);
    }
}
