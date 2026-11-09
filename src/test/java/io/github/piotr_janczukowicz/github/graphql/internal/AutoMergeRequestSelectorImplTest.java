package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestMergeMethod;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class AutoMergeRequestSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"authorEmail\":\"x\"" + "," + "\"commitBody\":\"x\"" + "," + "\"commitHeadline\":\"x\"" + ","
                    + "\"enabledAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"enabledBy\":{\"avatarUrl\": \"x\"}" + ","
                    + "\"mergeMethod\":\"MERGE\"" + "," + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "}";

    private static List<Object> readWithArguments(final AutoMergeRequestSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.authorEmail());
        values.add(selector.commitBody());
        values.add(selector.commitHeadline());
        values.add(selector.enabledAt());
        values.add(selector.enabledBy(ActorSelector::avatarUrl));
        values.add(selector.mergeMethod());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new AutoMergeRequestSelectorImpl(new RecordingCursor(root)));
        final AutoMergeRequestSelectorImpl selector =
                new AutoMergeRequestSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        "x",
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        PullRequestMergeMethod.MERGE,
                        LockReason.OFF_TOPIC);
    }
}
