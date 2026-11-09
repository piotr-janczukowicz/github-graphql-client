package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RequestReviewsByLoginPayload}. */
public interface RequestReviewsByLoginPayloadSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    @Nullable String clientMutationId();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);

    <R> @Nullable R requestedReviewersEdge(Function<UserEdgeSelector, R> selection);
}
