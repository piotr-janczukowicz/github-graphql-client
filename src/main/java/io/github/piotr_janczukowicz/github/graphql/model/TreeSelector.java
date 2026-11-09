package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code Tree}. */
public interface TreeSelector {

    String abbreviatedOid();

    String commitResourcePath();

    String commitUrl();

    <R> List<R> entries(Function<TreeEntrySelector, R> selection);

    String id();

    String oid();

    <R> R repository(Function<RepositorySelector, R> selection);
}
