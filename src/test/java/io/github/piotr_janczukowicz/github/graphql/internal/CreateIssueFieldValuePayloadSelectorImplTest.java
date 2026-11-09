package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CreateIssueFieldValuePayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"clientMutationId\":\"x\"" + "," + "\"issue\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
                    + "\"issueFieldValue\":{\"__typename\": \"IssueFieldDateValue\", \"id\": \"x\"}" + "}";

    private static List<Object> readWithArguments(final CreateIssueFieldValuePayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.issue(IssueSelector::activeLockReason));
        values.add(selector.issueFieldValue(
                child -> child.on(IssueFieldDateValueSelector.class, IssueFieldDateValueSelector::id)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CreateIssueFieldValuePayloadSelectorImpl(new RecordingCursor(root)));
        final CreateIssueFieldValuePayloadSelectorImpl selector =
                new CreateIssueFieldValuePayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", LockReason.OFF_TOPIC, "x");
    }
}
