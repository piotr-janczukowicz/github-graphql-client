package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListOwnerSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IpAllowListOwner}; used by the generated selection code only. */
final class IpAllowListOwnerSelectorImpl implements IpAllowListOwnerSelector {

    private final Cursor cursor;

    IpAllowListOwnerSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, IpAllowListOwnerSelector.class, type, selection);
    }
}
