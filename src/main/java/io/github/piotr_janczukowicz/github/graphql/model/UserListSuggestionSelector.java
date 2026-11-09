package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UserListSuggestion}. */
public interface UserListSuggestionSelector {

    @Nullable String id();

    @Nullable String name();
}
