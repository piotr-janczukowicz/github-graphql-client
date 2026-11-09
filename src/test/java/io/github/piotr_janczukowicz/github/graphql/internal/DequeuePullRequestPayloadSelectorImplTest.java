package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueEntrySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DequeuePullRequestPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientMutationId\":\"x\"" + ","
            + "\"mergeQueueEntry\":{\"enqueuedAt\": \"2024-05-01T10:15:30Z\"}" + "}";

    private static List<Object> readWithArguments(final DequeuePullRequestPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.mergeQueueEntry(MergeQueueEntrySelector::enqueuedAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DequeuePullRequestPayloadSelectorImpl(new RecordingCursor(root)));
        final DequeuePullRequestPayloadSelectorImpl selector =
                new DequeuePullRequestPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", Instant.parse("2024-05-01T10:15:30Z"));
    }
}
