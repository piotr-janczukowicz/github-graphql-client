package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Query}. */
public interface QuerySelector {

    <R> @Nullable R codeOfConduct(String key, Function<CodeOfConductSelector, R> selection);

    <R> List<R> codesOfConduct(Function<CodeOfConductSelector, R> selection);

    <R> @Nullable R enterprise(String slug, QueryEnterpriseFilter arguments, Function<EnterpriseSelector, R> selection);

    <R> @Nullable R enterprise(String slug, Function<EnterpriseSelector, R> selection);

    <R> @Nullable R enterpriseAdministratorInvitation(
            String enterpriseSlug,
            EnterpriseAdministratorRole role,
            String userLogin,
            Function<EnterpriseAdministratorInvitationSelector, R> selection);

    <R> @Nullable R enterpriseAdministratorInvitationByToken(
            String invitationToken, Function<EnterpriseAdministratorInvitationSelector, R> selection);

    <R> @Nullable R enterpriseMemberInvitation(
            String enterpriseSlug, String userLogin, Function<EnterpriseMemberInvitationSelector, R> selection);

    <R> @Nullable R enterpriseMemberInvitationByToken(
            String invitationToken, Function<EnterpriseMemberInvitationSelector, R> selection);

    String id();

    <R> @Nullable R license(String key, Function<LicenseSelector, R> selection);

    <R> List<R> licenses(Function<LicenseSelector, R> selection);

    <R> List<R> marketplaceCategories(
            QueryMarketplaceCategoriesFilter arguments, Function<MarketplaceCategorySelector, R> selection);

    <R> List<R> marketplaceCategories(Function<MarketplaceCategorySelector, R> selection);

    <R> @Nullable R marketplaceCategory(
            String slug, QueryMarketplaceCategoryFilter arguments, Function<MarketplaceCategorySelector, R> selection);

    <R> @Nullable R marketplaceCategory(String slug, Function<MarketplaceCategorySelector, R> selection);

    <R> @Nullable R marketplaceListing(String slug, Function<MarketplaceListingSelector, R> selection);

    <R> Page<R> marketplaceListings(
            Paging paging, QueryMarketplaceListingsFilter arguments, Function<MarketplaceListingSelector, R> selection);

    <R> Page<R> marketplaceListings(Paging paging, Function<MarketplaceListingSelector, R> selection);

    <R> R meta(Function<GitHubMetadataSelector, R> selection);

    <R> @Nullable R node(String id, Function<NodeSelector, R> selection);

    <R> List<R> nodes(List<String> ids, Function<NodeSelector, R> selection);

    <R> @Nullable R organization(String login, Function<OrganizationSelector, R> selection);

    <R> @Nullable R rateLimit(QueryRateLimitFilter arguments, Function<RateLimitSelector, R> selection);

    <R> @Nullable R rateLimit(Function<RateLimitSelector, R> selection);

    <R> R relay(Function<QuerySelector, R> selection);

    <R> @Nullable R repository(
            String name, String owner, QueryRepositoryFilter arguments, Function<RepositorySelector, R> selection);

    <R> @Nullable R repository(String name, String owner, Function<RepositorySelector, R> selection);

    <R> @Nullable R repositoryOwner(String login, Function<RepositoryOwnerSelector, R> selection);

    <R> @Nullable R resource(String url, Function<UniformResourceLocatableSelector, R> selection);

    <R> Page<R> search(String query, SearchType type, Paging paging, Function<SearchResultItemSelector, R> selection);

    <R> Page<R> securityAdvisories(
            Paging paging, QuerySecurityAdvisoriesFilter arguments, Function<SecurityAdvisorySelector, R> selection);

    <R> Page<R> securityAdvisories(Paging paging, Function<SecurityAdvisorySelector, R> selection);

    <R> @Nullable R securityAdvisory(String ghsaId, Function<SecurityAdvisorySelector, R> selection);

    <R> Page<R> securityVulnerabilities(
            Paging paging,
            QuerySecurityVulnerabilitiesFilter arguments,
            Function<SecurityVulnerabilitySelector, R> selection);

    <R> Page<R> securityVulnerabilities(Paging paging, Function<SecurityVulnerabilitySelector, R> selection);

    <R> Page<R> sponsorables(
            Paging paging, QuerySponsorablesFilter arguments, Function<SponsorableItemSelector, R> selection);

    <R> Page<R> sponsorables(Paging paging, Function<SponsorableItemSelector, R> selection);

    <R> @Nullable R topic(String name, Function<TopicSelector, R> selection);

    <R> @Nullable R user(String login, Function<UserSelector, R> selection);

    <R> R viewer(Function<UserSelector, R> selection);
}
