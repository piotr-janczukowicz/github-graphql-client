package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeletePullRequestReviewPayload}. */
public interface DeletePullRequestReviewPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R pullRequestReview(Function<PullRequestReviewSelector, R> selection);
}
