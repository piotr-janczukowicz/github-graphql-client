package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UserList}. */
public interface UserListSelector {

    Instant createdAt();

    @Nullable String description();

    String id();

    boolean isPrivate();

    <R> Page<R> items(Paging paging, Function<UserListItemsSelector, R> selection);

    Instant lastAddedAt();

    String name();

    String slug();

    Instant updatedAt();

    <R> R user(Function<UserSelector, R> selection);
}
