package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DeleteIssueTypePayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"clientMutationId\":\"x\"" + "," + "\"deletedIssueTypeId\":\"x\"" + "}";

    private static List<Object> readWithArguments(final DeleteIssueTypePayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.deletedIssueTypeId());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DeleteIssueTypePayloadSelectorImpl(new RecordingCursor(root)));
        final DeleteIssueTypePayloadSelectorImpl selector =
                new DeleteIssueTypePayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x");
    }
}
