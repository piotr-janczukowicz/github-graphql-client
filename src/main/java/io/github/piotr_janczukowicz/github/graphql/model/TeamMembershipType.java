package io.github.piotr_janczukowicz.github.graphql.model;

/** The GraphQL enum {@code TeamMembershipType}; it is only sent to GitHub, never read. */
public enum TeamMembershipType {
    ALL,
    CHILD_TEAM,
    IMMEDIATE
}
