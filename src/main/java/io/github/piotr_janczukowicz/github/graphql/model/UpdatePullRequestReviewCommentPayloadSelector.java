package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdatePullRequestReviewCommentPayload}. */
public interface UpdatePullRequestReviewCommentPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R pullRequestReviewComment(Function<PullRequestReviewCommentSelector, R> selection);
}
