package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RemoveBlockedByPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"blockingIssue\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"clientMutationId\":\"x\"" + "," + "\"issue\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "}";

    private static List<Object> readWithArguments(final RemoveBlockedByPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.blockingIssue(IssueSelector::activeLockReason));
        values.add(selector.clientMutationId());
        values.add(selector.issue(IssueSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RemoveBlockedByPayloadSelectorImpl(new RecordingCursor(root)));
        final RemoveBlockedByPayloadSelectorImpl selector =
                new RemoveBlockedByPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(LockReason.OFF_TOPIC, "x", LockReason.OFF_TOPIC);
    }
}
