package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AuditEntryActorSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AuditEntryActor}; used by the generated selection code only. */
final class AuditEntryActorSelectorImpl implements AuditEntryActorSelector {

    private final Cursor cursor;

    AuditEntryActorSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, AuditEntryActorSelector.class, type, selection);
    }
}
