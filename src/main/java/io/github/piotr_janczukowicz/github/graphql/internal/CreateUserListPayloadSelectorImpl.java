package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateUserListPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserListSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateUserListPayload}; used by the generated selection code only. */
final class CreateUserListPayloadSelectorImpl implements CreateUserListPayloadSelector {

    private final Cursor cursor;

    CreateUserListPayloadSelectorImpl(final Cursor cursor) {
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

    @Override
    public <R> @Nullable R viewer(final Function<UserSelector, R> selection) {
        return cursor.object("viewer", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
