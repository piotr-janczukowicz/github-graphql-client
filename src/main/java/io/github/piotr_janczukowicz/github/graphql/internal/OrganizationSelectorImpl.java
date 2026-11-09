package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AnnouncementBannerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListForInstalledAppsEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MannequinSelector;
import io.github.piotr_janczukowicz.github.graphql.model.NotificationRestrictionSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationAnyPinnableItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationAnyPinnableItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationAuditLogFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationAuditLogFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationAvatarUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationDomainsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationDomainsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationEnterpriseOwnersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationEnterpriseOwnersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIdentityProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInnersourceVulnerabilitiesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInnersourceVulnerabilitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIpAllowListEntriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIpAllowListEntriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIssueFieldsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIssueFieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIssueTypesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIssueTypesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationLifetimeReceivedSponsorshipValuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationLifetimeReceivedSponsorshipValuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMannequinsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMannequinsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMemberStatusesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMemberStatusesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPackagesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPackagesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPinnableItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPinnableItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPinnedItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPinnedItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationProjectsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationProjectsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationProjectsV2Filter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryDiscussionCommentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryDiscussionCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryDiscussionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryDiscussionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryMigrationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryMigrationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRulesetFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRulesetFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRulesetsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRulesetsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsoringFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsoringFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorsActivitiesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorsActivitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipForViewerAsSponsorFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipForViewerAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipForViewerAsSponsorableFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipForViewerAsSponsorableFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipNewslettersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipNewslettersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipsAsMaintainerFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipsAsMaintainerFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipsAsSponsorFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipsAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationTeamsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationTeamsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationTotalSponsorshipAmountAsSponsorInCentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationTotalSponsorshipAmountAsSponsorInCentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PackageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnableItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProfileItemShowcaseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInteractionAbilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMigrationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Organization}; used by the generated selection code only. */
final class OrganizationSelectorImpl implements OrganizationSelector {

    private static final String ARGUMENTS = "arguments";

    private static final String REMOVAL = "removal";

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String ORDER_BY = "orderBy";

    private static final String QUERY = "query";

    private static final String BOOLEAN = "Boolean";

    private static final String STRING_2 = "String!";

    private static final String NAME = "name";

    private static final String REPOSITORY_ID = "repositoryId";

    private static final String DATE_TIME = "DateTime";

    private static final String ACTIVE_ONLY = "activeOnly";

    private static final String STRING_3 = "[String!]";

    private final Cursor cursor;

    OrganizationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R announcementBanner(final Function<AnnouncementBannerSelector, R> selection) {
        return cursor.object("announcementBanner", child -> selection.apply(new AnnouncementBannerSelectorImpl(child)));
    }

    @Override
    public boolean anyPinnableItems(final OrganizationAnyPinnableItemsFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired(
                "anyPinnableItems", ScalarType.BOOLEAN, Argument.of("type", "PinnableItemType", arguments.type()));
    }

    @Override
    public boolean anyPinnableItems() {
        return anyPinnableItems(
                OrganizationAnyPinnableItemsFilterBuilder.builder().build());
    }

