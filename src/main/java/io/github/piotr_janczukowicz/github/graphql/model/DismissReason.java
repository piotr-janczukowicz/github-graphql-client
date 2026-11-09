package io.github.piotr_janczukowicz.github.graphql.model;

/** The GraphQL enum {@code DismissReason}; it is only sent to GitHub, never read. */
public enum DismissReason {
    FIX_STARTED,
    INACCURATE,
    NOT_USED,
    NO_BANDWIDTH,
    TOLERABLE_RISK
}
