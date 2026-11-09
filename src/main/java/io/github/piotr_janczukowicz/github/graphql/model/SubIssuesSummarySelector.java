package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code SubIssuesSummary}. */
public interface SubIssuesSummarySelector {

    int completed();

    int percentCompleted();

    int total();
}
