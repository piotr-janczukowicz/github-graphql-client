package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SubIssuesSummarySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"completed\":1" + "," + "\"percentCompleted\":1" + "," + "\"total\":1" + "}";

    private static List<Object> readWithArguments(final SubIssuesSummarySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.completed());
        values.add(selector.percentCompleted());
        values.add(selector.total());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SubIssuesSummarySelectorImpl(new RecordingCursor(root)));
        final SubIssuesSummarySelectorImpl selector =
                new SubIssuesSummarySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1, 1, 1);
    }
}
