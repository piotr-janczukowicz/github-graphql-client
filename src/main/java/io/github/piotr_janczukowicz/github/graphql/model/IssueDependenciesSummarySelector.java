package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code IssueDependenciesSummary}. */
public interface IssueDependenciesSummarySelector {

    int blockedBy();

    int blocking();

    int totalBlockedBy();

    int totalBlocking();
}
