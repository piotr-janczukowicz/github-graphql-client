package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code BlameRange}. */
public interface BlameRangeSelector {

    int age();

    <R> R commit(Function<CommitSelector, R> selection);

    int endingLine();

    int startingLine();
}
