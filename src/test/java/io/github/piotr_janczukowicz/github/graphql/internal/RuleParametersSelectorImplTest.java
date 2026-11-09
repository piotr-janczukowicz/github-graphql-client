package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.BranchNamePatternParametersSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RuleParametersSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"name\":\"x\"" + "," + "\"__typename\":\"BranchNamePatternParameters\"" + "}";

    private static List<Object> readWithArguments(final RuleParametersSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.on(BranchNamePatternParametersSelector.class, BranchNamePatternParametersSelector::name));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RuleParametersSelectorImpl(new RecordingCursor(root)));
        final RuleParametersSelectorImpl selector =
                new RuleParametersSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
