package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateDiscussionPayload}. */
public interface UpdateDiscussionPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R discussion(Function<DiscussionSelector, R> selection);
}
