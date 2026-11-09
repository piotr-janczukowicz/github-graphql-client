package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddPullRequestReviewCommentPayload}. */
public interface AddPullRequestReviewCommentPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R comment(Function<PullRequestReviewCommentSelector, R> selection);

    <R> @Nullable R commentEdge(Function<PullRequestReviewCommentEdgeSelector, R> selection);
}
