package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarMonthSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarWeekSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ContributionCalendarSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"colors\":[\"x\"]" + "," + "\"isHalloween\":true" + ","
            + "\"months\":[{\"firstDay\": \"2024-05-01\"}]" + "," + "\"totalContributions\":1" + ","
            + "\"weeks\":[{\"firstDay\": \"2024-05-01\"}]" + "}";

    private static List<Object> readWithArguments(final ContributionCalendarSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.colors());
        values.add(selector.isHalloween());
        values.add(selector.months(ContributionCalendarMonthSelector::firstDay));
        values.add(selector.totalContributions());
        values.add(selector.weeks(ContributionCalendarWeekSelector::firstDay));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ContributionCalendarSelectorImpl(new RecordingCursor(root)));
        final ContributionCalendarSelectorImpl selector =
                new ContributionCalendarSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        List.of("x"), true, List.of(LocalDate.of(2024, 5, 1)), 1, List.of(LocalDate.of(2024, 5, 1)));
    }
}
