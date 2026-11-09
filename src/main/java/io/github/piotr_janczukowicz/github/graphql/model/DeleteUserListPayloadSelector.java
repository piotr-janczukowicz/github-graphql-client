package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeleteUserListPayload}. */
public interface DeleteUserListPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R user(Function<UserSelector, R> selection);
}
