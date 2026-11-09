package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MarkFileAsViewedPayload}. */
public interface MarkFileAsViewedPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);
}
