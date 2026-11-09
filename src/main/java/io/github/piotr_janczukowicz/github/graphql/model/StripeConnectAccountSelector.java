package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code StripeConnectAccount}. */
public interface StripeConnectAccountSelector {

    String accountId();

    @Nullable String billingCountryOrRegion();

    @Nullable String countryOrRegion();

    boolean isActive();

    <R> R sponsorsListing(Function<SponsorsListingSelector, R> selection);

    String stripeDashboardUrl();
}
