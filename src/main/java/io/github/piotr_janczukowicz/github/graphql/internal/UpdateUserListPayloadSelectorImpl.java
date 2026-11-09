package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UpdateUserListPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserListSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UpdateUserListPayload}; used by the generated selection code only. */
final class UpdateUserListPayloadSelectorImpl implements UpdateUserListPayloadSelector {

    private final Cursor cursor;

    UpdateUserListPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R list(final Function<UserListSelector, R> selection) {
        return cursor.object("list", child -> selection.apply(new UserListSelectorImpl(child)));
    }
}
