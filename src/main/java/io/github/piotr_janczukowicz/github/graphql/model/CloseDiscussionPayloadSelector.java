package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CloseDiscussionPayload}. */
public interface CloseDiscussionPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R discussion(Function<DiscussionSelector, R> selection);
}
