package io.github.piotr_janczukowicz.github.graphql.model;

/** The GraphQL enum {@code RepositoryContributionType}; it is only sent to GitHub, never read. */
public enum RepositoryContributionType {
    COMMIT,
    ISSUE,
    PULL_REQUEST,
    PULL_REQUEST_REVIEW,
    REPOSITORY
}
