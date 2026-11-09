package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ActorLocationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"city\":\"x\"" + "," + "\"country\":\"x\"" + ","
            + "\"countryCode\":\"x\"" + "," + "\"region\":\"x\"" + "," + "\"regionCode\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ActorLocationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.city());
        values.add(selector.country());
        values.add(selector.countryCode());
        values.add(selector.region());
        values.add(selector.regionCode());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ActorLocationSelectorImpl(new RecordingCursor(root)));
        final ActorLocationSelectorImpl selector =
                new ActorLocationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", "x", "x");
    }
}
