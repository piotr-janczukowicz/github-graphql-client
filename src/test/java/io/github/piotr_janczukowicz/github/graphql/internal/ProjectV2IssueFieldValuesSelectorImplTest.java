package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateValueSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2IssueFieldValuesSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"id\":\"x\"" + "," + "\"__typename\":\"IssueFieldDateValue\"" + "}";

    private static List<Object> readWithArguments(final ProjectV2IssueFieldValuesSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.on(IssueFieldDateValueSelector.class, IssueFieldDateValueSelector::id));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2IssueFieldValuesSelectorImpl(new RecordingCursor(root)));
        final ProjectV2IssueFieldValuesSelectorImpl selector =
                new ProjectV2IssueFieldValuesSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
