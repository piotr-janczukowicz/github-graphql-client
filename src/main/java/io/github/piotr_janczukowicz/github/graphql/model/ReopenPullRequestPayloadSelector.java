package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ReopenPullRequestPayload}. */
public interface ReopenPullRequestPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);
}
