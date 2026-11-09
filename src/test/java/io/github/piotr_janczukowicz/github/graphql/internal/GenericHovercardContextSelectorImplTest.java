package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class GenericHovercardContextSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"message\":\"x\"" + "," + "\"octicon\":\"x\"" + "}";

    private static List<Object> readWithArguments(final GenericHovercardContextSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.message());
        values.add(selector.octicon());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new GenericHovercardContextSelectorImpl(new RecordingCursor(root)));
        final GenericHovercardContextSelectorImpl selector =
                new GenericHovercardContextSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x");
    }
}
