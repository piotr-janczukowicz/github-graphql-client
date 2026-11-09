package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.LockableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockedEventSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code LockedEvent}; used by the generated selection code only. */
final class LockedEventSelectorImpl implements LockedEventSelector {

    private final Cursor cursor;

    LockedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable LockReason lockReason() {
        return cursor.get("lockReason", ScalarType.enumeration(LockReason::fromWire, LockReason.OFF_TOPIC));
    }

    @Override
    public <R> R lockable(final Function<LockableSelector, R> selection) {
        return cursor.objectRequired("lockable", child -> selection.apply(new LockableSelectorImpl(child)));
    }
}
