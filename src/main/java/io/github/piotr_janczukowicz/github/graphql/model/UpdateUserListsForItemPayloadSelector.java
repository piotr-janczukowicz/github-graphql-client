package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateUserListsForItemPayload}. */
public interface UpdateUserListsForItemPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R item(Function<UserListItemsSelector, R> selection);

    <R> List<R> lists(Function<UserListSelector, R> selection);

    <R> @Nullable R user(Function<UserSelector, R> selection);
}
