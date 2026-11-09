package io.github.piotr_janczukowicz.github.graphql.model;

/** The GraphQL enum {@code RequestableCheckStatusState}; it is only sent to GitHub, never read. */
public enum RequestableCheckStatusState {
    COMPLETED,
    IN_PROGRESS,
    PENDING,
    QUEUED,
    WAITING
}
