package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code GitObject}. */
public interface GitObjectSelector {

    String abbreviatedOid();

    String commitResourcePath();

    String commitUrl();

    String id();

    String oid();

    <R> R repository(Function<RepositorySelector, R> selection);

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
