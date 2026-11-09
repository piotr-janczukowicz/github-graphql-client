package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code Blame}. */
public interface BlameSelector {

    <R> List<R> ranges(Function<BlameRangeSelector, R> selection);
}
