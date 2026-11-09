package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SponsorsGoal}. */
public interface SponsorsGoalSelector {

    @Nullable String description();

    SponsorsGoalKind kind();

    int percentComplete();

    int targetValue();

    String title();
}
