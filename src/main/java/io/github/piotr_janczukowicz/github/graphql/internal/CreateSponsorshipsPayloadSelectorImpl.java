package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateSponsorshipsPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateSponsorshipsPayload}; used by the generated selection code only. */
final class CreateSponsorshipsPayloadSelectorImpl implements CreateSponsorshipsPayloadSelector {

    private final Cursor cursor;

    CreateSponsorshipsPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> List<R> sponsorables(final Function<SponsorableSelector, R> selection) {
        return cursor.list("sponsorables", child -> selection.apply(new SponsorableSelectorImpl(child)));
    }
}
