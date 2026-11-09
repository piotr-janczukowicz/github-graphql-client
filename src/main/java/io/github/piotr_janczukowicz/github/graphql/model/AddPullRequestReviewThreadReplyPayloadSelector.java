package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddPullRequestReviewThreadReplyPayload}. */
public interface AddPullRequestReviewThreadReplyPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R comment(Function<PullRequestReviewCommentSelector, R> selection);
}
