package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AssigneeSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Assignee}; used by the generated selection code only. */
final class AssigneeSelectorImpl implements AssigneeSelector {

    private final Cursor cursor;

    AssigneeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, AssigneeSelector.class, type, selection);
    }
}
