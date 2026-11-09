package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UnfollowUserPayload}. */
public interface UnfollowUserPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R user(Function<UserSelector, R> selection);
}
