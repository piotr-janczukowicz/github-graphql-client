package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarDaySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ContributionCalendarWeekSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"contributionDays\":[{\"color\": \"x\"}]" + "," + "\"firstDay\":\"2024-05-01\"" + "}";

    private static List<Object> readWithArguments(final ContributionCalendarWeekSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.contributionDays(ContributionCalendarDaySelector::color));
        values.add(selector.firstDay());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ContributionCalendarWeekSelectorImpl(new RecordingCursor(root)));
        final ContributionCalendarWeekSelectorImpl selector =
                new ContributionCalendarWeekSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(List.of("x"), LocalDate.of(2024, 5, 1));
    }
}
