package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.LocalDate;

/** Selection of the GraphQL type {@code ContributionCalendarDay}. */
public interface ContributionCalendarDaySelector {

    String color();

    int contributionCount();

    ContributionLevel contributionLevel();

    LocalDate date();

    int weekday();
}
