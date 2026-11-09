package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class BranchNamePatternParametersSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"name\":\"x\"" + "," + "\"negate\":true" + "," + "\"operator\":\"x\""
            + "," + "\"pattern\":\"x\"" + "}";

    private static List<Object> readWithArguments(final BranchNamePatternParametersSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.name());
        values.add(selector.negate());
        values.add(selector.operator());
        values.add(selector.pattern());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new BranchNamePatternParametersSelectorImpl(new RecordingCursor(root)));
        final BranchNamePatternParametersSelectorImpl selector =
                new BranchNamePatternParametersSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", true, "x", "x");
    }
}
