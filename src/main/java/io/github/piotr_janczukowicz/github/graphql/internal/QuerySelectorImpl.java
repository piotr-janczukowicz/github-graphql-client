package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CodeOfConductSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorRole;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitHubMetadataSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LicenseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceCategorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.NodeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.QueryEnterpriseFilter;
import io.github.piotr_janczukowicz.github.graphql.model.QueryEnterpriseFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QueryMarketplaceCategoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.QueryMarketplaceCategoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QueryMarketplaceCategoryFilter;
import io.github.piotr_janczukowicz.github.graphql.model.QueryMarketplaceCategoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QueryMarketplaceListingsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.QueryMarketplaceListingsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QueryRateLimitFilter;
import io.github.piotr_janczukowicz.github.graphql.model.QueryRateLimitFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QueryRepositoryFilter;
import io.github.piotr_janczukowicz.github.graphql.model.QueryRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySecurityAdvisoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySecurityAdvisoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySecurityVulnerabilitiesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySecurityVulnerabilitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySelector;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySponsorablesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySponsorablesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RateLimitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SearchResultItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SearchType;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TopicSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UniformResourceLocatableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Query}; used by the generated selection code only. */
final class QuerySelectorImpl implements QuerySelector {

    private static final String KEY = "key";

    private static final String STRING = "String!";

    private static final String SLUG = "slug";

    private static final String ARGUMENTS = "arguments";

    private static final String INVITATION_TOKEN = "invitationToken";

    private static final String STRING_2 = "String";

    private static final String ENTERPRISE_SLUG = "enterpriseSlug";

    private static final String USER_LOGIN = "userLogin";

    private static final String BOOLEAN = "Boolean";

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String LOGIN = "login";

    private static final String NAME = "name";

    private static final String ORDER_BY = "orderBy";

    private final Cursor cursor;

    QuerySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R codeOfConduct(final String key, final Function<CodeOfConductSelector, R> selection) {
        requireNonNull(key, KEY);
        return cursor.object(
                "codeOfConduct",
                child -> selection.apply(new CodeOfConductSelectorImpl(child)),
                Argument.of(KEY, STRING, key));
    }

