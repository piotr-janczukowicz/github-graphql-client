package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RuleSourceSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RuleSource}; used by the generated selection code only. */
final class RuleSourceSelectorImpl implements RuleSourceSelector {

    private final Cursor cursor;

    RuleSourceSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, RuleSourceSelector.class, type, selection);
    }
}
