package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DismissalRestrictionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"allowedActors\":[\"x\"]" + "," + "\"enabled\":true" + "}";

    private static List<Object> readWithArguments(final DismissalRestrictionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.allowedActors());
        values.add(selector.enabled());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DismissalRestrictionSelectorImpl(new RecordingCursor(root)));
        final DismissalRestrictionSelectorImpl selector =
                new DismissalRestrictionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(List.of("x"), true);
    }
}
