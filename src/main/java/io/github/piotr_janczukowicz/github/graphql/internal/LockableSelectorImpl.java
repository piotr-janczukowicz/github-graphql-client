package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.LockableSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Lockable}; used by the generated selection code only. */
final class LockableSelectorImpl implements LockableSelector {

    private final Cursor cursor;

    LockableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable LockReason activeLockReason() {
        return cursor.get("activeLockReason", ScalarType.enumeration(LockReason::fromWire, LockReason.OFF_TOPIC));
    }

    @Override
    public boolean locked() {
        return cursor.getRequired("locked", ScalarType.BOOLEAN);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, LockableSelector.class, type, selection);
    }
}
