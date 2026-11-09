package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipPaymentSource;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Sponsorship}; used by the generated selection code only. */
final class SponsorshipSelectorImpl implements SponsorshipSelector {

    private final Cursor cursor;

    SponsorshipSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isActive() {
        return cursor.getRequired("isActive", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isOneTimePayment() {
        return cursor.getRequired("isOneTimePayment", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean isSponsorOptedIntoEmail() {
        return cursor.get("isSponsorOptedIntoEmail", ScalarType.BOOLEAN);
    }

    /**
     * @deprecated `Sponsorship.maintainer` will be removed. Use `Sponsorship.sponsorable` instead. Removal on
     *     2020-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public <R> R maintainer(final Function<UserSelector, R> selection) {
        return cursor.objectRequired("maintainer", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public @Nullable SponsorshipPaymentSource paymentSource() {
        return cursor.get(
                "paymentSource",
                ScalarType.enumeration(SponsorshipPaymentSource::fromWire, SponsorshipPaymentSource.GITHUB));
    }

    @Override
    public SponsorshipPrivacy privacyLevel() {
        return cursor.getRequired(
                "privacyLevel", ScalarType.enumeration(SponsorshipPrivacy::fromWire, SponsorshipPrivacy.PRIVATE));
    }

    /**
     * @deprecated `Sponsorship.sponsor` will be removed. Use `Sponsorship.sponsorEntity` instead. Removal on 2020-10-01
     *     UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public <R> @Nullable R sponsor(final Function<UserSelector, R> selection) {
        return cursor.object("sponsor", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R sponsorEntity(final Function<SponsorSelector, R> selection) {
        return cursor.object("sponsorEntity", child -> selection.apply(new SponsorSelectorImpl(child)));
    }

    @Override
    public <R> R sponsorable(final Function<SponsorableSelector, R> selection) {
        return cursor.objectRequired("sponsorable", child -> selection.apply(new SponsorableSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R tier(final Function<SponsorsTierSelector, R> selection) {
        return cursor.object("tier", child -> selection.apply(new SponsorsTierSelectorImpl(child)));
    }

    @Override
    public @Nullable Instant tierSelectedAt() {
        return cursor.get("tierSelectedAt", ScalarType.INSTANT);
    }
}
