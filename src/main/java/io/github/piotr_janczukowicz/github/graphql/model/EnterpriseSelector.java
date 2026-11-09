package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Enterprise}. */
public interface EnterpriseSelector {

    <R> @Nullable R announcementBanner(Function<AnnouncementBannerSelector, R> selection);

    String avatarUrl(EnterpriseAvatarUrlFilter arguments);

    String avatarUrl();

    @Nullable String billingEmail();

    <R> @Nullable R billingInfo(Function<EnterpriseBillingInfoSelector, R> selection);

    Instant createdAt();

    @Nullable Integer databaseId();

    @Nullable String description();

    String descriptionHTML();

    <R> @Nullable R enterpriseTeam(String slug, Function<EnterpriseTeamSelector, R> selection);

    <R> Page<R> enterpriseTeams(
            Paging paging, EnterpriseEnterpriseTeamsFilter arguments, Function<EnterpriseTeamSelector, R> selection);

    <R> Page<R> enterpriseTeams(Paging paging, Function<EnterpriseTeamSelector, R> selection);

    String id();

    <R> Page<R> innersourceVulnerabilities(
            Paging paging,
            EnterpriseInnersourceVulnerabilitiesFilter arguments,
            Function<SecurityVulnerabilitySelector, R> selection);

    <R> Page<R> innersourceVulnerabilities(Paging paging, Function<SecurityVulnerabilitySelector, R> selection);

    @Nullable String location();

    <R> Page<R> members(
            Paging paging, EnterpriseMembersFilter arguments, Function<EnterpriseMemberSelector, R> selection);

    <R> Page<R> members(Paging paging, Function<EnterpriseMemberSelector, R> selection);

    String name();

    <R> Page<R> organizations(
            Paging paging, EnterpriseOrganizationsFilter arguments, Function<OrganizationSelector, R> selection);

    <R> Page<R> organizations(Paging paging, Function<OrganizationSelector, R> selection);

    <R> @Nullable R ownerInfo(Function<EnterpriseOwnerInfoSelector, R> selection);

    @Nullable String readme();

    String readmeHTML();

    <R> Page<R> repositoryCustomProperties(Paging paging, Function<RepositoryCustomPropertySelector, R> selection);

    <R> @Nullable R repositoryCustomProperty(
            String propertyName, Function<RepositoryCustomPropertySelector, R> selection);

    String resourcePath();

    <R> @Nullable R ruleset(int databaseId, Function<RepositoryRulesetSelector, R> selection);

    <R> Page<R> rulesets(Paging paging, Function<RepositoryRulesetSelector, R> selection);

    @Nullable String securityContactEmail();

    String slug();

    Instant updatedAt();

    String url();

    <R> Page<R> userNamespaceRepositories(
            Paging paging,
            EnterpriseUserNamespaceRepositoriesFilter arguments,
            Function<UserNamespaceRepositorySelector, R> selection);

    <R> Page<R> userNamespaceRepositories(Paging paging, Function<UserNamespaceRepositorySelector, R> selection);

    boolean viewerIsAdmin();

    @Nullable String websiteUrl();
}
