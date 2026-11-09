package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueMergingStrategy;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestMergeMethod;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MergeQueueConfigurationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"checkResponseTimeout\":1" + "," + "\"maximumEntriesToBuild\":1"
            + "," + "\"maximumEntriesToMerge\":1" + "," + "\"mergeMethod\":\"MERGE\"" + ","
            + "\"mergingStrategy\":\"ALLGREEN\"" + "," + "\"minimumEntriesToMerge\":1" + ","
            + "\"minimumEntriesToMergeWaitTime\":1" + "}";

    private static List<Object> readWithArguments(final MergeQueueConfigurationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.checkResponseTimeout());
        values.add(selector.maximumEntriesToBuild());
        values.add(selector.maximumEntriesToMerge());
        values.add(selector.mergeMethod());
        values.add(selector.mergingStrategy());
        values.add(selector.minimumEntriesToMerge());
        values.add(selector.minimumEntriesToMergeWaitTime());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new MergeQueueConfigurationSelectorImpl(new RecordingCursor(root)));
        final MergeQueueConfigurationSelectorImpl selector =
                new MergeQueueConfigurationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(1, 1, 1, PullRequestMergeMethod.MERGE, MergeQueueMergingStrategy.ALLGREEN, 1, 1);
    }
}
