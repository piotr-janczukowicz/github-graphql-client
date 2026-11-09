package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateSponsorsListingPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateSponsorsListingPayload}; used by the generated selection code only. */
final class CreateSponsorsListingPayloadSelectorImpl implements CreateSponsorsListingPayloadSelector {

    private final Cursor cursor;

    CreateSponsorsListingPayloadSelectorImpl(final Cursor cursor) {
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
