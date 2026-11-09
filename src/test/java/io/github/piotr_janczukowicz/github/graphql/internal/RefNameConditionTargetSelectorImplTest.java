package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RefNameConditionTargetSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"exclude\":[\"x\"]" + "," + "\"include\":[\"x\"]" + "}";

    private static List<Object> readWithArguments(final RefNameConditionTargetSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.exclude());
        values.add(selector.include());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RefNameConditionTargetSelectorImpl(new RecordingCursor(root)));
        final RefNameConditionTargetSelectorImpl selector =
                new RefNameConditionTargetSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(List.of("x"), List.of("x"));
    }
}
