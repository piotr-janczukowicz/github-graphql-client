package io.github.piotr_janczukowicz.github.graphql.model;

/** The GraphQL enum {@code PullRequestReviewEvent}; it is only sent to GitHub, never read. */
public enum PullRequestReviewEvent {
    APPROVE,
    COMMENT,
    DISMISS,
    REQUEST_CHANGES
}
