package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarDaySelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarWeekSelector;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

/** Reads and records the fields of {@code ContributionCalendarWeek}; used by the generated selection code only. */
final class ContributionCalendarWeekSelectorImpl implements ContributionCalendarWeekSelector {

    private final Cursor cursor;

    ContributionCalendarWeekSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> List<R> contributionDays(final Function<ContributionCalendarDaySelector, R> selection) {
        return cursor.listRequired(
                "contributionDays", child -> selection.apply(new ContributionCalendarDaySelectorImpl(child)));
    }

    @Override
    public LocalDate firstDay() {
        return cursor.getRequired("firstDay", ScalarType.LOCAL_DATE);
    }
}
