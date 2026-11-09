package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PullRequestRevisionMarkerSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"lastSeenCommit\":{\"abbreviatedOid\": \"x\"}"
                    + "," + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "}";

    private static List<Object> readWithArguments(final PullRequestRevisionMarkerSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.lastSeenCommit(CommitSelector::abbreviatedOid));
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PullRequestRevisionMarkerSelectorImpl(new RecordingCursor(root)));
        final PullRequestRevisionMarkerSelectorImpl selector =
                new PullRequestRevisionMarkerSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(Instant.parse("2024-05-01T10:15:30Z"), "x", LockReason.OFF_TOPIC);
    }
}
