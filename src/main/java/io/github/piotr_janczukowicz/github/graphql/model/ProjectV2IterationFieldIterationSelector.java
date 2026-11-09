package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.LocalDate;

/** Selection of the GraphQL type {@code ProjectV2IterationFieldIteration}. */
public interface ProjectV2IterationFieldIterationSelector {

    int duration();

    String id();

    LocalDate startDate();

    String title();

    String titleHTML();
}
