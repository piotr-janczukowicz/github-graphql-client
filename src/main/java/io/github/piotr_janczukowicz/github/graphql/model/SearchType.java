package io.github.piotr_janczukowicz.github.graphql.model;

/** The GraphQL enum {@code SearchType}; it is only sent to GitHub, never read. */
public enum SearchType {
    DISCUSSION,
    ISSUE,
    ISSUE_ADVANCED,
    ISSUE_HYBRID,
    ISSUE_SEMANTIC,
    REPOSITORY,
    USER
}
