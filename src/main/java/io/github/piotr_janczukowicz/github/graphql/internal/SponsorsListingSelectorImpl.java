package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsGoalSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingFeaturedItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingFeaturedItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingFeaturedItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingTiersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingTiersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StripeConnectAccountSelector;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SponsorsListing}; used by the generated selection code only. */
final class SponsorsListingSelectorImpl implements SponsorsListingSelector {

    private final Cursor cursor;

    SponsorsListingSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R activeGoal(final Function<SponsorsGoalSelector, R> selection) {
        return cursor.object("activeGoal", child -> selection.apply(new SponsorsGoalSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R activeStripeConnectAccount(final Function<StripeConnectAccountSelector, R> selection) {
        return cursor.object(
                "activeStripeConnectAccount", child -> selection.apply(new StripeConnectAccountSelectorImpl(child)));
    }

    @Override
    public @Nullable String billingCountryOrRegion() {
        return cursor.get("billingCountryOrRegion", ScalarType.STRING);
    }

    @Override
    public @Nullable String contactEmailAddress() {
        return cursor.get("contactEmailAddress", ScalarType.STRING);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String dashboardResourcePath() {
        return cursor.getRequired("dashboardResourcePath", ScalarType.STRING);
    }

    @Override
    public String dashboardUrl() {
        return cursor.getRequired("dashboardUrl", ScalarType.STRING);
    }

    @Override
    public <R> List<R> featuredItems(
            final SponsorsListingFeaturedItemsFilter arguments,
            final Function<SponsorsListingFeaturedItemSelector, R> selection) {
        requireNonNull(arguments, "arguments");
        return cursor.listRequired(
                "featuredItems",
                child -> selection.apply(new SponsorsListingFeaturedItemSelectorImpl(child)),
                Argument.of(
                        "featureableTypes",
                        "[SponsorsListingFeaturedItemFeatureableType!]",
                        arguments.featureableTypes()));
    }

    @Override
    public <R> List<R> featuredItems(final Function<SponsorsListingFeaturedItemSelector, R> selection) {
        return featuredItems(SponsorsListingFeaturedItemsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R fiscalHost(final Function<OrganizationSelector, R> selection) {
        return cursor.object("fiscalHost", child -> selection.apply(new OrganizationSelectorImpl(child)));
    }

    @Override
    public String fullDescription() {
        return cursor.getRequired("fullDescription", ScalarType.STRING);
    }

    @Override
    public String fullDescriptionHTML() {
        return cursor.getRequired("fullDescriptionHTML", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isPublic() {
        return cursor.getRequired("isPublic", ScalarType.BOOLEAN);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public @Nullable LocalDate nextPayoutDate() {
        return cursor.get("nextPayoutDate", ScalarType.LOCAL_DATE);
    }

    @Override
    public @Nullable String residenceCountryOrRegion() {
        return cursor.get("residenceCountryOrRegion", ScalarType.STRING);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public String shortDescription() {
        return cursor.getRequired("shortDescription", ScalarType.STRING);
    }

    @Override
    public String slug() {
        return cursor.getRequired("slug", ScalarType.STRING);
    }

    @Override
    public <R> R sponsorable(final Function<SponsorableSelector, R> selection) {
        return cursor.objectRequired("sponsorable", child -> selection.apply(new SponsorableSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> tiers(
            final Paging paging,
            final SponsorsListingTiersFilter arguments,
            final Function<SponsorsTierSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.page(
                "tiers",
                child -> selection.apply(new SponsorsTierSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of("includeUnpublished", "Boolean", arguments.includeUnpublished()),
                Argument.of(
                        "orderBy",
                        "SponsorsTierOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> tiers(final Paging paging, final Function<SponsorsTierSelector, R> selection) {
        return tiers(paging, SponsorsListingTiersFilterBuilder.builder().build(), selection);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
