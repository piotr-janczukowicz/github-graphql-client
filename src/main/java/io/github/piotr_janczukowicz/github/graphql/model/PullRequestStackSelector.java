package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code PullRequestStack}. */
public interface PullRequestStackSelector {

    String baseRefName();

    <R> Page<R> entries(Paging paging, Function<PullRequestStackEntrySelector, R> selection);

    String id();

    int number();

    int size();
}
