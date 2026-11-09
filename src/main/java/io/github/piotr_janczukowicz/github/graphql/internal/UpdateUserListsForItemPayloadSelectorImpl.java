package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UpdateUserListsForItemPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserListItemsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserListSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UpdateUserListsForItemPayload}; used by the generated selection code only. */
final class UpdateUserListsForItemPayloadSelectorImpl implements UpdateUserListsForItemPayloadSelector {

    private final Cursor cursor;

    UpdateUserListsForItemPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R item(final Function<UserListItemsSelector, R> selection) {
        return cursor.object("item", child -> selection.apply(new UserListItemsSelectorImpl(child)));
    }

    @Override
    public <R> List<R> lists(final Function<UserListSelector, R> selection) {
        return cursor.list("lists", child -> selection.apply(new UserListSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R user(final Function<UserSelector, R> selection) {
        return cursor.object("user", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
