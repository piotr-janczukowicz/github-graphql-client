package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.HovercardContextSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class HovercardSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"contexts\":[{\"message\": \"x\"}]" + "}";

    private static List<Object> readWithArguments(final HovercardSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.contexts(HovercardContextSelector::message));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new HovercardSelectorImpl(new RecordingCursor(root)));
        final HovercardSelectorImpl selector =
                new HovercardSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(List.of("x"));
    }
}
