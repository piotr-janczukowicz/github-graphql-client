package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code RepositoryCodeowners}. */
public interface RepositoryCodeownersSelector {

    <R> List<R> errors(Function<RepositoryCodeownersErrorSelector, R> selection);
}
