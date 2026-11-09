package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryCustomPropertyValueSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"propertyName\":\"x\"" + "," + "\"value\":\"x\"" + "}";

    private static List<Object> readWithArguments(final RepositoryCustomPropertyValueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.propertyName());
        values.add(selector.value());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryCustomPropertyValueSelectorImpl(new RecordingCursor(root)));
        final RepositoryCustomPropertyValueSelectorImpl selector =
                new RepositoryCustomPropertyValueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", CustomPropertyValue.ofText("x"));
    }
}
