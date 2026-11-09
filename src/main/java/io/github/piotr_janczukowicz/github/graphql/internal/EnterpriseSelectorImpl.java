package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AnnouncementBannerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAvatarUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseBillingInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseEnterpriseTeamsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseEnterpriseTeamsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseInnersourceVulnerabilitiesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseInnersourceVulnerabilitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMembersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMembersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserNamespaceRepositoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserNamespaceRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserNamespaceRepositorySelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Enterprise}; used by the generated selection code only. */
final class EnterpriseSelectorImpl implements EnterpriseSelector {

    private static final String ARGUMENTS = "arguments";

    private static final String SLUG = "slug";

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String ORDER_BY = "orderBy";

    private static final String QUERY = "query";

    private final Cursor cursor;

    EnterpriseSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R announcementBanner(final Function<AnnouncementBannerSelector, R> selection) {
        return cursor.object("announcementBanner", child -> selection.apply(new AnnouncementBannerSelectorImpl(child)));
    }

    @Override
    public String avatarUrl(final EnterpriseAvatarUrlFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired("avatarUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public String avatarUrl() {
        return avatarUrl(EnterpriseAvatarUrlFilterBuilder.builder().build());
    }

    @Override
    public @Nullable String billingEmail() {
        return cursor.get("billingEmail", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R billingInfo(final Function<EnterpriseBillingInfoSelector, R> selection) {
        return cursor.object("billingInfo", child -> selection.apply(new EnterpriseBillingInfoSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public String descriptionHTML() {
        return cursor.getRequired("descriptionHTML", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R enterpriseTeam(final String slug, final Function<EnterpriseTeamSelector, R> selection) {
        requireNonNull(slug, SLUG);
        return cursor.object(
                "enterpriseTeam",
                child -> selection.apply(new EnterpriseTeamSelectorImpl(child)),
                Argument.of(SLUG, "String!", slug));
    }

    @Override
    public <R> Page<R> enterpriseTeams(
            final Paging paging,
            final EnterpriseEnterpriseTeamsFilter arguments,
            final Function<EnterpriseTeamSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "enterpriseTeams",
                child -> selection.apply(new EnterpriseTeamSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "EnterpriseTeamOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()),
                Argument.of("userLogins", "[String!]", arguments.userLogins()));
    }

    @Override
    public <R> Page<R> enterpriseTeams(final Paging paging, final Function<EnterpriseTeamSelector, R> selection) {
        return enterpriseTeams(
                paging, EnterpriseEnterpriseTeamsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> innersourceVulnerabilities(
            final Paging paging,
            final EnterpriseInnersourceVulnerabilitiesFilter arguments,
            final Function<SecurityVulnerabilitySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "innersourceVulnerabilities",
                child -> selection.apply(new SecurityVulnerabilitySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("ecosystem", "SecurityAdvisoryEcosystem", arguments.ecosystem()),
                Argument.of(
                        ORDER_BY,
                        "SecurityVulnerabilityOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("package", STRING, arguments.packageValue()),
                Argument.of("severities", "[SecurityAdvisorySeverity!]", arguments.severities()));
    }

    @Override
    public <R> Page<R> innersourceVulnerabilities(
            final Paging paging, final Function<SecurityVulnerabilitySelector, R> selection) {
        return innersourceVulnerabilities(
                paging,
                EnterpriseInnersourceVulnerabilitiesFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public @Nullable String location() {
        return cursor.get("location", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> members(
            final Paging paging,
            final EnterpriseMembersFilter arguments,
            final Function<EnterpriseMemberSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "members",
                child -> selection.apply(new EnterpriseMemberSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("deployment", "EnterpriseUserDeployment", arguments.deployment()),
                Argument.of("hasTwoFactorEnabled", "Boolean", arguments.hasTwoFactorEnabled()),
                Argument.of(
                        ORDER_BY,
                        "EnterpriseMemberOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("organizationLogins", "[String!]", arguments.organizationLogins()),
                Argument.of(QUERY, STRING, arguments.query()),
                Argument.of("role", "EnterpriseUserAccountMembershipRole", arguments.role()),
                Argument.of(
                        "twoFactorMethodSecurity",
                        "TwoFactorCredentialSecurityType",
                        arguments.twoFactorMethodSecurity()));
    }

    @Override
    public <R> Page<R> members(final Paging paging, final Function<EnterpriseMemberSelector, R> selection) {
        return members(paging, EnterpriseMembersFilterBuilder.builder().build(), selection);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> organizations(
            final Paging paging,
            final EnterpriseOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "organizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "OrganizationOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()),
                Argument.of("viewerOrganizationRole", "RoleInOrganization", arguments.viewerOrganizationRole()));
    }

    @Override
    public <R> Page<R> organizations(final Paging paging, final Function<OrganizationSelector, R> selection) {
        return organizations(
                paging, EnterpriseOrganizationsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R ownerInfo(final Function<EnterpriseOwnerInfoSelector, R> selection) {
        return cursor.object("ownerInfo", child -> selection.apply(new EnterpriseOwnerInfoSelectorImpl(child)));
    }

    @Override
    public @Nullable String readme() {
        return cursor.get("readme", ScalarType.STRING);
    }

    @Override
    public String readmeHTML() {
        return cursor.getRequired("readmeHTML", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> repositoryCustomProperties(
            final Paging paging, final Function<RepositoryCustomPropertySelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "repositoryCustomProperties",
                child -> selection.apply(new RepositoryCustomPropertySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> @Nullable R repositoryCustomProperty(
            final String propertyName, final Function<RepositoryCustomPropertySelector, R> selection) {
        requireNonNull(propertyName, "propertyName");
        return cursor.object(
                "repositoryCustomProperty",
                child -> selection.apply(new RepositoryCustomPropertySelectorImpl(child)),
                Argument.of("propertyName", "String!", propertyName));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R ruleset(final int databaseId, final Function<RepositoryRulesetSelector, R> selection) {
        return cursor.object(
                "ruleset",
                child -> selection.apply(new RepositoryRulesetSelectorImpl(child)),
                Argument.of("databaseId", INT, databaseId));
    }

    @Override
    public <R> Page<R> rulesets(final Paging paging, final Function<RepositoryRulesetSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "rulesets",
                child -> selection.apply(new RepositoryRulesetSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public @Nullable String securityContactEmail() {
        return cursor.get("securityContactEmail", ScalarType.STRING);
    }

    @Override
    public String slug() {
        return cursor.getRequired(SLUG, ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> userNamespaceRepositories(
            final Paging paging,
            final EnterpriseUserNamespaceRepositoriesFilter arguments,
            final Function<UserNamespaceRepositorySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "userNamespaceRepositories",
                child -> selection.apply(new UserNamespaceRepositorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "RepositoryOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> userNamespaceRepositories(
            final Paging paging, final Function<UserNamespaceRepositorySelector, R> selection) {
        return userNamespaceRepositories(
                paging,
                EnterpriseUserNamespaceRepositoriesFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public boolean viewerIsAdmin() {
        return cursor.getRequired("viewerIsAdmin", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String websiteUrl() {
        return cursor.get("websiteUrl", ScalarType.STRING);
    }
}
