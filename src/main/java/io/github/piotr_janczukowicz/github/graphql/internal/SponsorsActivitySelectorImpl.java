package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityAction;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipPaymentSource;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipPrivacy;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SponsorsActivity}; used by the generated selection code only. */
final class SponsorsActivitySelectorImpl implements SponsorsActivitySelector {

    private final Cursor cursor;

    SponsorsActivitySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public SponsorsActivityAction action() {
        return cursor.getRequired(
                "action",
                ScalarType.enumeration(SponsorsActivityAction::fromWire, SponsorsActivityAction.CANCELLED_SPONSORSHIP));
    }

    @Override
    public @Nullable SponsorshipPrivacy currentPrivacyLevel() {
        return cursor.get(
                "currentPrivacyLevel",
                ScalarType.enumeration(SponsorshipPrivacy::fromWire, SponsorshipPrivacy.PRIVATE));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable SponsorshipPaymentSource paymentSource() {
        return cursor.get(
                "paymentSource",
                ScalarType.enumeration(SponsorshipPaymentSource::fromWire, SponsorshipPaymentSource.GITHUB));
    }

    @Override
    public <R> @Nullable R previousSponsorsTier(final Function<SponsorsTierSelector, R> selection) {
        return cursor.object("previousSponsorsTier", child -> selection.apply(new SponsorsTierSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R sponsor(final Function<SponsorSelector, R> selection) {
        return cursor.object("sponsor", child -> selection.apply(new SponsorSelectorImpl(child)));
    }

    @Override
    public <R> R sponsorable(final Function<SponsorableSelector, R> selection) {
        return cursor.objectRequired("sponsorable", child -> selection.apply(new SponsorableSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R sponsorsTier(final Function<SponsorsTierSelector, R> selection) {
        return cursor.object("sponsorsTier", child -> selection.apply(new SponsorsTierSelectorImpl(child)));
    }

    @Override
    public @Nullable Instant timestamp() {
        return cursor.get("timestamp", ScalarType.INSTANT);
    }

    @Override
    public boolean viaBulkSponsorship() {
        return cursor.getRequired("viaBulkSponsorship", ScalarType.BOOLEAN);
    }
}
