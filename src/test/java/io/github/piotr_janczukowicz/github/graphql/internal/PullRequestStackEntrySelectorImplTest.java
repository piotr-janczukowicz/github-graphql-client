package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PullRequestStackEntrySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"id\":\"x\"" + "," + "\"position\":1" + ","
            + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"stack\":{\"baseRefName\": \"x\"}"
            + "}";

    private static List<Object> readWithArguments(final PullRequestStackEntrySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.position());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.stack(PullRequestStackSelector::baseRefName));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PullRequestStackEntrySelectorImpl(new RecordingCursor(root)));
        final PullRequestStackEntrySelectorImpl selector =
                new PullRequestStackEntrySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", 1, LockReason.OFF_TOPIC, "x");
    }
}
