package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockLockablePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockableSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code LockLockablePayload}; used by the generated selection code only. */
final class LockLockablePayloadSelectorImpl implements LockLockablePayloadSelector {

    private final Cursor cursor;

    LockLockablePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R lockedRecord(final Function<LockableSelector, R> selection) {
        return cursor.object("lockedRecord", child -> selection.apply(new LockableSelectorImpl(child)));
    }
}
