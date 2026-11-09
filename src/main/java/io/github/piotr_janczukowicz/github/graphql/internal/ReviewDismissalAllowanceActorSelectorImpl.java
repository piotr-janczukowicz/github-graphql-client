package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ReviewDismissalAllowanceActorSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReviewDismissalAllowanceActor}; used by the generated selection code only. */
final class ReviewDismissalAllowanceActorSelectorImpl implements ReviewDismissalAllowanceActorSelector {

    private final Cursor cursor;

    ReviewDismissalAllowanceActorSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, ReviewDismissalAllowanceActorSelector.class, type, selection);
    }
}
