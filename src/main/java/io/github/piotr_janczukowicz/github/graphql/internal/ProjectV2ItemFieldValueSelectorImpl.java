package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldValueSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2ItemFieldValue}; used by the generated selection code only. */
final class ProjectV2ItemFieldValueSelectorImpl implements ProjectV2ItemFieldValueSelector {

    private final Cursor cursor;

    ProjectV2ItemFieldValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, ProjectV2ItemFieldValueSelector.class, type, selection);
    }
}
