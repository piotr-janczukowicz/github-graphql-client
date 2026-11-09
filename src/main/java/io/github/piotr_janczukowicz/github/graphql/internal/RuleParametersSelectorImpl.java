package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RuleParametersSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RuleParameters}; used by the generated selection code only. */
final class RuleParametersSelectorImpl implements RuleParametersSelector {

    private final Cursor cursor;

    RuleParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, RuleParametersSelector.class, type, selection);
    }
}
