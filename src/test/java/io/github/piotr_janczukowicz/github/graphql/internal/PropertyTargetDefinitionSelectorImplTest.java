package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PropertyTargetDefinitionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"name\":\"x\"" + "," + "\"propertyValues\":[\"x\"]" + "," + "\"source\":\"x\"" + "}";

    private static List<Object> readWithArguments(final PropertyTargetDefinitionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.name());
        values.add(selector.propertyValues());
        values.add(selector.source());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PropertyTargetDefinitionSelectorImpl(new RecordingCursor(root)));
        final PropertyTargetDefinitionSelectorImpl selector =
                new PropertyTargetDefinitionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", List.of("x"), "x");
    }
}
