package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code EnterpriseRepositoryInfo}. */
public interface EnterpriseRepositoryInfoSelector {

    String id();

    boolean isPrivate();

    String name();

    String nameWithOwner();
}
