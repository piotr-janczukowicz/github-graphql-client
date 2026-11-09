package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RemoveUpvotePayload}. */
public interface RemoveUpvotePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R subject(Function<VotableSelector, R> selection);
}
