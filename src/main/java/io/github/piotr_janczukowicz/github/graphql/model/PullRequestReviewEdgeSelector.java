package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PullRequestReviewEdge}. */
public interface PullRequestReviewEdgeSelector {

    String cursor();

    <R> @Nullable R node(Function<PullRequestReviewSelector, R> selection);
}
