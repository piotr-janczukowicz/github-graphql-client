package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MergeQueueSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"configuration\":{\"checkResponseTimeout\": 1}" + ","
            + "\"entries\":{\"nodes\": [{\"enqueuedAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + "," + "\"nextEntryEstimatedTimeToMerge\":1" + ","
            + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + "," + "\"url\":\"x\""
            + "}";

    private static List<Object> readWithArguments(final MergeQueueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.configuration(MergeQueueConfigurationSelector::checkResponseTimeout));
        values.add(selector.entries(Paging.first(1), MergeQueueEntrySelector::enqueuedAt));
        values.add(selector.id());
        values.add(selector.nextEntryEstimatedTimeToMerge());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.url());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new MergeQueueSelectorImpl(new RecordingCursor(root)));
        final MergeQueueSelectorImpl selector =
                new MergeQueueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        1,
                        new Page<>(List.of(Instant.parse("2024-05-01T10:15:30Z")), false, null),
                        "x",
                        1,
                        true,
                        "x",
                        "x");
    }
}
