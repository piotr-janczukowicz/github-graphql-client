package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;

/** Selection of the GraphQL type {@code RestrictedContribution}. */
public interface RestrictedContributionSelector {

    boolean isRestricted();

    Instant occurredAt();

    String resourcePath();

    String url();

    <R> R user(Function<UserSelector, R> selection);
}