    @Override
    public @Nullable Instant archivedAt() {
        return cursor.get("archivedAt", ScalarType.INSTANT);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> auditLog(
            final Paging paging,
            final OrganizationAuditLogFilter arguments,
            final Function<OrganizationAuditEntrySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "auditLog",
                child -> selection.apply(new OrganizationAuditEntrySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "AuditLogOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> auditLog(final Paging paging, final Function<OrganizationAuditEntrySelector, R> selection) {
        return auditLog(paging, OrganizationAuditLogFilterBuilder.builder().build(), selection);
    }

    @Override
    public String avatarUrl(final OrganizationAvatarUrlFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired("avatarUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public String avatarUrl() {
        return avatarUrl(OrganizationAvatarUrlFilterBuilder.builder().build());
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
    public @Nullable String descriptionHTML() {
        return cursor.get("descriptionHTML", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> domains(
            final Paging paging,
            final OrganizationDomainsFilter arguments,
            final Function<VerifiableDomainSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "domains",
                child -> selection.apply(new VerifiableDomainSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("isApproved", BOOLEAN, arguments.isApproved()),
                Argument.of("isVerified", BOOLEAN, arguments.isVerified()),
                Argument.of(
                        ORDER_BY,
                        "VerifiableDomainOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> domains(final Paging paging, final Function<VerifiableDomainSelector, R> selection) {
        return domains(paging, OrganizationDomainsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable String email() {
        return cursor.get("email", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> enterpriseOwners(
            final Paging paging,
            final OrganizationEnterpriseOwnersFilter arguments,
            final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "enterpriseOwners",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "OrgEnterpriseOwnerOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("organizationRole", "RoleInOrganization", arguments.organizationRole()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> enterpriseOwners(final Paging paging, final Function<UserSelector, R> selection) {
        return enterpriseOwners(
                paging, OrganizationEnterpriseOwnersFilterBuilder.builder().build(), selection);
    }

    @Override
    public int estimatedNextSponsorsPayoutInCents() {
        return cursor.getRequired("estimatedNextSponsorsPayoutInCents", ScalarType.INT);
    }

    @Override
    public boolean hasSponsorsListing() {
        return cursor.getRequired("hasSponsorsListing", ScalarType.BOOLEAN);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> innersourceVulnerabilities(
            final Paging paging,
            final OrganizationInnersourceVulnerabilitiesFilter arguments,
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
                OrganizationInnersourceVulnerabilitiesFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> @Nullable R interactionAbility(final Function<RepositoryInteractionAbilitySelector, R> selection) {
        return cursor.object(
                "interactionAbility", child -> selection.apply(new RepositoryInteractionAbilitySelectorImpl(child)));
    }

    @Override
    public IpAllowListEnabledSettingValue ipAllowListEnabledSetting() {
        return cursor.getRequired(
                "ipAllowListEnabledSetting",
                ScalarType.enumeration(
                        IpAllowListEnabledSettingValue::fromWire, IpAllowListEnabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> ipAllowListEntries(
            final Paging paging,
            final OrganizationIpAllowListEntriesFilter arguments,
            final Function<IpAllowListEntrySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "ipAllowListEntries",
                child -> selection.apply(new IpAllowListEntrySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IpAllowListEntryOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> ipAllowListEntries(final Paging paging, final Function<IpAllowListEntrySelector, R> selection) {
        return ipAllowListEntries(
                paging, OrganizationIpAllowListEntriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public IpAllowListForInstalledAppsEnabledSettingValue ipAllowListForInstalledAppsEnabledSetting() {
        return cursor.getRequired(
                "ipAllowListForInstalledAppsEnabledSetting",
                ScalarType.enumeration(
                        IpAllowListForInstalledAppsEnabledSettingValue::fromWire,
                        IpAllowListForInstalledAppsEnabledSettingValue.DISABLED));
    }

    @Override
    public boolean isSponsoredBy(final String accountLogin) {
        requireNonNull(accountLogin, "accountLogin");
        return cursor.getRequired(
                "isSponsoredBy", ScalarType.BOOLEAN, Argument.of("accountLogin", STRING_2, accountLogin));
    }

    @Override
    public boolean isSponsoringViewer() {
        return cursor.getRequired("isSponsoringViewer", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isVerified() {
        return cursor.getRequired("isVerified", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> issueFields(
            final Paging paging,
            final OrganizationIssueFieldsFilter arguments,
            final Function<IssueFieldsSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "issueFields",
                child -> selection.apply(new IssueFieldsSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IssueFieldOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> issueFields(final Paging paging, final Function<IssueFieldsSelector, R> selection) {
        return issueFields(
                paging, OrganizationIssueFieldsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> issueTypes(
            final Paging paging,
            final OrganizationIssueTypesFilter arguments,
            final Function<IssueTypeSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "issueTypes",
                child -> selection.apply(new IssueTypeSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IssueTypeOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> issueTypes(final Paging paging, final Function<IssueTypeSelector, R> selection) {
        return issueTypes(paging, OrganizationIssueTypesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> R itemShowcase(final Function<ProfileItemShowcaseSelector, R> selection) {
        return cursor.objectRequired(
                "itemShowcase", child -> selection.apply(new ProfileItemShowcaseSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> lifetimeReceivedSponsorshipValues(
            final Paging paging,
            final OrganizationLifetimeReceivedSponsorshipValuesFilter arguments,
            final Function<SponsorAndLifetimeValueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "lifetimeReceivedSponsorshipValues",
                child -> selection.apply(new SponsorAndLifetimeValueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SponsorAndLifetimeValueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> lifetimeReceivedSponsorshipValues(
            final Paging paging, final Function<SponsorAndLifetimeValueSelector, R> selection) {
        return lifetimeReceivedSponsorshipValues(
                paging,
                OrganizationLifetimeReceivedSponsorshipValuesFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public @Nullable String location() {
        return cursor.get("location", ScalarType.STRING);
    }

    @Override
    public String login() {
        return cursor.getRequired("login", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> mannequins(
            final Paging paging,
            final OrganizationMannequinsFilter arguments,
            final Function<MannequinSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "mannequins",
                child -> selection.apply(new MannequinSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("login", STRING, arguments.login()),
                Argument.of(
                        ORDER_BY,
                        "MannequinOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> mannequins(final Paging paging, final Function<MannequinSelector, R> selection) {
        return mannequins(paging, OrganizationMannequinsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> memberStatuses(
            final Paging paging,
            final OrganizationMemberStatusesFilter arguments,
            final Function<UserStatusSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "memberStatuses",
                child -> selection.apply(new UserStatusSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "UserStatusOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> memberStatuses(final Paging paging, final Function<UserStatusSelector, R> selection) {
        return memberStatuses(
                paging, OrganizationMemberStatusesFilterBuilder.builder().build(), selection);
    }

    @Override
    public boolean membersCanForkPrivateRepositories() {
        return cursor.getRequired("membersCanForkPrivateRepositories", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> membersWithRole(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "membersWithRole",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public int monthlyEstimatedSponsorsIncomeInCents() {
        return cursor.getRequired("monthlyEstimatedSponsorsIncomeInCents", ScalarType.INT);
    }

    @Override
    public @Nullable String name() {
        return cursor.get(NAME, ScalarType.STRING);
    }

    @Override
    public String newTeamResourcePath() {
        return cursor.getRequired("newTeamResourcePath", ScalarType.STRING);
    }

    @Override
    public String newTeamUrl() {
        return cursor.getRequired("newTeamUrl", ScalarType.STRING);
    }

    @Override
    public NotificationRestrictionSettingValue notificationDeliveryRestrictionEnabledSetting() {
        return cursor.getRequired(
                "notificationDeliveryRestrictionEnabledSetting",
                ScalarType.enumeration(
                        NotificationRestrictionSettingValue::fromWire, NotificationRestrictionSettingValue.DISABLED));
    }

    @Override
    public @Nullable String organizationBillingEmail() {
        return cursor.get("organizationBillingEmail", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> packages(
            final Paging paging,
            final OrganizationPackagesFilter arguments,
            final Function<PackageSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "packages",
                child -> selection.apply(new PackageSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("names", "[String]", arguments.names()),
                Argument.of(
                        ORDER_BY,
                        "PackageOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("packageType", "PackageType", arguments.packageType()),
                Argument.of(REPOSITORY_ID, "ID", arguments.repositoryId()));
    }

    @Override
    public <R> Page<R> packages(final Paging paging, final Function<PackageSelector, R> selection) {
        return packages(paging, OrganizationPackagesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> pendingMembers(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "pendingMembers",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> pinnableItems(
            final Paging paging,
            final OrganizationPinnableItemsFilter arguments,
            final Function<PinnableItemSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pinnableItems",
                child -> selection.apply(new PinnableItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("types", "[PinnableItemType!]", arguments.types()));
    }

    @Override
    public <R> Page<R> pinnableItems(final Paging paging, final Function<PinnableItemSelector, R> selection) {
        return pinnableItems(
                paging, OrganizationPinnableItemsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> pinnedIssueFields(final Paging paging, final Function<IssueFieldsSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "pinnedIssueFields",
                child -> selection.apply(new IssueFieldsSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> pinnedItems(
            final Paging paging,
            final OrganizationPinnedItemsFilter arguments,
            final Function<PinnableItemSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pinnedItems",
                child -> selection.apply(new PinnableItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("types", "[PinnableItemType!]", arguments.types()));
    }

    @Override
    public <R> Page<R> pinnedItems(final Paging paging, final Function<PinnableItemSelector, R> selection) {
        return pinnedItems(
                paging, OrganizationPinnedItemsFilterBuilder.builder().build(), selection);
    }

    @Override
    public int pinnedItemsRemaining() {
        return cursor.getRequired("pinnedItemsRemaining", ScalarType.INT);
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> @Nullable R project(final int number, final Function<ProjectSelector, R> selection) {
        return cursor.object(
                "project",
                child -> selection.apply(new ProjectSelectorImpl(child)),
                Argument.of("number", INT, number));
    }

    @Override
    public <R> @Nullable R projectV2(final int number, final Function<ProjectV2Selector, R> selection) {
        return cursor.object(
                "projectV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of("number", INT, number));
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> projects(
            final Paging paging,
            final OrganizationProjectsFilter arguments,
            final Function<ProjectSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "projects",
                child -> selection.apply(new ProjectSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "ProjectOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("search", STRING, arguments.search()),
                Argument.of("states", "[ProjectState!]", arguments.states()));
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> projects(final Paging paging, final Function<ProjectSelector, R> selection) {
        return projects(paging, OrganizationProjectsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String projectsResourcePath() {
        return cursor.getRequired("projectsResourcePath", ScalarType.STRING);
    }

    @Override
    public String projectsUrl() {
        return cursor.getRequired("projectsUrl", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> projectsV2(
            final Paging paging,
            final OrganizationProjectsV2Filter arguments,
            final Function<ProjectV2Selector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "projectsV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("minPermissionLevel", "ProjectV2PermissionLevel", arguments.minPermissionLevel()),
                Argument.of(
                        ORDER_BY,
                        "ProjectV2Order",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> projectsV2(final Paging paging, final Function<ProjectV2Selector, R> selection) {
        return projectsV2(paging, OrganizationProjectsV2FilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> recentProjects(final Paging paging, final Function<ProjectV2Selector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "recentProjects",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> repositories(
            final Paging paging,
            final OrganizationRepositoriesFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositories",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("affiliations", "[RepositoryAffiliation]", arguments.affiliations()),
                Argument.of("hasIssuesEnabled", BOOLEAN, arguments.hasIssuesEnabled()),
                Argument.of("isArchived", BOOLEAN, arguments.isArchived()),
                Argument.of("isFork", BOOLEAN, arguments.isFork()),
                Argument.of("isLocked", BOOLEAN, arguments.isLocked()),
                Argument.of(
                        ORDER_BY,
                        "RepositoryOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("ownerAffiliations", "[RepositoryAffiliation]", arguments.ownerAffiliations()),
                Argument.of("privacy", "RepositoryPrivacy", arguments.privacy()),
                Argument.of("visibility", "RepositoryVisibility", arguments.visibility()));
    }

    @Override
    public <R> Page<R> repositories(final Paging paging, final Function<RepositorySelector, R> selection) {
        return repositories(
                paging, OrganizationRepositoriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R repository(
            final String name,
            final OrganizationRepositoryFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(name, NAME);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "repository",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of("followRenames", BOOLEAN, arguments.followRenames()),
                Argument.of(NAME, STRING_2, name));
    }

    @Override
    public <R> @Nullable R repository(final String name, final Function<RepositorySelector, R> selection) {
        return repository(name, OrganizationRepositoryFilterBuilder.builder().build(), selection);
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
                Argument.of("propertyName", STRING_2, propertyName));
    }

    @Override
    public <R> Page<R> repositoryDiscussionComments(
            final Paging paging,
            final OrganizationRepositoryDiscussionCommentsFilter arguments,
            final Function<DiscussionCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositoryDiscussionComments",
                child -> selection.apply(new DiscussionCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("onlyAnswers", BOOLEAN, arguments.onlyAnswers()),
                Argument.of(REPOSITORY_ID, "ID", arguments.repositoryId()));
    }

    @Override
    public <R> Page<R> repositoryDiscussionComments(
            final Paging paging, final Function<DiscussionCommentSelector, R> selection) {
        return repositoryDiscussionComments(
                paging,
                OrganizationRepositoryDiscussionCommentsFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> Page<R> repositoryDiscussions(
            final Paging paging,
            final OrganizationRepositoryDiscussionsFilter arguments,
            final Function<DiscussionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositoryDiscussions",
                child -> selection.apply(new DiscussionSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("answered", BOOLEAN, arguments.answered()),
                Argument.of(
                        ORDER_BY,
                        "DiscussionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(REPOSITORY_ID, "ID", arguments.repositoryId()),
                Argument.of("states", "[DiscussionState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> repositoryDiscussions(final Paging paging, final Function<DiscussionSelector, R> selection) {
        return repositoryDiscussions(
                paging, OrganizationRepositoryDiscussionsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> repositoryMigrations(
            final Paging paging,
            final OrganizationRepositoryMigrationsFilter arguments,
            final Function<RepositoryMigrationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositoryMigrations",
                child -> selection.apply(new RepositoryMigrationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "RepositoryMigrationOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("repositoryName", STRING, arguments.repositoryName()),
                Argument.of("state", "MigrationState", arguments.state()));
    }

    @Override
    public <R> Page<R> repositoryMigrations(
            final Paging paging, final Function<RepositoryMigrationSelector, R> selection) {
        return repositoryMigrations(
                paging, OrganizationRepositoryMigrationsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable Boolean requiresTwoFactorAuthentication() {
        return cursor.get("requiresTwoFactorAuthentication", ScalarType.BOOLEAN);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R ruleset(
            final int databaseId,
            final OrganizationRulesetFilter arguments,
            final Function<RepositoryRulesetSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "ruleset",
                child -> selection.apply(new RepositoryRulesetSelectorImpl(child)),
                Argument.of("databaseId", INT, databaseId),
                Argument.of("includeParents", BOOLEAN, arguments.includeParents()));
    }

    @Override
    public <R> @Nullable R ruleset(final int databaseId, final Function<RepositoryRulesetSelector, R> selection) {
        return ruleset(databaseId, OrganizationRulesetFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> rulesets(
            final Paging paging,
            final OrganizationRulesetsFilter arguments,
            final Function<RepositoryRulesetSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "rulesets",
                child -> selection.apply(new RepositoryRulesetSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("includeParents", BOOLEAN, arguments.includeParents()),
                Argument.of("targets", "[RepositoryRulesetTarget!]", arguments.targets()));
    }

    @Override
    public <R> Page<R> rulesets(final Paging paging, final Function<RepositoryRulesetSelector, R> selection) {
        return rulesets(paging, OrganizationRulesetsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R samlIdentityProvider(final Function<OrganizationIdentityProviderSelector, R> selection) {
        return cursor.object(
                "samlIdentityProvider", child -> selection.apply(new OrganizationIdentityProviderSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> sponsoring(
            final Paging paging,
            final OrganizationSponsoringFilter arguments,
            final Function<SponsorSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsoring",
                child -> selection.apply(new SponsorSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SponsorOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> sponsoring(final Paging paging, final Function<SponsorSelector, R> selection) {
        return sponsoring(paging, OrganizationSponsoringFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> sponsors(
            final Paging paging,
            final OrganizationSponsorsFilter arguments,
            final Function<SponsorSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsors",
                child -> selection.apply(new SponsorSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SponsorOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("tierId", "ID", arguments.tierId()));
    }

    @Override
    public <R> Page<R> sponsors(final Paging paging, final Function<SponsorSelector, R> selection) {
        return sponsors(paging, OrganizationSponsorsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> sponsorsActivities(
            final Paging paging,
            final OrganizationSponsorsActivitiesFilter arguments,
            final Function<SponsorsActivitySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorsActivities",
                child -> selection.apply(new SponsorsActivitySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("actions", "[SponsorsActivityAction!]", arguments.actions()),
                Argument.of("includeAsSponsor", BOOLEAN, arguments.includeAsSponsor()),
                Argument.of("includePrivate", BOOLEAN, arguments.includePrivate()),
                Argument.of(
                        ORDER_BY,
                        "SponsorsActivityOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("period", "SponsorsActivityPeriod", arguments.period()),
                Argument.of("since", DATE_TIME, arguments.since()),
                Argument.of("until", DATE_TIME, arguments.until()));
    }

    @Override
    public <R> Page<R> sponsorsActivities(final Paging paging, final Function<SponsorsActivitySelector, R> selection) {
        return sponsorsActivities(
                paging, OrganizationSponsorsActivitiesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R sponsorsListing(final Function<SponsorsListingSelector, R> selection) {
        return cursor.object("sponsorsListing", child -> selection.apply(new SponsorsListingSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R sponsorshipForViewerAsSponsor(
            final OrganizationSponsorshipForViewerAsSponsorFilter arguments,
            final Function<SponsorshipSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "sponsorshipForViewerAsSponsor",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of(ACTIVE_ONLY, BOOLEAN, arguments.activeOnly()));
    }

    @Override
    public <R> @Nullable R sponsorshipForViewerAsSponsor(final Function<SponsorshipSelector, R> selection) {
        return sponsorshipForViewerAsSponsor(
                OrganizationSponsorshipForViewerAsSponsorFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R sponsorshipForViewerAsSponsorable(
            final OrganizationSponsorshipForViewerAsSponsorableFilter arguments,
            final Function<SponsorshipSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "sponsorshipForViewerAsSponsorable",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of(ACTIVE_ONLY, BOOLEAN, arguments.activeOnly()));
    }

    @Override
    public <R> @Nullable R sponsorshipForViewerAsSponsorable(final Function<SponsorshipSelector, R> selection) {
        return sponsorshipForViewerAsSponsorable(
                OrganizationSponsorshipForViewerAsSponsorableFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> Page<R> sponsorshipNewsletters(
            final Paging paging,
            final OrganizationSponsorshipNewslettersFilter arguments,
            final Function<SponsorshipNewsletterSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorshipNewsletters",
                child -> selection.apply(new SponsorshipNewsletterSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SponsorshipNewsletterOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> sponsorshipNewsletters(
            final Paging paging, final Function<SponsorshipNewsletterSelector, R> selection) {
        return sponsorshipNewsletters(
                paging,
                OrganizationSponsorshipNewslettersFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> Page<R> sponsorshipsAsMaintainer(
            final Paging paging,
            final OrganizationSponsorshipsAsMaintainerFilter arguments,
            final Function<SponsorshipSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorshipsAsMaintainer",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(ACTIVE_ONLY, BOOLEAN, arguments.activeOnly()),
                Argument.of("includePrivate", BOOLEAN, arguments.includePrivate()),
                Argument.of(
                        ORDER_BY,
                        "SponsorshipOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> sponsorshipsAsMaintainer(final Paging paging, final Function<SponsorshipSelector, R> selection) {
        return sponsorshipsAsMaintainer(
                paging,
                OrganizationSponsorshipsAsMaintainerFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> Page<R> sponsorshipsAsSponsor(
            final Paging paging,
            final OrganizationSponsorshipsAsSponsorFilter arguments,
            final Function<SponsorshipSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorshipsAsSponsor",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(ACTIVE_ONLY, BOOLEAN, arguments.activeOnly()),
                Argument.of("maintainerLogins", STRING_3, arguments.maintainerLogins()),
                Argument.of(
                        ORDER_BY,
                        "SponsorshipOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> sponsorshipsAsSponsor(final Paging paging, final Function<SponsorshipSelector, R> selection) {
        return sponsorshipsAsSponsor(
                paging, OrganizationSponsorshipsAsSponsorFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R team(final String slug, final Function<TeamSelector, R> selection) {
        requireNonNull(slug, "slug");
        return cursor.object(
                "team", child -> selection.apply(new TeamSelectorImpl(child)), Argument.of("slug", STRING_2, slug));
    }

    @Override
    public <R> Page<R> teams(
            final Paging paging, final OrganizationTeamsFilter arguments, final Function<TeamSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "teams",
                child -> selection.apply(new TeamSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("ldapMapped", BOOLEAN, arguments.ldapMapped()),
                Argument.of("notificationSetting", "TeamNotificationSetting", arguments.notificationSetting()),
                Argument.of(
                        ORDER_BY,
                        "TeamOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("privacy", "TeamPrivacy", arguments.privacy()),
                Argument.of(QUERY, STRING, arguments.query()),
                Argument.of("role", "TeamRole", arguments.role()),
                Argument.of("rootTeamsOnly", BOOLEAN, arguments.rootTeamsOnly()),
                Argument.of("userLogins", STRING_3, arguments.userLogins()));
    }

    @Override
    public <R> Page<R> teams(final Paging paging, final Function<TeamSelector, R> selection) {
        return teams(paging, OrganizationTeamsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String teamsResourcePath() {
        return cursor.getRequired("teamsResourcePath", ScalarType.STRING);
    }

    @Override
    public String teamsUrl() {
        return cursor.getRequired("teamsUrl", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer totalSponsorshipAmountAsSponsorInCents(
            final OrganizationTotalSponsorshipAmountAsSponsorInCentsFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.get(
                "totalSponsorshipAmountAsSponsorInCents",
                ScalarType.INT,
                Argument.of("since", DATE_TIME, arguments.since()),
                Argument.of("sponsorableLogins", STRING_3, arguments.sponsorableLogins()),
                Argument.of("until", DATE_TIME, arguments.until()));
    }

    @Override
    public @Nullable Integer totalSponsorshipAmountAsSponsorInCents() {
        return totalSponsorshipAmountAsSponsorInCents(
                OrganizationTotalSponsorshipAmountAsSponsorInCentsFilterBuilder.builder()
                        .build());
    }

    @Override
    public @Nullable String twitterUsername() {
        return cursor.get("twitterUsername", ScalarType.STRING);
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
    public boolean viewerCanAdminister() {
        return cursor.getRequired("viewerCanAdminister", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanChangePinnedItems() {
        return cursor.getRequired("viewerCanChangePinnedItems", ScalarType.BOOLEAN);
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public boolean viewerCanCreateProjects() {
        return cursor.getRequired("viewerCanCreateProjects", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanCreateRepositories() {
        return cursor.getRequired("viewerCanCreateRepositories", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanCreateTeams() {
        return cursor.getRequired("viewerCanCreateTeams", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanSponsor() {
        return cursor.getRequired("viewerCanSponsor", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerIsAMember() {
        return cursor.getRequired("viewerIsAMember", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerIsFollowing() {
        return cursor.getRequired("viewerIsFollowing", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerIsSponsoring() {
        return cursor.getRequired("viewerIsSponsoring", ScalarType.BOOLEAN);
    }

    @Override
    public boolean webCommitSignoffRequired() {
        return cursor.getRequired("webCommitSignoffRequired", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String websiteUrl() {
        return cursor.get("websiteUrl", ScalarType.STRING);
    }
}
