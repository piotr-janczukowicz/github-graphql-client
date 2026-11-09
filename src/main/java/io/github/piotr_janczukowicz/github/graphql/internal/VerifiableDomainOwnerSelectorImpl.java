package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainOwnerSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code VerifiableDomainOwner}; used by the generated selection code only. */
final class VerifiableDomainOwnerSelectorImpl implements VerifiableDomainOwnerSelector {

    private final Cursor cursor;

    VerifiableDomainOwnerSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, VerifiableDomainOwnerSelector.class, type, selection);
    }
}
