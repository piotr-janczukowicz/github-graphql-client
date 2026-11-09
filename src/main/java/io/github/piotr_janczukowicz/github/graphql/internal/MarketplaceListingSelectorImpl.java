package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceCategorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceListingLogoUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceListingLogoUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceListingSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code MarketplaceListing}; used by the generated selection code only. */
final class MarketplaceListingSelectorImpl implements MarketplaceListingSelector {

    private final Cursor cursor;

    MarketplaceListingSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R app(final Function<AppSelector, R> selection) {
        return cursor.object("app", child -> selection.apply(new AppSelectorImpl(child)));
    }

    @Override
    public @Nullable String companyUrl() {
        return cursor.get("companyUrl", ScalarType.STRING);
    }

    @Override
    public String configurationResourcePath() {
        return cursor.getRequired("configurationResourcePath", ScalarType.STRING);
    }

    @Override
    public String configurationUrl() {
        return cursor.getRequired("configurationUrl", ScalarType.STRING);
    }

    @Override
    public @Nullable String documentationUrl() {
        return cursor.get("documentationUrl", ScalarType.STRING);
    }

    @Override
    public @Nullable String extendedDescription() {
        return cursor.get("extendedDescription", ScalarType.STRING);
    }

    @Override
    public String extendedDescriptionHTML() {
        return cursor.getRequired("extendedDescriptionHTML", ScalarType.STRING);
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
    public boolean hasPublishedFreeTrialPlans() {
        return cursor.getRequired("hasPublishedFreeTrialPlans", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasTermsOfService() {
        return cursor.getRequired("hasTermsOfService", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasVerifiedOwner() {
        return cursor.getRequired("hasVerifiedOwner", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String howItWorks() {
        return cursor.get("howItWorks", ScalarType.STRING);
    }

    @Override
    public String howItWorksHTML() {
        return cursor.getRequired("howItWorksHTML", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable String installationUrl() {
        return cursor.get("installationUrl", ScalarType.STRING);
    }

    @Override
    public boolean installedForViewer() {
        return cursor.getRequired("installedForViewer", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isArchived() {
        return cursor.getRequired("isArchived", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isDraft() {
        return cursor.getRequired("isDraft", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isPaid() {
        return cursor.getRequired("isPaid", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isPublic() {
        return cursor.getRequired("isPublic", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isRejected() {
        return cursor.getRequired("isRejected", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isUnverified() {
        return cursor.getRequired("isUnverified", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isUnverifiedPending() {
        return cursor.getRequired("isUnverifiedPending", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isVerificationPendingFromDraft() {
        return cursor.getRequired("isVerificationPendingFromDraft", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isVerificationPendingFromUnverified() {
        return cursor.getRequired("isVerificationPendingFromUnverified", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isVerified() {
        return cursor.getRequired("isVerified", ScalarType.BOOLEAN);
    }

    @Override
    public String logoBackgroundColor() {
        return cursor.getRequired("logoBackgroundColor", ScalarType.STRING);
    }

    @Override
    public @Nullable String logoUrl(final MarketplaceListingLogoUrlFilter arguments) {
        requireNonNull(arguments, "arguments");
        return cursor.get("logoUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public @Nullable String logoUrl() {
        return logoUrl(MarketplaceListingLogoUrlFilterBuilder.builder().build());
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String normalizedShortDescription() {
        return cursor.getRequired("normalizedShortDescription", ScalarType.STRING);
    }

    @Override
    public @Nullable String pricingUrl() {
        return cursor.get("pricingUrl", ScalarType.STRING);
    }

    @Override
    public <R> R primaryCategory(final Function<MarketplaceCategorySelector, R> selection) {
        return cursor.objectRequired(
                "primaryCategory", child -> selection.apply(new MarketplaceCategorySelectorImpl(child)));
    }

    @Override
    public String privacyPolicyUrl() {
        return cursor.getRequired("privacyPolicyUrl", ScalarType.STRING);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public List<String> screenshotUrls() {
        return cursor.scalarListRequired("screenshotUrls", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R secondaryCategory(final Function<MarketplaceCategorySelector, R> selection) {
        return cursor.object("secondaryCategory", child -> selection.apply(new MarketplaceCategorySelectorImpl(child)));
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
    public @Nullable String statusUrl() {
        return cursor.get("statusUrl", ScalarType.STRING);
    }

    @Override
    public @Nullable String supportEmail() {
        return cursor.get("supportEmail", ScalarType.STRING);
    }

    @Override
    public String supportUrl() {
        return cursor.getRequired("supportUrl", ScalarType.STRING);
    }

    @Override
    public @Nullable String termsOfServiceUrl() {
        return cursor.get("termsOfServiceUrl", ScalarType.STRING);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public boolean viewerCanAddPlans() {
        return cursor.getRequired("viewerCanAddPlans", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanApprove() {
        return cursor.getRequired("viewerCanApprove", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanDelist() {
        return cursor.getRequired("viewerCanDelist", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanEdit() {
        return cursor.getRequired("viewerCanEdit", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanEditCategories() {
        return cursor.getRequired("viewerCanEditCategories", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanEditPlans() {
        return cursor.getRequired("viewerCanEditPlans", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanRedraft() {
        return cursor.getRequired("viewerCanRedraft", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReject() {
        return cursor.getRequired("viewerCanReject", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanRequestApproval() {
        return cursor.getRequired("viewerCanRequestApproval", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerHasPurchased() {
        return cursor.getRequired("viewerHasPurchased", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerHasPurchasedForAllOrganizations() {
        return cursor.getRequired("viewerHasPurchasedForAllOrganizations", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerIsListingAdmin() {
        return cursor.getRequired("viewerIsListingAdmin", ScalarType.BOOLEAN);
    }
}
