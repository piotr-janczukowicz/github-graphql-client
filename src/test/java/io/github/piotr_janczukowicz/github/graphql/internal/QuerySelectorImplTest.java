package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CodeOfConductSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DependencyGraphEcosystem;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorRole;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitHubMetadataSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LicenseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceCategorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.NodeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.QueryEnterpriseFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QueryMarketplaceCategoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QueryMarketplaceCategoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QueryMarketplaceListingsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QueryRateLimitFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QueryRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySecurityAdvisoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySecurityVulnerabilitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySelector;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySponsorablesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RateLimitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SearchType;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryClassification;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryEcosystem;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryIdentifierFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryIdentifierType;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisorySeverity;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilityOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilityOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.TopicSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UniformResourceLocatableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class QuerySelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"codeOfConduct\":{\"body\": \"x\"}" + ","
            + "\"codesOfConduct\":[{\"body\": \"x\"}]" + "," + "\"enterprise\":{\"avatarUrl\": \"x\"}" + ","
            + "\"enterpriseAdministratorInvitation\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"enterpriseAdministratorInvitationByToken\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"enterpriseMemberInvitation\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"enterpriseMemberInvitationByToken\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "," + "\"id\":\"x\""
            + "," + "\"license\":{\"body\": \"x\"}" + "," + "\"licenses\":[{\"body\": \"x\"}]" + ","
            + "\"marketplaceCategories\":[{\"description\": \"x\"}]" + ","
            + "\"marketplaceCategory\":{\"description\": \"x\"}" + ","
            + "\"marketplaceListing\":{\"companyUrl\": \"x\"}" + ","
            + "\"marketplaceListings\":{\"nodes\": [{\"companyUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"meta\":{\"gitHubServicesSha\": \"x\"}" + "," + "\"node\":{\"id\": \"x\"}" + ","
            + "\"nodes\":[{\"id\": \"x\"}]" + "," + "\"organization\":{\"anyPinnableItems\": true}" + ","
            + "\"rateLimit\":{\"cost\": 1}" + "," + "\"relay\":{\"id\": \"x\"}" + ","
            + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"repositoryOwner\":{\"avatarUrl\": \"x\"}" + ","
            + "\"resource\":{\"resourcePath\": \"x\"}" + ","
            + "\"search\":{\"nodes\": [{\"__typename\": \"App\", \"clientId\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"securityAdvisories\":{\"nodes\": [{\"classification\": \"GENERAL\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"securityAdvisory\":{\"classification\": \"GENERAL\"}" + ","
            + "\"securityVulnerabilities\":{\"nodes\": [{\"severity\": \"CRITICAL\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsorables\":{\"nodes\": [{\"__typename\": \"Organization\", \"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"topic\":{\"id\": \"x\"}" + "," + "\"user\":{\"anyPinnableItems\": true}" + ","
            + "\"viewer\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final QuerySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.codeOfConduct("x", CodeOfConductSelector::body));
        values.add(selector.codesOfConduct(CodeOfConductSelector::body));
        values.add(selector.enterprise(
                "x",
                QueryEnterpriseFilterBuilder.builder().invitationToken("x").build(),
                EnterpriseSelector::avatarUrl));
        values.add(selector.enterpriseAdministratorInvitation(
                "x",
                EnterpriseAdministratorRole.BILLING_MANAGER,
                "x",
                EnterpriseAdministratorInvitationSelector::createdAt));
        values.add(selector.enterpriseAdministratorInvitationByToken(
                "x", EnterpriseAdministratorInvitationSelector::createdAt));
        values.add(selector.enterpriseMemberInvitation("x", "x", EnterpriseMemberInvitationSelector::createdAt));
        values.add(selector.enterpriseMemberInvitationByToken("x", EnterpriseMemberInvitationSelector::createdAt));
        values.add(selector.id());
        values.add(selector.license("x", LicenseSelector::body));
        values.add(selector.licenses(LicenseSelector::body));
        values.add(selector.marketplaceCategories(
                QueryMarketplaceCategoriesFilterBuilder.builder()
                        .excludeEmpty(true)
                        .excludeSubcategories(true)
                        .includeCategories(List.of("x"))
                        .build(),
                MarketplaceCategorySelector::description));
        values.add(selector.marketplaceCategory(
                "x",
                QueryMarketplaceCategoryFilterBuilder.builder()
                        .useTopicAliases(true)
                        .build(),
                MarketplaceCategorySelector::description));
        values.add(selector.marketplaceListing("x", MarketplaceListingSelector::companyUrl));
        values.add(selector.marketplaceListings(
                Paging.first(1),
                QueryMarketplaceListingsFilterBuilder.builder()
                        .adminId("x")
                        .allStates(true)
                        .categorySlug("x")
                        .organizationId("x")
                        .primaryCategoryOnly(true)
                        .slugs(List.of("x"))
                        .useTopicAliases(true)
                        .viewerCanAdmin(true)
                        .withFreeTrialsOnly(true)
                        .build(),
                MarketplaceListingSelector::companyUrl));
        values.add(selector.meta(GitHubMetadataSelector::gitHubServicesSha));
        values.add(selector.node("x", NodeSelector::id));
        values.add(selector.nodes(List.of("x"), NodeSelector::id));
        values.add(selector.organization("x", OrganizationSelector::anyPinnableItems));
        values.add(selector.rateLimit(
                QueryRateLimitFilterBuilder.builder().dryRun(true).build(), RateLimitSelector::cost));
        values.add(selector.relay(QuerySelector::id));
        values.add(selector.repository(
                "x",
                "x",
                QueryRepositoryFilterBuilder.builder().followRenames(true).build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.repositoryOwner("x", RepositoryOwnerSelector::avatarUrl));
        values.add(selector.resource("x", UniformResourceLocatableSelector::resourcePath));
        values.add(selector.search(
                "x",
                SearchType.DISCUSSION,
                Paging.first(1),
                child -> child.on(AppSelector.class, AppSelector::clientId)));
        values.add(selector.securityAdvisories(
                Paging.first(1),
                QuerySecurityAdvisoriesFilterBuilder.builder()
                        .classifications(List.of(SecurityAdvisoryClassification.GENERAL))
                        .epssPercentage(1.5)
                        .epssPercentile(1.5)
                        .identifier(SecurityAdvisoryIdentifierFilterBuilder.builder()
                                .type(SecurityAdvisoryIdentifierType.CVE)
                                .value("x")
                                .build())
                        .isWithdrawn(true)
                        .orderBy(SecurityAdvisoryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SecurityAdvisoryOrderField.EPSS_PERCENTAGE)
                                .build())
                        .publishedSince(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .severities(List.of(SecurityAdvisorySeverity.CRITICAL))
                        .updatedSince(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build(),
                SecurityAdvisorySelector::classification));
        values.add(selector.securityAdvisory("x", SecurityAdvisorySelector::classification));
        values.add(selector.securityVulnerabilities(
                Paging.first(1),
                QuerySecurityVulnerabilitiesFilterBuilder.builder()
                        .classifications(List.of(SecurityAdvisoryClassification.GENERAL))
                        .ecosystem(SecurityAdvisoryEcosystem.ACTIONS)
                        .orderBy(SecurityVulnerabilityOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SecurityVulnerabilityOrderField.UPDATED_AT)
                                .build())
                        .packageValue("x")
                        .severities(List.of(SecurityAdvisorySeverity.CRITICAL))
                        .build(),
                SecurityVulnerabilitySelector::severity));
        values.add(selector.sponsorables(
                Paging.first(1),
                QuerySponsorablesFilterBuilder.builder()
                        .dependencyEcosystem(SecurityAdvisoryEcosystem.ACTIONS)
                        .ecosystem(DependencyGraphEcosystem.ACTIONS)
                        .onlyDependencies(true)
                        .orderBy(SponsorableOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorableOrderField.LOGIN)
                                .build())
                        .orgLoginForDependencies("x")
                        .build(),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.topic("x", TopicSelector::id));
        values.add(selector.user("x", UserSelector::anyPinnableItems));
        values.add(selector.viewer(UserSelector::anyPinnableItems));
        return values;
    }

    private static List<Object> readWithoutArguments(final QuerySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.enterprise("x", EnterpriseSelector::avatarUrl));
        values.add(selector.marketplaceCategories(MarketplaceCategorySelector::description));
        values.add(selector.marketplaceCategory("x", MarketplaceCategorySelector::description));
        values.add(selector.marketplaceListings(Paging.first(1), MarketplaceListingSelector::companyUrl));
        values.add(selector.rateLimit(RateLimitSelector::cost));
        values.add(selector.repository("x", "x", RepositorySelector::allowUpdateBranch));
        values.add(selector.securityAdvisories(Paging.first(1), SecurityAdvisorySelector::classification));
        values.add(selector.securityVulnerabilities(Paging.first(1), SecurityVulnerabilitySelector::severity));
        values.add(selector.sponsorables(
                Paging.first(1),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new QuerySelectorImpl(new RecordingCursor(root)));
        final QuerySelectorImpl selector = new QuerySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        List.of("x"),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        List.of("x"),
                        List.of("x"),
                        "x",
                        "x",
                        new Page<>(List.of("x"), false, null),
                        "x",
                        "x",
                        List.of("x"),
                        true,
                        1,
                        "x",
                        true,
                        "x",
                        "x",
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(SecurityAdvisoryClassification.GENERAL), false, null),
                        SecurityAdvisoryClassification.GENERAL,
                        new Page<>(List.of(SecurityAdvisorySeverity.CRITICAL), false, null),
                        new Page<>(List.of(true), false, null),
                        "x",
                        true,
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new QuerySelectorImpl(new RecordingCursor(root)));
        final QuerySelectorImpl selector = new QuerySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        List.of("x"),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        1,
                        true,
                        new Page<>(List.of(SecurityAdvisoryClassification.GENERAL), false, null),
                        new Page<>(List.of(SecurityAdvisorySeverity.CRITICAL), false, null),
                        new Page<>(List.of(true), false, null));
    }
}
