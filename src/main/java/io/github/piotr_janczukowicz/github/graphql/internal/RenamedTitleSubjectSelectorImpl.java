package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RenamedTitleSubjectSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RenamedTitleSubject}; used by the generated selection code only. */
final class RenamedTitleSubjectSelectorImpl implements RenamedTitleSubjectSelector {

    private final Cursor cursor;

    RenamedTitleSubjectSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, RenamedTitleSubjectSelector.class, type, selection);
    }
}
