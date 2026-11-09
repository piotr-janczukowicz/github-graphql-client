package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierAdminInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SponsorsTier}; used by the generated selection code only. */
final class SponsorsTierSelectorImpl implements SponsorsTierSelector {

    private final Cursor cursor;

    SponsorsTierSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R adminInfo(final Function<SponsorsTierAdminInfoSelector, R> selection) {
        return cursor.object("adminInfo", child -> selection.apply(new SponsorsTierAdminInfoSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R closestLesserValueTier(final Function<SponsorsTierSelector, R> selection) {
        return cursor.object("closestLesserValueTier", child -> selection.apply(new SponsorsTierSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String description() {
        return cursor.getRequired("description", ScalarType.STRING);
    }

    @Override
    public String descriptionHTML() {
        return cursor.getRequired("descriptionHTML", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isCustomAmount() {
        return cursor.getRequired("isCustomAmount", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isOneTime() {
        return cursor.getRequired("isOneTime", ScalarType.BOOLEAN);
    }

    @Override
    public int monthlyPriceInCents() {
        return cursor.getRequired("monthlyPriceInCents", ScalarType.INT);
    }

    @Override
    public int monthlyPriceInDollars() {
        return cursor.getRequired("monthlyPriceInDollars", ScalarType.INT);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> R sponsorsListing(final Function<SponsorsListingSelector, R> selection) {
        return cursor.objectRequired(
                "sponsorsListing", child -> selection.apply(new SponsorsListingSelectorImpl(child)));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
