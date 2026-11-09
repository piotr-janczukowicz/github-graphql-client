package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UnminimizeCommentPayload}. */
public interface UnminimizeCommentPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R unminimizedComment(Function<MinimizableSelector, R> selection);
}
