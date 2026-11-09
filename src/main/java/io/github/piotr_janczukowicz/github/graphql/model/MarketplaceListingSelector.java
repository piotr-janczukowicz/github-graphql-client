package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MarketplaceListing}. */
public interface MarketplaceListingSelector {

    <R> @Nullable R app(Function<AppSelector, R> selection);

    @Nullable String companyUrl();

    String configurationResourcePath();

    String configurationUrl();

    @Nullable String documentationUrl();

    @Nullable String extendedDescription();

    String extendedDescriptionHTML();

    String fullDescription();

    String fullDescriptionHTML();

    boolean hasPublishedFreeTrialPlans();

    boolean hasTermsOfService();

    boolean hasVerifiedOwner();

    @Nullable String howItWorks();

    String howItWorksHTML();

    String id();

    @Nullable String installationUrl();

    boolean installedForViewer();

    boolean isArchived();

    boolean isDraft();

    boolean isPaid();

    boolean isPublic();

    boolean isRejected();

    boolean isUnverified();

    boolean isUnverifiedPending();

    boolean isVerificationPendingFromDraft();

    boolean isVerificationPendingFromUnverified();

    boolean isVerified();

    String logoBackgroundColor();

    @Nullable String logoUrl(MarketplaceListingLogoUrlFilter arguments);

    @Nullable String logoUrl();

    String name();

    String normalizedShortDescription();

    @Nullable String pricingUrl();

    <R> R primaryCategory(Function<MarketplaceCategorySelector, R> selection);

    String privacyPolicyUrl();

    String resourcePath();

    List<String> screenshotUrls();

    <R> @Nullable R secondaryCategory(Function<MarketplaceCategorySelector, R> selection);

    String shortDescription();

    String slug();

    @Nullable String statusUrl();

    @Nullable String supportEmail();

    String supportUrl();

    @Nullable String termsOfServiceUrl();

    String url();

    boolean viewerCanAddPlans();

    boolean viewerCanApprove();

    boolean viewerCanDelist();

    boolean viewerCanEdit();

    boolean viewerCanEditCategories();

    boolean viewerCanEditPlans();

    boolean viewerCanRedraft();

    boolean viewerCanReject();

    boolean viewerCanRequestApproval();

    boolean viewerHasPurchased();

    boolean viewerHasPurchasedForAllOrganizations();

    boolean viewerIsListingAdmin();
}
