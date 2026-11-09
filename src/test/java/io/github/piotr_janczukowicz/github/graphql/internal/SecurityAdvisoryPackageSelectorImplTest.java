package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryEcosystem;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SecurityAdvisoryPackageSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"ecosystem\":\"ACTIONS\"" + "," + "\"name\":\"x\"" + "}";

    private static List<Object> readWithArguments(final SecurityAdvisoryPackageSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.ecosystem());
        values.add(selector.name());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SecurityAdvisoryPackageSelectorImpl(new RecordingCursor(root)));
        final SecurityAdvisoryPackageSelectorImpl selector =
                new SecurityAdvisoryPackageSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(SecurityAdvisoryEcosystem.ACTIONS, "x");
    }
}
