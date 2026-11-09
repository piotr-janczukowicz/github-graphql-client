package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PullRequestCommitSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"commit\":{\"abbreviatedOid\": \"x\"}" + "," + "\"id\":\"x\"" + ","
            + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final PullRequestCommitSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.commit(CommitSelector::abbreviatedOid));
        values.add(selector.id());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.resourcePath());
        values.add(selector.url());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PullRequestCommitSelectorImpl(new RecordingCursor(root)));
        final PullRequestCommitSelectorImpl selector =
                new PullRequestCommitSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", LockReason.OFF_TOPIC, "x", "x");
    }
}
