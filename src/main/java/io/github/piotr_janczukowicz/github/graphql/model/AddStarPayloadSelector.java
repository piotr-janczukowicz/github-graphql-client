package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddStarPayload}. */
public interface AddStarPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R starrable(Function<StarrableSelector, R> selection);
}
