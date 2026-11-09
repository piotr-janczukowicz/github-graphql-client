package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MinimizeCommentPayload}. */
public interface MinimizeCommentPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R minimizedComment(Function<MinimizableSelector, R> selection);
}
