package io.github.piotr_janczukowicz.github.graphql.model;

/** The GraphQL enum {@code PinnableItemType}; it is only sent to GitHub, never read. */
public enum PinnableItemType {
    GIST,
    ISSUE,
    ORGANIZATION,
    PROJECT,
    PULL_REQUEST,
    REPOSITORY,
    TEAM,
    USER
}
