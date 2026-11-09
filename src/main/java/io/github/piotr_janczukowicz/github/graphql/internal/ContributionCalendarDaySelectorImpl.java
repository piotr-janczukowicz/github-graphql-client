package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarDaySelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionLevel;
import java.time.LocalDate;

/** Reads and records the fields of {@code ContributionCalendarDay}; used by the generated selection code only. */
final class ContributionCalendarDaySelectorImpl implements ContributionCalendarDaySelector {

    private final Cursor cursor;

    ContributionCalendarDaySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String color() {
        return cursor.getRequired("color", ScalarType.STRING);
    }

    @Override
    public int contributionCount() {
        return cursor.getRequired("contributionCount", ScalarType.INT);
    }

    @Override
    public ContributionLevel contributionLevel() {
        return cursor.getRequired(
                "contributionLevel",
                ScalarType.enumeration(ContributionLevel::fromWire, ContributionLevel.FIRST_QUARTILE));
    }

    @Override
    public LocalDate date() {
        return cursor.getRequired("date", ScalarType.LOCAL_DATE);
    }

    @Override
    public int weekday() {
        return cursor.getRequired("weekday", ScalarType.INT);
    }
}
