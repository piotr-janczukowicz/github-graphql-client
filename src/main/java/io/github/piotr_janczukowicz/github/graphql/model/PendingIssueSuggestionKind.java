package io.github.piotr_janczukowicz.github.graphql.model;

/** The GraphQL enum {@code PendingIssueSuggestionKind}; it is only sent to GitHub, never read. */
public enum PendingIssueSuggestionKind {
    ASSIGNEE,
    CLOSE,
    FIELD,
    LABEL,
    TYPE
}
