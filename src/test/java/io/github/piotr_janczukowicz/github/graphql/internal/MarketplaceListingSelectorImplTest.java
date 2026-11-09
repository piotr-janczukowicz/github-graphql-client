package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceCategorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceListingLogoUrlFilterBuilder;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MarketplaceListingSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"app\":{\"clientId\": \"x\"}" + "," + "\"companyUrl\":\"x\"" + ","
            + "\"configurationResourcePath\":\"x\"" + "," + "\"configurationUrl\":\"x\"" + ","
            + "\"documentationUrl\":\"x\"" + "," + "\"extendedDescription\":\"x\"" + ","
            + "\"extendedDescriptionHTML\":\"x\"" + "," + "\"fullDescription\":\"x\"" + ","
            + "\"fullDescriptionHTML\":\"x\"" + "," + "\"hasPublishedFreeTrialPlans\":true" + ","
            + "\"hasTermsOfService\":true" + "," + "\"hasVerifiedOwner\":true" + "," + "\"howItWorks\":\"x\"" + ","
            + "\"howItWorksHTML\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"installationUrl\":\"x\"" + ","
            + "\"installedForViewer\":true" + "," + "\"isArchived\":true" + "," + "\"isDraft\":true" + ","
            + "\"isPaid\":true" + "," + "\"isPublic\":true" + "," + "\"isRejected\":true" + ","
            + "\"isUnverified\":true" + "," + "\"isUnverifiedPending\":true" + ","
            + "\"isVerificationPendingFromDraft\":true" + "," + "\"isVerificationPendingFromUnverified\":true" + ","
            + "\"isVerified\":true" + "," + "\"logoBackgroundColor\":\"x\"" + "," + "\"logoUrl\":\"x\"" + ","
            + "\"name\":\"x\"" + "," + "\"normalizedShortDescription\":\"x\"" + "," + "\"pricingUrl\":\"x\"" + ","
            + "\"primaryCategory\":{\"description\": \"x\"}" + "," + "\"privacyPolicyUrl\":\"x\"" + ","
            + "\"resourcePath\":\"x\"" + "," + "\"screenshotUrls\":[\"x\"]" + ","
            + "\"secondaryCategory\":{\"description\": \"x\"}" + "," + "\"shortDescription\":\"x\"" + ","
            + "\"slug\":\"x\"" + "," + "\"statusUrl\":\"x\"" + "," + "\"supportEmail\":\"x\"" + ","
            + "\"supportUrl\":\"x\"" + "," + "\"termsOfServiceUrl\":\"x\"" + "," + "\"url\":\"x\"" + ","
            + "\"viewerCanAddPlans\":true" + "," + "\"viewerCanApprove\":true" + "," + "\"viewerCanDelist\":true" + ","
            + "\"viewerCanEdit\":true" + "," + "\"viewerCanEditCategories\":true" + "," + "\"viewerCanEditPlans\":true"
            + "," + "\"viewerCanRedraft\":true" + "," + "\"viewerCanReject\":true" + ","
            + "\"viewerCanRequestApproval\":true" + "," + "\"viewerHasPurchased\":true" + ","
            + "\"viewerHasPurchasedForAllOrganizations\":true" + "," + "\"viewerIsListingAdmin\":true" + "}";

    private static List<Object> readWithArguments(final MarketplaceListingSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.app(AppSelector::clientId));
        values.add(selector.companyUrl());
        values.add(selector.configurationResourcePath());
        values.add(selector.configurationUrl());
        values.add(selector.documentationUrl());
        values.add(selector.extendedDescription());
        values.add(selector.extendedDescriptionHTML());
        values.add(selector.fullDescription());
        values.add(selector.fullDescriptionHTML());
        values.add(selector.hasPublishedFreeTrialPlans());
        values.add(selector.hasTermsOfService());
        values.add(selector.hasVerifiedOwner());
        values.add(selector.howItWorks());
        values.add(selector.howItWorksHTML());
        values.add(selector.id());
        values.add(selector.installationUrl());
        values.add(selector.installedForViewer());
        values.add(selector.isArchived());
        values.add(selector.isDraft());
        values.add(selector.isPaid());
        values.add(selector.isPublic());
        values.add(selector.isRejected());
        values.add(selector.isUnverified());
        values.add(selector.isUnverifiedPending());
        values.add(selector.isVerificationPendingFromDraft());
        values.add(selector.isVerificationPendingFromUnverified());
        values.add(selector.isVerified());
        values.add(selector.logoBackgroundColor());
        values.add(selector.logoUrl(
                MarketplaceListingLogoUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.name());
        values.add(selector.normalizedShortDescription());
        values.add(selector.pricingUrl());
        values.add(selector.primaryCategory(MarketplaceCategorySelector::description));
        values.add(selector.privacyPolicyUrl());
        values.add(selector.resourcePath());
        values.add(selector.screenshotUrls());
        values.add(selector.secondaryCategory(MarketplaceCategorySelector::description));
        values.add(selector.shortDescription());
        values.add(selector.slug());
        values.add(selector.statusUrl());
        values.add(selector.supportEmail());
        values.add(selector.supportUrl());
        values.add(selector.termsOfServiceUrl());
        values.add(selector.url());
        values.add(selector.viewerCanAddPlans());
        values.add(selector.viewerCanApprove());
        values.add(selector.viewerCanDelist());
        values.add(selector.viewerCanEdit());
        values.add(selector.viewerCanEditCategories());
        values.add(selector.viewerCanEditPlans());
        values.add(selector.viewerCanRedraft());
        values.add(selector.viewerCanReject());
        values.add(selector.viewerCanRequestApproval());
        values.add(selector.viewerHasPurchased());
        values.add(selector.viewerHasPurchasedForAllOrganizations());
        values.add(selector.viewerIsListingAdmin());
        return values;
    }

    private static List<Object> readWithoutArguments(final MarketplaceListingSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.logoUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new MarketplaceListingSelectorImpl(new RecordingCursor(root)));
        final MarketplaceListingSelectorImpl selector =
                new MarketplaceListingSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        true,
                        true,
                        true,
                        "x",
                        "x",
                        "x",
                        "x",
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        List.of("x"),
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new MarketplaceListingSelectorImpl(new RecordingCursor(root)));
        final MarketplaceListingSelectorImpl selector =
                new MarketplaceListingSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
