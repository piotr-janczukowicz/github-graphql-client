package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;

/** Selection of the GraphQL type {@code CreatedRepositoryContribution}. */
public interface CreatedRepositoryContributionSelector {

    boolean isRestricted();

    Instant occurredAt();

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    String url();

    <R> R user(Function<UserSelector, R> selection);
}
