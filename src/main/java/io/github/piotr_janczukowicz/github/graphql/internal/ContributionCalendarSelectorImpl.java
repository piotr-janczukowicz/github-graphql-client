package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarMonthSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarWeekSelector;
import java.util.List;
import java.util.function.Function;

/** Reads and records the fields of {@code ContributionCalendar}; used by the generated selection code only. */
final class ContributionCalendarSelectorImpl implements ContributionCalendarSelector {

    private final Cursor cursor;

    ContributionCalendarSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<String> colors() {
        return cursor.scalarListRequired("colors", ScalarType.STRING);
    }

    @Override
    public boolean isHalloween() {
        return cursor.getRequired("isHalloween", ScalarType.BOOLEAN);
    }

    @Override
    public <R> List<R> months(final Function<ContributionCalendarMonthSelector, R> selection) {
        return cursor.listRequired(
                "months", child -> selection.apply(new ContributionCalendarMonthSelectorImpl(child)));
    }

    @Override
    public int totalContributions() {
        return cursor.getRequired("totalContributions", ScalarType.INT);
    }

    @Override
    public <R> List<R> weeks(final Function<ContributionCalendarWeekSelector, R> selection) {
        return cursor.listRequired("weeks", child -> selection.apply(new ContributionCalendarWeekSelectorImpl(child)));
    }
}
