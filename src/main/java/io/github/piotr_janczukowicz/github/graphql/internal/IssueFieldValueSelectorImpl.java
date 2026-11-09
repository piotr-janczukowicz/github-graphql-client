package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldValueSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueFieldValue}; used by the generated selection code only. */
final class IssueFieldValueSelectorImpl implements IssueFieldValueSelector {

    private final Cursor cursor;

    IssueFieldValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, IssueFieldValueSelector.class, type, selection);
    }
}