    @Override
    public <R> List<R> codesOfConduct(final Function<CodeOfConductSelector, R> selection) {
        return cursor.list("codesOfConduct", child -> selection.apply(new CodeOfConductSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R enterprise(
            final String slug, final QueryEnterpriseFilter arguments, final Function<EnterpriseSelector, R> selection) {
        requireNonNull(slug, SLUG);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "enterprise",
                child -> selection.apply(new EnterpriseSelectorImpl(child)),
                Argument.of(INVITATION_TOKEN, STRING_2, arguments.invitationToken()),
                Argument.of(SLUG, STRING, slug));
    }

    @Override
    public <R> @Nullable R enterprise(final String slug, final Function<EnterpriseSelector, R> selection) {
        return enterprise(slug, QueryEnterpriseFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R enterpriseAdministratorInvitation(
            final String enterpriseSlug,
            final EnterpriseAdministratorRole role,
            final String userLogin,
            final Function<EnterpriseAdministratorInvitationSelector, R> selection) {
        requireNonNull(enterpriseSlug, ENTERPRISE_SLUG);
        requireNonNull(role, "role");
        requireNonNull(userLogin, USER_LOGIN);
        return cursor.object(
                "enterpriseAdministratorInvitation",
                child -> selection.apply(new EnterpriseAdministratorInvitationSelectorImpl(child)),
                Argument.of(ENTERPRISE_SLUG, STRING, enterpriseSlug),
                Argument.of("role", "EnterpriseAdministratorRole!", role),
                Argument.of(USER_LOGIN, STRING, userLogin));
    }

    @Override
    public <R> @Nullable R enterpriseAdministratorInvitationByToken(
            final String invitationToken, final Function<EnterpriseAdministratorInvitationSelector, R> selection) {
        requireNonNull(invitationToken, INVITATION_TOKEN);
        return cursor.object(
                "enterpriseAdministratorInvitationByToken",
                child -> selection.apply(new EnterpriseAdministratorInvitationSelectorImpl(child)),
                Argument.of(INVITATION_TOKEN, STRING, invitationToken));
    }

    @Override
    public <R> @Nullable R enterpriseMemberInvitation(
            final String enterpriseSlug,
            final String userLogin,
            final Function<EnterpriseMemberInvitationSelector, R> selection) {
        requireNonNull(enterpriseSlug, ENTERPRISE_SLUG);
        requireNonNull(userLogin, USER_LOGIN);
        return cursor.object(
                "enterpriseMemberInvitation",
                child -> selection.apply(new EnterpriseMemberInvitationSelectorImpl(child)),
                Argument.of(ENTERPRISE_SLUG, STRING, enterpriseSlug),
                Argument.of(USER_LOGIN, STRING, userLogin));
    }

    @Override
    public <R> @Nullable R enterpriseMemberInvitationByToken(
            final String invitationToken, final Function<EnterpriseMemberInvitationSelector, R> selection) {
        requireNonNull(invitationToken, INVITATION_TOKEN);
        return cursor.object(
                "enterpriseMemberInvitationByToken",
                child -> selection.apply(new EnterpriseMemberInvitationSelectorImpl(child)),
                Argument.of(INVITATION_TOKEN, STRING, invitationToken));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R license(final String key, final Function<LicenseSelector, R> selection) {
        requireNonNull(key, KEY);
        return cursor.object(
                "license", child -> selection.apply(new LicenseSelectorImpl(child)), Argument.of(KEY, STRING, key));
    }

    @Override
    public <R> List<R> licenses(final Function<LicenseSelector, R> selection) {
        return cursor.listRequired("licenses", child -> selection.apply(new LicenseSelectorImpl(child)));
    }

    @Override
    public <R> List<R> marketplaceCategories(
            final QueryMarketplaceCategoriesFilter arguments,
            final Function<MarketplaceCategorySelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.listRequired(
                "marketplaceCategories",
                child -> selection.apply(new MarketplaceCategorySelectorImpl(child)),
                Argument.of("excludeEmpty", BOOLEAN, arguments.excludeEmpty()),
                Argument.of("excludeSubcategories", BOOLEAN, arguments.excludeSubcategories()),
                Argument.of("includeCategories", "[String!]", arguments.includeCategories()));
    }

    @Override
    public <R> List<R> marketplaceCategories(final Function<MarketplaceCategorySelector, R> selection) {
        return marketplaceCategories(
                QueryMarketplaceCategoriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R marketplaceCategory(
            final String slug,
            final QueryMarketplaceCategoryFilter arguments,
            final Function<MarketplaceCategorySelector, R> selection) {
        requireNonNull(slug, SLUG);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "marketplaceCategory",
                child -> selection.apply(new MarketplaceCategorySelectorImpl(child)),
                Argument.of(SLUG, STRING, slug),
                Argument.of("useTopicAliases", BOOLEAN, arguments.useTopicAliases()));
    }

    @Override
    public <R> @Nullable R marketplaceCategory(
            final String slug, final Function<MarketplaceCategorySelector, R> selection) {
        return marketplaceCategory(
                slug, QueryMarketplaceCategoryFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R marketplaceListing(
            final String slug, final Function<MarketplaceListingSelector, R> selection) {
        requireNonNull(slug, SLUG);
        return cursor.object(
                "marketplaceListing",
                child -> selection.apply(new MarketplaceListingSelectorImpl(child)),
                Argument.of(SLUG, STRING, slug));
    }

    @Override
    public <R> Page<R> marketplaceListings(
            final Paging paging,
            final QueryMarketplaceListingsFilter arguments,
            final Function<MarketplaceListingSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "marketplaceListings",
                child -> selection.apply(new MarketplaceListingSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("adminId", "ID", arguments.adminId()),
                Argument.of("allStates", BOOLEAN, arguments.allStates()),
                Argument.of("categorySlug", STRING_2, arguments.categorySlug()),
                Argument.of("organizationId", "ID", arguments.organizationId()),
                Argument.of("primaryCategoryOnly", BOOLEAN, arguments.primaryCategoryOnly()),
                Argument.of("slugs", "[String]", arguments.slugs()),
                Argument.of("useTopicAliases", BOOLEAN, arguments.useTopicAliases()),
                Argument.of("viewerCanAdmin", BOOLEAN, arguments.viewerCanAdmin()),
                Argument.of("withFreeTrialsOnly", BOOLEAN, arguments.withFreeTrialsOnly()));
    }

    @Override
    public <R> Page<R> marketplaceListings(
            final Paging paging, final Function<MarketplaceListingSelector, R> selection) {
        return marketplaceListings(
                paging, QueryMarketplaceListingsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> R meta(final Function<GitHubMetadataSelector, R> selection) {
        return cursor.objectRequired("meta", child -> selection.apply(new GitHubMetadataSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R node(final String id, final Function<NodeSelector, R> selection) {
        requireNonNull(id, "id");
        return cursor.object(
                "node", child -> selection.apply(new NodeSelectorImpl(child)), Argument.of("id", "ID!", id));
    }

    @Override
    public <R> List<R> nodes(final List<String> ids, final Function<NodeSelector, R> selection) {
        requireNonNull(ids, "ids");
        return cursor.listRequired(
                "nodes", child -> selection.apply(new NodeSelectorImpl(child)), Argument.of("ids", "[ID!]!", ids));
    }

    @Override
    public <R> @Nullable R organization(final String login, final Function<OrganizationSelector, R> selection) {
        requireNonNull(login, LOGIN);
        return cursor.object(
                "organization",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(LOGIN, STRING, login));
    }

    @Override
    public <R> @Nullable R rateLimit(
            final QueryRateLimitFilter arguments, final Function<RateLimitSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "rateLimit",
                child -> selection.apply(new RateLimitSelectorImpl(child)),
                Argument.of("dryRun", BOOLEAN, arguments.dryRun()));
    }

    @Override
    public <R> @Nullable R rateLimit(final Function<RateLimitSelector, R> selection) {
        return rateLimit(QueryRateLimitFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> R relay(final Function<QuerySelector, R> selection) {
        return cursor.objectRequired("relay", child -> selection.apply(new QuerySelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R repository(
            final String name,
            final String owner,
            final QueryRepositoryFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(name, NAME);
        requireNonNull(owner, "owner");
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "repository",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of("followRenames", BOOLEAN, arguments.followRenames()),
                Argument.of(NAME, STRING, name),
                Argument.of("owner", STRING, owner));
    }

    @Override
    public <R> @Nullable R repository(
            final String name, final String owner, final Function<RepositorySelector, R> selection) {
        return repository(name, owner, QueryRepositoryFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R repositoryOwner(final String login, final Function<RepositoryOwnerSelector, R> selection) {
        requireNonNull(login, LOGIN);
        return cursor.object(
                "repositoryOwner",
                child -> selection.apply(new RepositoryOwnerSelectorImpl(child)),
                Argument.of(LOGIN, STRING, login));
    }

    @Override
    public <R> @Nullable R resource(final String url, final Function<UniformResourceLocatableSelector, R> selection) {
        requireNonNull(url, "url");
        return cursor.object(
                "resource",
                child -> selection.apply(new UniformResourceLocatableSelectorImpl(child)),
                Argument.of("url", "URI!", url));
    }

    @Override
    public <R> Page<R> search(
            final String query,
            final SearchType type,
            final Paging paging,
            final Function<SearchResultItemSelector, R> selection) {
        requireNonNull(query, "query");
        requireNonNull(type, "type");
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "search",
                child -> selection.apply(new SearchResultItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("query", STRING, query),
                Argument.of("type", "SearchType!", type));
    }

    @Override
    public <R> Page<R> securityAdvisories(
            final Paging paging,
            final QuerySecurityAdvisoriesFilter arguments,
            final Function<SecurityAdvisorySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "securityAdvisories",
                child -> selection.apply(new SecurityAdvisorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("classifications", "[SecurityAdvisoryClassification!]", arguments.classifications()),
                Argument.of("epssPercentage", "Float", arguments.epssPercentage()),
                Argument.of("epssPercentile", "Float", arguments.epssPercentile()),
                Argument.of(
                        "identifier",
                        "SecurityAdvisoryIdentifierFilter",
                        arguments.identifier() == null
                                ? null
                                : arguments.identifier().toVariable()),
                Argument.of("isWithdrawn", BOOLEAN, arguments.isWithdrawn()),
                Argument.of(
                        ORDER_BY,
                        "SecurityAdvisoryOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("publishedSince", "DateTime", arguments.publishedSince()),
                Argument.of("severities", "[SecurityAdvisorySeverity!]", arguments.severities()),
                Argument.of("updatedSince", "DateTime", arguments.updatedSince()));
    }

    @Override
    public <R> Page<R> securityAdvisories(final Paging paging, final Function<SecurityAdvisorySelector, R> selection) {
        return securityAdvisories(
                paging, QuerySecurityAdvisoriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R securityAdvisory(
            final String ghsaId, final Function<SecurityAdvisorySelector, R> selection) {
        requireNonNull(ghsaId, "ghsaId");
        return cursor.object(
                "securityAdvisory",
                child -> selection.apply(new SecurityAdvisorySelectorImpl(child)),
                Argument.of("ghsaId", STRING, ghsaId));
    }

    @Override
    public <R> Page<R> securityVulnerabilities(
            final Paging paging,
            final QuerySecurityVulnerabilitiesFilter arguments,
            final Function<SecurityVulnerabilitySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "securityVulnerabilities",
                child -> selection.apply(new SecurityVulnerabilitySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("classifications", "[SecurityAdvisoryClassification!]", arguments.classifications()),
                Argument.of("ecosystem", "SecurityAdvisoryEcosystem", arguments.ecosystem()),
                Argument.of(
                        ORDER_BY,
                        "SecurityVulnerabilityOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("package", STRING_2, arguments.packageValue()),
                Argument.of("severities", "[SecurityAdvisorySeverity!]", arguments.severities()));
    }

    @Override
    public <R> Page<R> securityVulnerabilities(
            final Paging paging, final Function<SecurityVulnerabilitySelector, R> selection) {
        return securityVulnerabilities(
                paging, QuerySecurityVulnerabilitiesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> sponsorables(
            final Paging paging,
            final QuerySponsorablesFilter arguments,
            final Function<SponsorableItemSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorables",
                child -> selection.apply(new SponsorableItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("dependencyEcosystem", "SecurityAdvisoryEcosystem", arguments.dependencyEcosystem()),
                Argument.of("ecosystem", "DependencyGraphEcosystem", arguments.ecosystem()),
                Argument.of("onlyDependencies", BOOLEAN, arguments.onlyDependencies()),
                Argument.of(
                        ORDER_BY,
                        "SponsorableOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("orgLoginForDependencies", STRING_2, arguments.orgLoginForDependencies()));
    }

    @Override
    public <R> Page<R> sponsorables(final Paging paging, final Function<SponsorableItemSelector, R> selection) {
        return sponsorables(paging, QuerySponsorablesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R topic(final String name, final Function<TopicSelector, R> selection) {
        requireNonNull(name, NAME);
        return cursor.object(
                "topic", child -> selection.apply(new TopicSelectorImpl(child)), Argument.of(NAME, STRING, name));
    }

    @Override
    public <R> @Nullable R user(final String login, final Function<UserSelector, R> selection) {
        requireNonNull(login, LOGIN);
        return cursor.object(
                "user", child -> selection.apply(new UserSelectorImpl(child)), Argument.of(LOGIN, STRING, login));
    }

    @Override
    public <R> R viewer(final Function<UserSelector, R> selection) {
        return cursor.objectRequired("viewer", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
