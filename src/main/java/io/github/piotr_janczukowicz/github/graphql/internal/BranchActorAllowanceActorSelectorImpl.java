package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.BranchActorAllowanceActorSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code BranchActorAllowanceActor}; used by the generated selection code only. */
final class BranchActorAllowanceActorSelectorImpl implements BranchActorAllowanceActorSelector {

    private final Cursor cursor;

    BranchActorAllowanceActorSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, BranchActorAllowanceActorSelector.class, type, selection);
    }
}
