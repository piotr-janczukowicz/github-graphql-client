package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CVSSSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CvssSeveritiesSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CvssSeverities}; used by the generated selection code only. */
final class CvssSeveritiesSelectorImpl implements CvssSeveritiesSelector {

    private final Cursor cursor;

    CvssSeveritiesSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R cvssV3(final Function<CVSSSelector, R> selection) {
        return cursor.object("cvssV3", child -> selection.apply(new CVSSSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R cvssV4(final Function<CVSSSelector, R> selection) {
        return cursor.object("cvssV4", child -> selection.apply(new CVSSSelectorImpl(child)));
    }
}
