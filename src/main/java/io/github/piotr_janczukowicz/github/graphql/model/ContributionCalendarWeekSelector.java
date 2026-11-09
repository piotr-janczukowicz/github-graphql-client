package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code ContributionCalendarWeek}. */
public interface ContributionCalendarWeekSelector {

    <R> List<R> contributionDays(Function<ContributionCalendarDaySelector, R> selection);

    LocalDate firstDay();
}
