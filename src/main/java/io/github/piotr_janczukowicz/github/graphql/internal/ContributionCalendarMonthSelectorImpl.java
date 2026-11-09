package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarMonthSelector;
import java.time.LocalDate;

/** Reads and records the fields of {@code ContributionCalendarMonth}; used by the generated selection code only. */
final class ContributionCalendarMonthSelectorImpl implements ContributionCalendarMonthSelector {

    private final Cursor cursor;

    ContributionCalendarMonthSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public LocalDate firstDay() {
        return cursor.getRequired("firstDay", ScalarType.LOCAL_DATE);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public int totalWeeks() {
        return cursor.getRequired("totalWeeks", ScalarType.INT);
    }

    @Override
    public int year() {
        return cursor.getRequired("year", ScalarType.INT);
    }
}
