package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CreateIssueFieldPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientMutationId\":\"x\"" + ","
            + "\"issueField\":{\"__typename\": \"IssueFieldDate\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + "}";

    private static List<Object> readWithArguments(final CreateIssueFieldPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.issueField(
                child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CreateIssueFieldPayloadSelectorImpl(new RecordingCursor(root)));
        final CreateIssueFieldPayloadSelectorImpl selector =
                new CreateIssueFieldPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", Instant.parse("2024-05-01T10:15:30Z"));
    }
}
