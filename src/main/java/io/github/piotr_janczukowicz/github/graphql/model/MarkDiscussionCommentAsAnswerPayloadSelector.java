package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MarkDiscussionCommentAsAnswerPayload}. */
public interface MarkDiscussionCommentAsAnswerPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R discussion(Function<DiscussionSelector, R> selection);
}
