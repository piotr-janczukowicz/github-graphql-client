package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateUserListPayload}. */
public interface CreateUserListPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R list(Function<UserListSelector, R> selection);

    <R> @Nullable R viewer(Function<UserSelector, R> selection);
}
