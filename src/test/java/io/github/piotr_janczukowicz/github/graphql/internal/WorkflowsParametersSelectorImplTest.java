package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.WorkflowFileReferenceSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class WorkflowsParametersSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"doNotEnforceOnCreate\":true" + "," + "\"workflows\":[{\"path\": \"x\"}]" + "}";

    private static List<Object> readWithArguments(final WorkflowsParametersSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.doNotEnforceOnCreate());
        values.add(selector.workflows(WorkflowFileReferenceSelector::path));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new WorkflowsParametersSelectorImpl(new RecordingCursor(root)));
        final WorkflowsParametersSelectorImpl selector =
                new WorkflowsParametersSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, List.of("x"));
    }
}
