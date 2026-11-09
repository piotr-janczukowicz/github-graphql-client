package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateDiscussionCommentPayload}. */
public interface UpdateDiscussionCommentPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R comment(Function<DiscussionCommentSelector, R> selection);
}
