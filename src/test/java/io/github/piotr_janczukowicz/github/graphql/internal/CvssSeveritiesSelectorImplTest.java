package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CVSSSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CvssSeveritiesSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"cvssV3\":{\"score\": 1.5}" + "," + "\"cvssV4\":{\"score\": 1.5}" + "}";

    private static List<Object> readWithArguments(final CvssSeveritiesSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.cvssV3(CVSSSelector::score));
        values.add(selector.cvssV4(CVSSSelector::score));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CvssSeveritiesSelectorImpl(new RecordingCursor(root)));
        final CvssSeveritiesSelectorImpl selector =
                new CvssSeveritiesSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1.5, 1.5);
    }
}
