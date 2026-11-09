package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.DependabotUpdateErrorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DependabotUpdateSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"error\":{\"body\": \"x\"}" + "," + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
                    + "\"repository\":{\"allowUpdateBranch\": true}" + "}";

    private static List<Object> readWithArguments(final DependabotUpdateSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.error(DependabotUpdateErrorSelector::body));
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DependabotUpdateSelectorImpl(new RecordingCursor(root)));
        final DependabotUpdateSelectorImpl selector =
                new DependabotUpdateSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", LockReason.OFF_TOPIC, true);
    }
}
