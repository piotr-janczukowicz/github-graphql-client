package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateUserListPayload}. */
public interface UpdateUserListPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R list(Function<UserListSelector, R> selection);
}
