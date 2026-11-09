package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Sponsor}; used by the generated selection code only. */
final class SponsorSelectorImpl implements SponsorSelector {

    private final Cursor cursor;

    SponsorSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, SponsorSelector.class, type, selection);
    }
}
