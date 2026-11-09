package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PushAllowanceActorSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PushAllowanceActor}; used by the generated selection code only. */
final class PushAllowanceActorSelectorImpl implements PushAllowanceActorSelector {

    private final Cursor cursor;

    PushAllowanceActorSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, PushAllowanceActorSelector.class, type, selection);
    }
}
