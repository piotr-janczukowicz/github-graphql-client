package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PullRequestReviewCommentEdge}. */
public interface PullRequestReviewCommentEdgeSelector {

    String cursor();

    <R> @Nullable R node(Function<PullRequestReviewCommentSelector, R> selection);
}
