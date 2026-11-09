package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code ContributionCalendar}. */
public interface ContributionCalendarSelector {

    List<String> colors();

    boolean isHalloween();

    <R> List<R> months(Function<ContributionCalendarMonthSelector, R> selection);

    int totalContributions();

    <R> List<R> weeks(Function<ContributionCalendarWeekSelector, R> selection);
}
