package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RetireSponsorsTierPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RetireSponsorsTierPayload}; used by the generated selection code only. */
final class RetireSponsorsTierPayloadSelectorImpl implements RetireSponsorsTierPayloadSelector {

    private final Cursor cursor;

    RetireSponsorsTierPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R sponsorsTier(final Function<SponsorsTierSelector, R> selection) {
        return cursor.object("sponsorsTier", child -> selection.apply(new SponsorsTierSelectorImpl(child)));
    }
}
