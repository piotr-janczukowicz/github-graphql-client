package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code UserNamespaceRepository}. */
public interface UserNamespaceRepositorySelector {

    String id();

    String name();

    String nameWithOwner();

    <R> R owner(Function<RepositoryOwnerSelector, R> selection);
}
