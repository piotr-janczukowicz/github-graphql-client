package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PublishSponsorsTierPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PublishSponsorsTierPayload}; used by the generated selection code only. */
final class PublishSponsorsTierPayloadSelectorImpl implements PublishSponsorsTierPayloadSelector {

    private final Cursor cursor;

    PublishSponsorsTierPayloadSelectorImpl(final Cursor cursor) {
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
