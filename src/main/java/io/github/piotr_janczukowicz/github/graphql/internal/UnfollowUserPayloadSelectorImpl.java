package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UnfollowUserPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UnfollowUserPayload}; used by the generated selection code only. */
final class UnfollowUserPayloadSelectorImpl implements UnfollowUserPayloadSelector {

    private final Cursor cursor;

    UnfollowUserPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R user(final Function<UserSelector, R> selection) {
        return cursor.object("user", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
