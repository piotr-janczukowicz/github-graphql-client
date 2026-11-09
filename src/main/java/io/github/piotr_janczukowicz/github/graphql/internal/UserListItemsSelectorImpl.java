package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UserListItemsSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UserListItems}; used by the generated selection code only. */
final class UserListItemsSelectorImpl implements UserListItemsSelector {

    private final Cursor cursor;

    UserListItemsSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, UserListItemsSelector.class, type, selection);
    }
}
