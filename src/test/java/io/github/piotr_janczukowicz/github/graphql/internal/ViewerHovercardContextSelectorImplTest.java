package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ViewerHovercardContextSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"message\":\"x\"" + "," + "\"octicon\":\"x\"" + ","
            + "\"viewer\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final ViewerHovercardContextSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.message());
        values.add(selector.octicon());
        values.add(selector.viewer(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ViewerHovercardContextSelectorImpl(new RecordingCursor(root)));
        final ViewerHovercardContextSelectorImpl selector =
                new ViewerHovercardContextSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", true);
    }
}
