package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddPullRequestReviewPayload}. */
public interface AddPullRequestReviewPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R pullRequestReview(Function<PullRequestReviewSelector, R> selection);

    <R> @Nullable R reviewEdge(Function<PullRequestReviewEdgeSelector, R> selection);
}
