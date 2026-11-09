package io.github.piotr_janczukowicz.github.graphql.model;

/** The GraphQL enum {@code RepositoryAffiliation}; it is only sent to GitHub, never read. */
public enum RepositoryAffiliation {
    COLLABORATOR,
    ORGANIZATION_MEMBER,
    OWNER
}
