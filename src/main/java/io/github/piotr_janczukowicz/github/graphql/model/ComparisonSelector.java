package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code Comparison}. */
public interface ComparisonSelector {

    int aheadBy();

    <R> R baseTarget(Function<GitObjectSelector, R> selection);

    int behindBy();

    <R> Page<R> commits(Paging paging, Function<CommitSelector, R> selection);

    <R> R headTarget(Function<GitObjectSelector, R> selection);

    String id();

    ComparisonStatus status();
}
