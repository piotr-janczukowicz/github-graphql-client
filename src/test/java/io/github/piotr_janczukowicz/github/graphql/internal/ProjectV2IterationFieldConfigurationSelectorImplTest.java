package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2IterationFieldIterationSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2IterationFieldConfigurationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"completedIterations\":[{\"duration\": 1}]" + "," + "\"duration\":1"
            + "," + "\"iterations\":[{\"duration\": 1}]" + "," + "\"startDay\":1" + "}";

    private static List<Object> readWithArguments(final ProjectV2IterationFieldConfigurationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.completedIterations(ProjectV2IterationFieldIterationSelector::duration));
        values.add(selector.duration());
        values.add(selector.iterations(ProjectV2IterationFieldIterationSelector::duration));
        values.add(selector.startDay());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2IterationFieldConfigurationSelectorImpl(new RecordingCursor(root)));
        final ProjectV2IterationFieldConfigurationSelectorImpl selector =
                new ProjectV2IterationFieldConfigurationSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(List.of(1), 1, List.of(1), 1);
    }
}
