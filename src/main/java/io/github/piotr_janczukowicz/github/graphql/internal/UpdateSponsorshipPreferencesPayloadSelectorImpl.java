package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateSponsorshipPreferencesPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateSponsorshipPreferencesPayload}; used by the generated selection code
 * only.
 */
final class UpdateSponsorshipPreferencesPayloadSelectorImpl implements UpdateSponsorshipPreferencesPayloadSelector {

    private final Cursor cursor;

    UpdateSponsorshipPreferencesPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R sponsorship(final Function<SponsorshipSelector, R> selection) {
        return cursor.object("sponsorship", child -> selection.apply(new SponsorshipSelectorImpl(child)));
    }
}
