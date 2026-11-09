package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MergedEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"commit\":{\"abbreviatedOid\": \"x\"}" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"id\":\"x\"" + "," + "\"mergeRef\":{\"id\": \"x\"}" + "," + "\"mergeRefName\":\"x\"" + ","
            + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final MergedEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.commit(CommitSelector::abbreviatedOid));
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.mergeRef(RefSelector::id));
        values.add(selector.mergeRefName());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.resourcePath());
        values.add(selector.url());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new MergedEventSelectorImpl(new RecordingCursor(root)));
        final MergedEventSelectorImpl selector =
                new MergedEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x", "x", Instant.parse("2024-05-01T10:15:30Z"), "x", "x", "x", LockReason.OFF_TOPIC, "x", "x");
    }
}
