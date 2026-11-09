package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.LocalDate;

/** Selection of the GraphQL type {@code ContributionCalendarMonth}. */
public interface ContributionCalendarMonthSelector {

    LocalDate firstDay();

    String name();

    int totalWeeks();

    int year();
}
