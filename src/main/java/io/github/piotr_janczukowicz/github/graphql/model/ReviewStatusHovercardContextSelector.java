package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ReviewStatusHovercardContext}. */
public interface ReviewStatusHovercardContextSelector {

    String message();

    String octicon();

    @Nullable PullRequestReviewDecision reviewDecision();
}
