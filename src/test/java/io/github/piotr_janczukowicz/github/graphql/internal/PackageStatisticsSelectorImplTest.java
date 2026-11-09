package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PackageStatisticsSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"downloadsTotalCount\":1" + "}";

    private static List<Object> readWithArguments(final PackageStatisticsSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.downloadsTotalCount());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PackageStatisticsSelectorImpl(new RecordingCursor(root)));
        final PackageStatisticsSelectorImpl selector =
                new PackageStatisticsSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1);
    }
}
