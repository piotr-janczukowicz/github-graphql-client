package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ClosableSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Closable}; used by the generated selection code only. */
final class ClosableSelectorImpl implements ClosableSelector {

    private final Cursor cursor;

    ClosableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean closed() {
        return cursor.getRequired("closed", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Instant closedAt() {
        return cursor.get("closedAt", ScalarType.INSTANT);
    }

    @Override
    public boolean viewerCanClose() {
        return cursor.getRequired("viewerCanClose", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReopen() {
        return cursor.getRequired("viewerCanReopen", ScalarType.BOOLEAN);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, ClosableSelector.class, type, selection);
    }
}
