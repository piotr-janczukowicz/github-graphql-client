package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ResolveReviewThreadPayload}. */
public interface ResolveReviewThreadPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R thread(Function<PullRequestReviewThreadSelector, R> selection);
}
