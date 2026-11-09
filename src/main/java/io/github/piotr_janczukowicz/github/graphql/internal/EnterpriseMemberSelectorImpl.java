package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code EnterpriseMember}; used by the generated selection code only. */
final class EnterpriseMemberSelectorImpl implements EnterpriseMemberSelector {

    private final Cursor cursor;

    EnterpriseMemberSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, EnterpriseMemberSelector.class, type, selection);
    }
}
