package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code SponsorAndLifetimeValue}; used by the generated selection code only. */
final class SponsorAndLifetimeValueSelectorImpl implements SponsorAndLifetimeValueSelector {

    private final Cursor cursor;

    SponsorAndLifetimeValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int amountInCents() {
        return cursor.getRequired("amountInCents", ScalarType.INT);
    }

    @Override
    public String formattedAmount() {
        return cursor.getRequired("formattedAmount", ScalarType.STRING);
    }

    @Override
    public <R> R sponsor(final Function<SponsorableSelector, R> selection) {
        return cursor.objectRequired("sponsor", child -> selection.apply(new SponsorableSelectorImpl(child)));
    }

    @Override
    public <R> R sponsorable(final Function<SponsorableSelector, R> selection) {
        return cursor.objectRequired("sponsorable", child -> selection.apply(new SponsorableSelectorImpl(child)));
    }
}
