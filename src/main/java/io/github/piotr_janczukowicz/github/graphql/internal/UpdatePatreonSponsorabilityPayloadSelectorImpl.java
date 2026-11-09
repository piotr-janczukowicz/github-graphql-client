package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdatePatreonSponsorabilityPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdatePatreonSponsorabilityPayload}; used by the generated selection code
 * only.
 */
final class UpdatePatreonSponsorabilityPayloadSelectorImpl implements UpdatePatreonSponsorabilityPayloadSelector {

    private final Cursor cursor;

    UpdatePatreonSponsorabilityPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R sponsorsListing(final Function<SponsorsListingSelector, R> selection) {
        return cursor.object("sponsorsListing", child -> selection.apply(new SponsorsListingSelectorImpl(child)));
    }
}
