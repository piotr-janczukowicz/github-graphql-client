package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CodeOfConductSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"body\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"key\":\"x\"" + ","
            + "\"name\":\"x\"" + "," + "\"resourcePath\":\"x\"" + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final CodeOfConductSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.body());
        values.add(selector.id());
        values.add(selector.key());
        values.add(selector.name());
        values.add(selector.resourcePath());
        values.add(selector.url());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CodeOfConductSelectorImpl(new RecordingCursor(root)));
        final CodeOfConductSelectorImpl selector =
                new CodeOfConductSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", "x", "x", "x");
    }
}
