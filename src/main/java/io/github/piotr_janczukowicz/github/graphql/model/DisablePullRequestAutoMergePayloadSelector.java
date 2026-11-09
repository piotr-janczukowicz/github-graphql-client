package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DisablePullRequestAutoMergePayload}. */
public interface DisablePullRequestAutoMergePayloadSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    @Nullable String clientMutationId();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);
}
