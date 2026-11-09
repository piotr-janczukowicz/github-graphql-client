package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryCodeownersError}. */
public interface RepositoryCodeownersErrorSelector {

    int column();

    String kind();

    int line();

    String message();

    String path();

    String source();

    @Nullable String suggestion();
}
