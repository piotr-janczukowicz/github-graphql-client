package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.StatusCheckRollupContextSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code StatusCheckRollupContext}; used by the generated selection code only. */
final class StatusCheckRollupContextSelectorImpl implements StatusCheckRollupContextSelector {

    private final Cursor cursor;

    StatusCheckRollupContextSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, StatusCheckRollupContextSelector.class, type, selection);
    }
}
