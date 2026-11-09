package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectCardItem}; used by the generated selection code only. */
final class ProjectCardItemSelectorImpl implements ProjectCardItemSelector {

    private final Cursor cursor;

    ProjectCardItemSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, ProjectCardItemSelector.class, type, selection);
    }
}
