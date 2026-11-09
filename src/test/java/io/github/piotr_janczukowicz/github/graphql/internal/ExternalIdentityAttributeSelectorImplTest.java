package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ExternalIdentityAttributeSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"metadata\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"value\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ExternalIdentityAttributeSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.metadata());
        values.add(selector.name());
        values.add(selector.value());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ExternalIdentityAttributeSelectorImpl(new RecordingCursor(root)));
        final ExternalIdentityAttributeSelectorImpl selector =
                new ExternalIdentityAttributeSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x");
    }
}
