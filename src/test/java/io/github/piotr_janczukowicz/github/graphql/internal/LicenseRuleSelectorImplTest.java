package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class LicenseRuleSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"description\":\"x\"" + "," + "\"key\":\"x\"" + "," + "\"label\":\"x\"" + "}";

    private static List<Object> readWithArguments(final LicenseRuleSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.description());
        values.add(selector.key());
        values.add(selector.label());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new LicenseRuleSelectorImpl(new RecordingCursor(root)));
        final LicenseRuleSelectorImpl selector =
                new LicenseRuleSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x");
    }
}
