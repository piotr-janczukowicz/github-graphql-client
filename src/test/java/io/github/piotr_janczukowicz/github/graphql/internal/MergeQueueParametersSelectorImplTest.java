package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueGroupingStrategy;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueMergeMethod;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MergeQueueParametersSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"checkResponseTimeoutMinutes\":1" + "," + "\"groupingStrategy\":\"ALLGREEN\"" + ","
                    + "\"maxEntriesToBuild\":1" + "," + "\"maxEntriesToMerge\":1" + "," + "\"mergeMethod\":\"MERGE\""
                    + "," + "\"minEntriesToMerge\":1" + "," + "\"minEntriesToMergeWaitMinutes\":1" + "}";

    private static List<Object> readWithArguments(final MergeQueueParametersSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.checkResponseTimeoutMinutes());
        values.add(selector.groupingStrategy());
        values.add(selector.maxEntriesToBuild());
        values.add(selector.maxEntriesToMerge());
        values.add(selector.mergeMethod());
        values.add(selector.minEntriesToMerge());
        values.add(selector.minEntriesToMergeWaitMinutes());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new MergeQueueParametersSelectorImpl(new RecordingCursor(root)));
        final MergeQueueParametersSelectorImpl selector =
                new MergeQueueParametersSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(1, MergeQueueGroupingStrategy.ALLGREEN, 1, 1, MergeQueueMergeMethod.MERGE, 1, 1);
    }
}
