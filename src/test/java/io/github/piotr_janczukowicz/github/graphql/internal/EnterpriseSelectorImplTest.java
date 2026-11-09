package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AnnouncementBannerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseBillingInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseEnterpriseTeamsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseInnersourceVulnerabilitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMembersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountMembershipRole;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserDeployment;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserNamespaceRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RoleInOrganization;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryEcosystem;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisorySeverity;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilityOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilityOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TwoFactorCredentialSecurityType;
import io.github.piotr_janczukowicz.github.graphql.model.UserNamespaceRepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class EnterpriseSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"announcementBanner\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}"
            + "," + "\"avatarUrl\":\"x\"" + "," + "\"billingEmail\":\"x\"" + ","
            + "\"billingInfo\":{\"allLicensableUsersCount\": 1}" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"databaseId\":1" + "," + "\"description\":\"x\"" + "," + "\"descriptionHTML\":\"x\"" + ","
            + "\"enterpriseTeam\":{\"combinedSlug\": \"x\"}" + ","
            + "\"enterpriseTeams\":{\"nodes\": [{\"combinedSlug\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + ","
            + "\"innersourceVulnerabilities\":{\"nodes\": [{\"severity\": \"CRITICAL\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"location\":\"x\"" + ","
            + "\"members\":{\"nodes\": [{\"__typename\": \"EnterpriseUserAccount\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"name\":\"x\"" + ","
            + "\"organizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"ownerInfo\":{\"affiliatedUsersWithTwoFactorDisabledExist\": true}" + "," + "\"readme\":\"x\""
            + "," + "\"readmeHTML\":\"x\"" + ","
            + "\"repositoryCustomProperties\":{\"nodes\": [{\"allowedValues\": [\"x\"]}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repositoryCustomProperty\":{\"allowedValues\": [\"x\"]}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"ruleset\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"rulesets\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"securityContactEmail\":\"x\"" + "," + "\"slug\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + ","
            + "\"userNamespaceRepositories\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerIsAdmin\":true" + "," + "\"websiteUrl\":\"x\"" + "}";

    private static List<Object> readWithArguments(final EnterpriseSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.announcementBanner(AnnouncementBannerSelector::createdAt));
        values.add(selector.avatarUrl(
                EnterpriseAvatarUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.billingEmail());
        values.add(selector.billingInfo(EnterpriseBillingInfoSelector::allLicensableUsersCount));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.description());
        values.add(selector.descriptionHTML());
        values.add(selector.enterpriseTeam("x", EnterpriseTeamSelector::combinedSlug));
        values.add(selector.enterpriseTeams(
                Paging.first(1),
                EnterpriseEnterpriseTeamsFilterBuilder.builder()
                        .orderBy(EnterpriseTeamOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseTeamOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .userLogins(List.of("x"))
                        .build(),
                EnterpriseTeamSelector::combinedSlug));
        values.add(selector.id());
        values.add(selector.innersourceVulnerabilities(
                Paging.first(1),
                EnterpriseInnersourceVulnerabilitiesFilterBuilder.builder()
                        .ecosystem(SecurityAdvisoryEcosystem.ACTIONS)
                        .orderBy(SecurityVulnerabilityOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SecurityVulnerabilityOrderField.UPDATED_AT)
                                .build())
                        .packageValue("x")
                        .severities(List.of(SecurityAdvisorySeverity.CRITICAL))
                        .build(),
                SecurityVulnerabilitySelector::severity));
        values.add(selector.location());
        values.add(selector.members(
                Paging.first(1),
                EnterpriseMembersFilterBuilder.builder()
                        .deployment(EnterpriseUserDeployment.CLOUD)
                        .hasTwoFactorEnabled(true)
                        .orderBy(EnterpriseMemberOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseMemberOrderField.CREATED_AT)
                                .build())
                        .organizationLogins(List.of("x"))
                        .query("x")
                        .role(EnterpriseUserAccountMembershipRole.MEMBER)
                        .twoFactorMethodSecurity(TwoFactorCredentialSecurityType.DISABLED)
                        .build(),
                child -> child.on(EnterpriseUserAccountSelector.class, EnterpriseUserAccountSelector::avatarUrl)));
        values.add(selector.name());
        values.add(selector.organizations(
                Paging.first(1),
                EnterpriseOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .viewerOrganizationRole(RoleInOrganization.DIRECT_MEMBER)
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.ownerInfo(EnterpriseOwnerInfoSelector::affiliatedUsersWithTwoFactorDisabledExist));
        values.add(selector.readme());
        values.add(selector.readmeHTML());
        values.add(
                selector.repositoryCustomProperties(Paging.first(1), RepositoryCustomPropertySelector::allowedValues));
        values.add(selector.repositoryCustomProperty("x", RepositoryCustomPropertySelector::allowedValues));
        values.add(selector.resourcePath());
        values.add(selector.ruleset(1, RepositoryRulesetSelector::createdAt));
        values.add(selector.rulesets(Paging.first(1), RepositoryRulesetSelector::createdAt));
        values.add(selector.securityContactEmail());
        values.add(selector.slug());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.userNamespaceRepositories(
                Paging.first(1),
                EnterpriseUserNamespaceRepositoriesFilterBuilder.builder()
                        .orderBy(RepositoryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(RepositoryOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                UserNamespaceRepositorySelector::id));
        values.add(selector.viewerIsAdmin());
        values.add(selector.websiteUrl());
        return values;
    }

    private static List<Object> readWithoutArguments(final EnterpriseSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl());
        values.add(selector.enterpriseTeams(Paging.first(1), EnterpriseTeamSelector::combinedSlug));
        values.add(selector.innersourceVulnerabilities(Paging.first(1), SecurityVulnerabilitySelector::severity));
        values.add(selector.members(
                Paging.first(1),
                child -> child.on(EnterpriseUserAccountSelector.class, EnterpriseUserAccountSelector::avatarUrl)));
        values.add(selector.organizations(Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.userNamespaceRepositories(Paging.first(1), UserNamespaceRepositorySelector::id));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new EnterpriseSelectorImpl(new RecordingCursor(root)));
        final EnterpriseSelectorImpl selector =
                new EnterpriseSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        "x",
                        "x",
                        "x",
                        new Page<>(List.of("x"), false, null),
                        "x",
                        new Page<>(List.of(SecurityAdvisorySeverity.CRITICAL), false, null),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        "x",
                        new Page<>(List.of(true), false, null),
                        true,
                        "x",
                        "x",
                        new Page<>(List.of(List.of("x")), false, null),
                        List.of("x"),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        true,
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new EnterpriseSelectorImpl(new RecordingCursor(root)));
        final EnterpriseSelectorImpl selector =
                new EnterpriseSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(SecurityAdvisorySeverity.CRITICAL), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of("x"), false, null));
    }
}
