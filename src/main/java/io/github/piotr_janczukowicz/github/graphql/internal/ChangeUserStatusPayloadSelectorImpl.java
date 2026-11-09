package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ChangeUserStatusPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ChangeUserStatusPayload}; used by the generated selection code only. */
final class ChangeUserStatusPayloadSelectorImpl implements ChangeUserStatusPayloadSelector {

    private final Cursor cursor;

    ChangeUserStatusPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R status(final Function<UserStatusSelector, R> selection) {
        return cursor.object("status", child -> selection.apply(new UserStatusSelectorImpl(child)));
    }
}
