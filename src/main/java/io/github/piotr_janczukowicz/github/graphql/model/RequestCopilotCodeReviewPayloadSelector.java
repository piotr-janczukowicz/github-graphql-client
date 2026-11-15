package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RequestCopilotCodeReviewPayload}. */
public interface RequestCopilotCodeReviewPayloadSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    @Nullable String clientMutationId();

    @Nullable CopilotCodeReviewRequestReason failureReason();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);

    <R> @Nullable R reviewRequest(Function<ReviewRequestSelector, R> selection);

    @Nullable Boolean success();
}
