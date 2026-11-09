package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RevertPullRequestPayload}. */
public interface RevertPullRequestPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);

    <R> @Nullable R revertPullRequest(Function<PullRequestSelector, R> selection);
}
