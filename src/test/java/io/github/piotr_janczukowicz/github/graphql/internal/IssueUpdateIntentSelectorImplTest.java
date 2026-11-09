package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueEventConfidenceLevel;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class IssueUpdateIntentSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"confidence\":\"HIGH\"" + "," + "\"databaseId\":1" + ","
            + "\"intentId\":\"x\"" + "," + "\"rationale\":\"x\"" + "}";

    private static List<Object> readWithArguments(final IssueUpdateIntentSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.confidence());
        values.add(selector.databaseId());
        values.add(selector.intentId());
        values.add(selector.rationale());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueUpdateIntentSelectorImpl(new RecordingCursor(root)));
        final IssueUpdateIntentSelectorImpl selector =
                new IssueUpdateIntentSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(IssueEventConfidenceLevel.HIGH, 1, "x", "x");
    }
}
