package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code SponsorAndLifetimeValue}. */
public interface SponsorAndLifetimeValueSelector {

    int amountInCents();

    String formattedAmount();

    <R> R sponsor(Function<SponsorableSelector, R> selection);

    <R> R sponsorable(Function<SponsorableSelector, R> selection);
}
