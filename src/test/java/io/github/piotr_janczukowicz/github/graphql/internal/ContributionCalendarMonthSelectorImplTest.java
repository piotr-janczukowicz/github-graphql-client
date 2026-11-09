package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ContributionCalendarMonthSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"firstDay\":\"2024-05-01\"" + "," + "\"name\":\"x\"" + ","
            + "\"totalWeeks\":1" + "," + "\"year\":1" + "}";

    private static List<Object> readWithArguments(final ContributionCalendarMonthSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.firstDay());
        values.add(selector.name());
        values.add(selector.totalWeeks());
        values.add(selector.year());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ContributionCalendarMonthSelectorImpl(new RecordingCursor(root)));
        final ContributionCalendarMonthSelectorImpl selector =
                new ContributionCalendarMonthSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(LocalDate.of(2024, 5, 1), "x", 1, 1);
    }
}
