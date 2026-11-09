package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorsGoalKind;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SponsorsGoalSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"description\":\"x\"" + "," + "\"kind\":\"MONTHLY_SPONSORSHIP_AMOUNT\"" + ","
                    + "\"percentComplete\":1" + "," + "\"targetValue\":1" + "," + "\"title\":\"x\"" + "}";

    private static List<Object> readWithArguments(final SponsorsGoalSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.description());
        values.add(selector.kind());
        values.add(selector.percentComplete());
        values.add(selector.targetValue());
        values.add(selector.title());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SponsorsGoalSelectorImpl(new RecordingCursor(root)));
        final SponsorsGoalSelectorImpl selector =
                new SponsorsGoalSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", SponsorsGoalKind.MONTHLY_SPONSORSHIP_AMOUNT, 1, 1, "x");
    }
}
