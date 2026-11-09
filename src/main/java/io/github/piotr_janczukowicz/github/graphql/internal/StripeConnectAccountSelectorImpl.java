package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StripeConnectAccountSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code StripeConnectAccount}; used by the generated selection code only. */
final class StripeConnectAccountSelectorImpl implements StripeConnectAccountSelector {

    private final Cursor cursor;

    StripeConnectAccountSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String accountId() {
        return cursor.getRequired("accountId", ScalarType.STRING);
    }

    @Override
    public @Nullable String billingCountryOrRegion() {
        return cursor.get("billingCountryOrRegion", ScalarType.STRING);
    }

    @Override
    public @Nullable String countryOrRegion() {
        return cursor.get("countryOrRegion", ScalarType.STRING);
    }

    @Override
    public boolean isActive() {
        return cursor.getRequired("isActive", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R sponsorsListing(final Function<SponsorsListingSelector, R> selection) {
        return cursor.objectRequired(
                "sponsorsListing", child -> selection.apply(new SponsorsListingSelectorImpl(child)));
    }

    @Override
    public String stripeDashboardUrl() {
        return cursor.getRequired("stripeDashboardUrl", ScalarType.STRING);
    }
}
