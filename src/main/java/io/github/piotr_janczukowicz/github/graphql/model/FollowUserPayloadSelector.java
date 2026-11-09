package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code FollowUserPayload}. */
public interface FollowUserPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R user(Function<UserSelector, R> selection);
}
