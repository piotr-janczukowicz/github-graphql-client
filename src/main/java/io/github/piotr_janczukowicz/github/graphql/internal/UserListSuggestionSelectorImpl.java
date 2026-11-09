package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UserListSuggestionSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UserListSuggestion}; used by the generated selection code only. */
final class UserListSuggestionSelectorImpl implements UserListSuggestionSelector {

    private final Cursor cursor;

    UserListSuggestionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String id() {
        return cursor.get("id", ScalarType.STRING);
    }

    @Override
    public @Nullable String name() {
        return cursor.get("name", ScalarType.STRING);
    }
}
