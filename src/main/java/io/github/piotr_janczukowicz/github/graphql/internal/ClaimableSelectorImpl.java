package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ClaimableSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Claimable}; used by the generated selection code only. */
final class ClaimableSelectorImpl implements ClaimableSelector {

    private final Cursor cursor;

    ClaimableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, ClaimableSelector.class, type, selection);
    }
}
