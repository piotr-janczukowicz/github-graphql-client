package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CopilotEndpointsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistSelector;
import io.github.piotr_janczukowicz.github.graphql.model.HovercardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnableItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProfileItemShowcaseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.PublicKeySelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInteractionAbilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SavedReplySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SocialAccountSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserAnyPinnableItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserAnyPinnableItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserAvatarUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserContributionsCollectionFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserContributionsCollectionFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserEnterprisesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserEnterprisesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserGistsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserGistsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserHovercardFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserHovercardFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserIssueCommentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserIssueCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserIssuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserLifetimeReceivedSponsorshipValuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserLifetimeReceivedSponsorshipValuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserListSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserListSuggestionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserPackagesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserPackagesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserPinnableItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserPinnableItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserPinnedItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserPinnedItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserProjectsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserProjectsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserProjectsV2Filter;
import io.github.piotr_janczukowicz.github.graphql.model.UserProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserPullRequestsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoriesContributedToFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoriesContributedToFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoryDiscussionCommentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoryDiscussionCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoryDiscussionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoryDiscussionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoryFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSavedRepliesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserSavedRepliesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsoringFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsoringFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorsActivitiesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorsActivitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipForViewerAsSponsorFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipForViewerAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipForViewerAsSponsorableFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipForViewerAsSponsorableFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipNewslettersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipNewslettersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipsAsMaintainerFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipsAsMaintainerFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipsAsSponsorFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipsAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserStarredRepositoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserStarredRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserTopRepositoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserTopRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserTotalSponsorshipAmountAsSponsorInCentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserTotalSponsorshipAmountAsSponsorInCentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserViewType;
import io.github.piotr_janczukowicz.github.graphql.model.UserWatchingFilter;
import io.github.piotr_janczukowicz.github.graphql.model.UserWatchingFilterBuilder;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code User}; used by the generated selection code only. */
final class UserSelectorImpl implements UserSelector {

    private static final String ARGUMENTS = "arguments";

    private static final String LOGIN = "login";

    private static final String STRING = "String!";

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING_2 = "String";

    private static final String DATE_TIME = "DateTime";

    private static final String ORDER_BY = "orderBy";

    private static final String NAME = "name";

    private static final String PRIVACY = "privacy";

    private static final String STRING_3 = "[String!]";

    private static final String STATES = "states";

    private static final String REPOSITORY_ID = "repositoryId";

    private static final String REMOVAL = "removal";

    private static final String REPOSITORY_AFFILIATION = "[RepositoryAffiliation]";

    private static final String BOOLEAN = "Boolean";

    private static final String IS_LOCKED = "isLocked";

    private static final String REPOSITORY_ORDER = "RepositoryOrder";

    private static final String REPOSITORY_PRIVACY = "RepositoryPrivacy";

    private static final String SINCE = "since";

    private static final String ACTIVE_ONLY = "activeOnly";

    private final Cursor cursor;

    UserSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean anyPinnableItems(final UserAnyPinnableItemsFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired(
                "anyPinnableItems", ScalarType.BOOLEAN, Argument.of("type", "PinnableItemType", arguments.type()));
    }

    @Override
    public boolean anyPinnableItems() {
        return anyPinnableItems(UserAnyPinnableItemsFilterBuilder.builder().build());
    }

    @Override
    public String avatarUrl(final UserAvatarUrlFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired("avatarUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public String avatarUrl() {
        return avatarUrl(UserAvatarUrlFilterBuilder.builder().build());
    }

    @Override
    public @Nullable String bio() {
        return cursor.get("bio", ScalarType.STRING);
    }

    @Override
    public String bioHTML() {
        return cursor.getRequired("bioHTML", ScalarType.STRING);
    }

    @Override
    public boolean canReceiveOrganizationEmailsWhenNotificationsRestricted(final String login) {
        requireNonNull(login, LOGIN);
        return cursor.getRequired(
                "canReceiveOrganizationEmailsWhenNotificationsRestricted",
                ScalarType.BOOLEAN,
                Argument.of(LOGIN, STRING, login));
    }

    @Override
    public <R> Page<R> commitComments(final Paging paging, final Function<CommitCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "commitComments",
                child -> selection.apply(new CommitCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()));
    }

    @Override
    public @Nullable String company() {
        return cursor.get("company", ScalarType.STRING);
    }

    @Override
    public String companyHTML() {
        return cursor.getRequired("companyHTML", ScalarType.STRING);
    }

    @Override
    public <R> R contributionsCollection(
            final UserContributionsCollectionFilter arguments,
            final Function<ContributionsCollectionSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.objectRequired(
                "contributionsCollection",
                child -> selection.apply(new ContributionsCollectionSelectorImpl(child)),
                Argument.of("from", DATE_TIME, arguments.from()),
                Argument.of("organizationID", "ID", arguments.organizationID()),
                Argument.of("to", DATE_TIME, arguments.to()));
    }

    @Override
    public <R> R contributionsCollection(final Function<ContributionsCollectionSelector, R> selection) {
        return contributionsCollection(
                UserContributionsCollectionFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R copilotEndpoints(final Function<CopilotEndpointsSelector, R> selection) {
        return cursor.object("copilotEndpoints", child -> selection.apply(new CopilotEndpointsSelectorImpl(child)));
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
    public String email() {
        return cursor.getRequired("email", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> enterprises(
            final Paging paging,
            final UserEnterprisesFilter arguments,
            final Function<EnterpriseSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "enterprises",
                child -> selection.apply(new EnterpriseSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("membershipType", "EnterpriseMembershipType", arguments.membershipType()),
                Argument.of(
                        ORDER_BY,
                        "EnterpriseOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> enterprises(final Paging paging, final Function<EnterpriseSelector, R> selection) {
        return enterprises(paging, UserEnterprisesFilterBuilder.builder().build(), selection);
    }

    @Override
    public int estimatedNextSponsorsPayoutInCents() {
        return cursor.getRequired("estimatedNextSponsorsPayoutInCents", ScalarType.INT);
    }

    @Override
    public <R> Page<R> followers(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "followers",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()));
    }

    @Override
    public <R> Page<R> following(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "following",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()));
    }

    @Override
    public <R> @Nullable R gist(final String name, final Function<GistSelector, R> selection) {
        requireNonNull(name, NAME);
        return cursor.object(
                "gist", child -> selection.apply(new GistSelectorImpl(child)), Argument.of(NAME, STRING, name));
    }

    @Override
    public <R> Page<R> gistComments(final Paging paging, final Function<GistCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "gistComments",
                child -> selection.apply(new GistCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()));
    }

    @Override
    public <R> Page<R> gists(
            final Paging paging, final UserGistsFilter arguments, final Function<GistSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "gists",
                child -> selection.apply(new GistSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "GistOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(PRIVACY, "GistPrivacy", arguments.privacy()));
    }

    @Override
    public <R> Page<R> gists(final Paging paging, final Function<GistSelector, R> selection) {
        return gists(paging, UserGistsFilterBuilder.builder().build(), selection);
    }

    @Override
    public boolean hasSponsorsListing() {
        return cursor.getRequired("hasSponsorsListing", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R hovercard(final UserHovercardFilter arguments, final Function<HovercardSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.objectRequired(
                "hovercard",
                child -> selection.apply(new HovercardSelectorImpl(child)),
                Argument.of("primarySubjectId", "ID", arguments.primarySubjectId()));
    }

    @Override
    public <R> R hovercard(final Function<HovercardSelector, R> selection) {
        return hovercard(UserHovercardFilterBuilder.builder().build(), selection);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R interactionAbility(final Function<RepositoryInteractionAbilitySelector, R> selection) {
        return cursor.object(
                "interactionAbility", child -> selection.apply(new RepositoryInteractionAbilitySelectorImpl(child)));
    }

    @Override
    public boolean isBountyHunter() {
        return cursor.getRequired("isBountyHunter", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isCampusExpert() {
        return cursor.getRequired("isCampusExpert", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isDeveloperProgramMember() {
        return cursor.getRequired("isDeveloperProgramMember", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isEmployee() {
        return cursor.getRequired("isEmployee", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isFollowingViewer() {
        return cursor.getRequired("isFollowingViewer", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isGitHubStar() {
        return cursor.getRequired("isGitHubStar", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isHireable() {
        return cursor.getRequired("isHireable", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isSiteAdmin() {
        return cursor.getRequired("isSiteAdmin", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isSponsoredBy(final String accountLogin) {
        requireNonNull(accountLogin, "accountLogin");
        return cursor.getRequired(
                "isSponsoredBy", ScalarType.BOOLEAN, Argument.of("accountLogin", STRING, accountLogin));
    }

    @Override
    public boolean isSponsoringViewer() {
        return cursor.getRequired("isSponsoringViewer", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isViewer() {
        return cursor.getRequired("isViewer", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> issueComments(
            final Paging paging,
            final UserIssueCommentsFilter arguments,
            final Function<IssueCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "issueComments",
                child -> selection.apply(new IssueCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IssueCommentOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> issueComments(final Paging paging, final Function<IssueCommentSelector, R> selection) {
        return issueComments(paging, UserIssueCommentsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> issues(
            final Paging paging, final UserIssuesFilter arguments, final Function<IssueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "issues",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of(
                        "filterBy",
                        "IssueFilters",
                        arguments.filterBy() == null
                                ? null
                                : arguments.filterBy().toVariable()),
                Argument.of("labels", STRING_3, arguments.labels()),
                Argument.of(
                        ORDER_BY,
                        "IssueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(STATES, "[IssueState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> issues(final Paging paging, final Function<IssueSelector, R> selection) {
        return issues(paging, UserIssuesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> R itemShowcase(final Function<ProfileItemShowcaseSelector, R> selection) {
        return cursor.objectRequired(
                "itemShowcase", child -> selection.apply(new ProfileItemShowcaseSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> lifetimeReceivedSponsorshipValues(
            final Paging paging,
            final UserLifetimeReceivedSponsorshipValuesFilter arguments,
            final Function<SponsorAndLifetimeValueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "lifetimeReceivedSponsorshipValues",
                child -> selection.apply(new SponsorAndLifetimeValueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
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
                UserLifetimeReceivedSponsorshipValuesFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> Page<R> lists(final Paging paging, final Function<UserListSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "lists",
                child -> selection.apply(new UserListSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()));
    }

    @Override
    public @Nullable String location() {
        return cursor.get("location", ScalarType.STRING);
    }

    @Override
    public String login() {
        return cursor.getRequired(LOGIN, ScalarType.STRING);
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
    public <R> @Nullable R organization(final String login, final Function<OrganizationSelector, R> selection) {
        requireNonNull(login, LOGIN);
        return cursor.object(
                "organization",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(LOGIN, STRING, login));
    }

    @Override
    public List<String> organizationVerifiedDomainEmails(final String login) {
        requireNonNull(login, LOGIN);
        return cursor.scalarListRequired(
                "organizationVerifiedDomainEmails", ScalarType.STRING, Argument.of(LOGIN, STRING, login));
    }

    @Override
    public <R> Page<R> organizations(
            final Paging paging,
            final UserOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "organizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "OrganizationOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> organizations(final Paging paging, final Function<OrganizationSelector, R> selection) {
        return organizations(paging, UserOrganizationsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> packages(
            final Paging paging, final UserPackagesFilter arguments, final Function<PackageSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "packages",
                child -> selection.apply(new PackageSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
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
        return packages(paging, UserPackagesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> pinnableItems(
            final Paging paging,
            final UserPinnableItemsFilter arguments,
            final Function<PinnableItemSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pinnableItems",
                child -> selection.apply(new PinnableItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("types", "[PinnableItemType!]", arguments.types()));
    }

    @Override
    public <R> Page<R> pinnableItems(final Paging paging, final Function<PinnableItemSelector, R> selection) {
        return pinnableItems(paging, UserPinnableItemsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> pinnedItems(
            final Paging paging,
            final UserPinnedItemsFilter arguments,
            final Function<PinnableItemSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pinnedItems",
                child -> selection.apply(new PinnableItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("types", "[PinnableItemType!]", arguments.types()));
    }

    @Override
    public <R> Page<R> pinnedItems(final Paging paging, final Function<PinnableItemSelector, R> selection) {
        return pinnedItems(paging, UserPinnedItemsFilterBuilder.builder().build(), selection);
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
            final Paging paging, final UserProjectsFilter arguments, final Function<ProjectSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "projects",
                child -> selection.apply(new ProjectSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "ProjectOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("search", STRING_2, arguments.search()),
                Argument.of(STATES, "[ProjectState!]", arguments.states()));
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> projects(final Paging paging, final Function<ProjectSelector, R> selection) {
        return projects(paging, UserProjectsFilterBuilder.builder().build(), selection);
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
            final Paging paging, final UserProjectsV2Filter arguments, final Function<ProjectV2Selector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "projectsV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("minPermissionLevel", "ProjectV2PermissionLevel", arguments.minPermissionLevel()),
                Argument.of(
                        ORDER_BY,
                        "ProjectV2Order",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("query", STRING_2, arguments.query()));
    }

    @Override
    public <R> Page<R> projectsV2(final Paging paging, final Function<ProjectV2Selector, R> selection) {
        return projectsV2(paging, UserProjectsV2FilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable String pronouns() {
        return cursor.get("pronouns", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> publicKeys(final Paging paging, final Function<PublicKeySelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "publicKeys",
                child -> selection.apply(new PublicKeySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()));
    }

    @Override
    public <R> Page<R> pullRequests(
            final Paging paging,
            final UserPullRequestsFilter arguments,
            final Function<PullRequestSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pullRequests",
                child -> selection.apply(new PullRequestSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("baseRefName", STRING_2, arguments.baseRefName()),
                Argument.of("headRefName", STRING_2, arguments.headRefName()),
                Argument.of("labels", STRING_3, arguments.labels()),
                Argument.of(
                        ORDER_BY,
                        "IssueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(STATES, "[PullRequestState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> pullRequests(final Paging paging, final Function<PullRequestSelector, R> selection) {
        return pullRequests(paging, UserPullRequestsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> recentProjects(final Paging paging, final Function<ProjectV2Selector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "recentProjects",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()));
    }

    @Override
    public <R> Page<R> repositories(
            final Paging paging,
            final UserRepositoriesFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositories",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("affiliations", REPOSITORY_AFFILIATION, arguments.affiliations()),
                Argument.of("hasIssuesEnabled", BOOLEAN, arguments.hasIssuesEnabled()),
                Argument.of("isArchived", BOOLEAN, arguments.isArchived()),
                Argument.of("isFork", BOOLEAN, arguments.isFork()),
                Argument.of(IS_LOCKED, BOOLEAN, arguments.isLocked()),
                Argument.of(
                        ORDER_BY,
                        REPOSITORY_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("ownerAffiliations", REPOSITORY_AFFILIATION, arguments.ownerAffiliations()),
                Argument.of(PRIVACY, REPOSITORY_PRIVACY, arguments.privacy()),
                Argument.of("visibility", "RepositoryVisibility", arguments.visibility()));
    }

    @Override
    public <R> Page<R> repositories(final Paging paging, final Function<RepositorySelector, R> selection) {
        return repositories(paging, UserRepositoriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> repositoriesContributedTo(
            final Paging paging,
            final UserRepositoriesContributedToFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositoriesContributedTo",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("contributionTypes", "[RepositoryContributionType]", arguments.contributionTypes()),
                Argument.of("hasIssues", BOOLEAN, arguments.hasIssues()),
                Argument.of("includeUserRepositories", BOOLEAN, arguments.includeUserRepositories()),
                Argument.of(IS_LOCKED, BOOLEAN, arguments.isLocked()),
                Argument.of(
                        ORDER_BY,
                        REPOSITORY_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(PRIVACY, REPOSITORY_PRIVACY, arguments.privacy()));
    }

    @Override
    public <R> Page<R> repositoriesContributedTo(final Paging paging, final Function<RepositorySelector, R> selection) {
        return repositoriesContributedTo(
                paging, UserRepositoriesContributedToFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R repository(
            final String name, final UserRepositoryFilter arguments, final Function<RepositorySelector, R> selection) {
        requireNonNull(name, NAME);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "repository",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of("followRenames", BOOLEAN, arguments.followRenames()),
                Argument.of(NAME, STRING, name));
    }

    @Override
    public <R> @Nullable R repository(final String name, final Function<RepositorySelector, R> selection) {
        return repository(name, UserRepositoryFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> repositoryDiscussionComments(
            final Paging paging,
            final UserRepositoryDiscussionCommentsFilter arguments,
            final Function<DiscussionCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositoryDiscussionComments",
                child -> selection.apply(new DiscussionCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("onlyAnswers", BOOLEAN, arguments.onlyAnswers()),
                Argument.of(REPOSITORY_ID, "ID", arguments.repositoryId()));
    }

    @Override
    public <R> Page<R> repositoryDiscussionComments(
            final Paging paging, final Function<DiscussionCommentSelector, R> selection) {
        return repositoryDiscussionComments(
                paging, UserRepositoryDiscussionCommentsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> repositoryDiscussions(
            final Paging paging,
            final UserRepositoryDiscussionsFilter arguments,
            final Function<DiscussionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositoryDiscussions",
                child -> selection.apply(new DiscussionSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("answered", BOOLEAN, arguments.answered()),
                Argument.of(
                        ORDER_BY,
                        "DiscussionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(REPOSITORY_ID, "ID", arguments.repositoryId()),
                Argument.of(STATES, "[DiscussionState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> repositoryDiscussions(final Paging paging, final Function<DiscussionSelector, R> selection) {
        return repositoryDiscussions(
                paging, UserRepositoryDiscussionsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> savedReplies(
            final Paging paging,
            final UserSavedRepliesFilter arguments,
            final Function<SavedReplySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "savedReplies",
                child -> selection.apply(new SavedReplySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SavedReplyOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> savedReplies(final Paging paging, final Function<SavedReplySelector, R> selection) {
        return savedReplies(paging, UserSavedRepliesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> socialAccounts(final Paging paging, final Function<SocialAccountSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "socialAccounts",
                child -> selection.apply(new SocialAccountSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()));
    }

    @Override
    public <R> Page<R> sponsoring(
            final Paging paging, final UserSponsoringFilter arguments, final Function<SponsorSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsoring",
                child -> selection.apply(new SponsorSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SponsorOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> sponsoring(final Paging paging, final Function<SponsorSelector, R> selection) {
        return sponsoring(paging, UserSponsoringFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> sponsors(
            final Paging paging, final UserSponsorsFilter arguments, final Function<SponsorSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsors",
                child -> selection.apply(new SponsorSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SponsorOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("tierId", "ID", arguments.tierId()));
    }

    @Override
    public <R> Page<R> sponsors(final Paging paging, final Function<SponsorSelector, R> selection) {
        return sponsors(paging, UserSponsorsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> sponsorsActivities(
            final Paging paging,
            final UserSponsorsActivitiesFilter arguments,
            final Function<SponsorsActivitySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorsActivities",
                child -> selection.apply(new SponsorsActivitySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("actions", "[SponsorsActivityAction!]", arguments.actions()),
                Argument.of("includeAsSponsor", BOOLEAN, arguments.includeAsSponsor()),
                Argument.of("includePrivate", BOOLEAN, arguments.includePrivate()),
                Argument.of(
                        ORDER_BY,
                        "SponsorsActivityOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("period", "SponsorsActivityPeriod", arguments.period()),
                Argument.of(SINCE, DATE_TIME, arguments.since()),
                Argument.of("until", DATE_TIME, arguments.until()));
    }

    @Override
    public <R> Page<R> sponsorsActivities(final Paging paging, final Function<SponsorsActivitySelector, R> selection) {
        return sponsorsActivities(
                paging, UserSponsorsActivitiesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R sponsorsListing(final Function<SponsorsListingSelector, R> selection) {
        return cursor.object("sponsorsListing", child -> selection.apply(new SponsorsListingSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R sponsorshipForViewerAsSponsor(
            final UserSponsorshipForViewerAsSponsorFilter arguments, final Function<SponsorshipSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "sponsorshipForViewerAsSponsor",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of(ACTIVE_ONLY, BOOLEAN, arguments.activeOnly()));
    }

    @Override
    public <R> @Nullable R sponsorshipForViewerAsSponsor(final Function<SponsorshipSelector, R> selection) {
        return sponsorshipForViewerAsSponsor(
                UserSponsorshipForViewerAsSponsorFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R sponsorshipForViewerAsSponsorable(
            final UserSponsorshipForViewerAsSponsorableFilter arguments,
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
                UserSponsorshipForViewerAsSponsorableFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> sponsorshipNewsletters(
            final Paging paging,
            final UserSponsorshipNewslettersFilter arguments,
            final Function<SponsorshipNewsletterSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorshipNewsletters",
                child -> selection.apply(new SponsorshipNewsletterSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SponsorshipNewsletterOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> sponsorshipNewsletters(
            final Paging paging, final Function<SponsorshipNewsletterSelector, R> selection) {
        return sponsorshipNewsletters(
                paging, UserSponsorshipNewslettersFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> sponsorshipsAsMaintainer(
            final Paging paging,
            final UserSponsorshipsAsMaintainerFilter arguments,
            final Function<SponsorshipSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorshipsAsMaintainer",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
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
                paging, UserSponsorshipsAsMaintainerFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> sponsorshipsAsSponsor(
            final Paging paging,
            final UserSponsorshipsAsSponsorFilter arguments,
            final Function<SponsorshipSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorshipsAsSponsor",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
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
                paging, UserSponsorshipsAsSponsorFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> starredRepositories(
            final Paging paging,
            final UserStarredRepositoriesFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "starredRepositories",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "StarOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("ownedByViewer", BOOLEAN, arguments.ownedByViewer()));
    }

    @Override
    public <R> Page<R> starredRepositories(final Paging paging, final Function<RepositorySelector, R> selection) {
        return starredRepositories(
                paging, UserStarredRepositoriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R status(final Function<UserStatusSelector, R> selection) {
        return cursor.object("status", child -> selection.apply(new UserStatusSelectorImpl(child)));
    }

    @Override
    public <R> List<R> suggestedListNames(final Function<UserListSuggestionSelector, R> selection) {
        return cursor.listRequired(
                "suggestedListNames", child -> selection.apply(new UserListSuggestionSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> topRepositories(
            final RepositoryOrder orderBy,
            final Paging paging,
            final UserTopRepositoriesFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(orderBy, ORDER_BY);
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "topRepositories",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of(ORDER_BY, "RepositoryOrder!", orderBy.toVariable()),
                Argument.of(SINCE, DATE_TIME, arguments.since()));
    }

    @Override
    public <R> Page<R> topRepositories(
            final RepositoryOrder orderBy, final Paging paging, final Function<RepositorySelector, R> selection) {
        return topRepositories(
                orderBy, paging, UserTopRepositoriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable Integer totalSponsorshipAmountAsSponsorInCents(
            final UserTotalSponsorshipAmountAsSponsorInCentsFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.get(
                "totalSponsorshipAmountAsSponsorInCents",
                ScalarType.INT,
                Argument.of(SINCE, DATE_TIME, arguments.since()),
                Argument.of("sponsorableLogins", STRING_3, arguments.sponsorableLogins()),
                Argument.of("until", DATE_TIME, arguments.until()));
    }

    @Override
    public @Nullable Integer totalSponsorshipAmountAsSponsorInCents() {
        return totalSponsorshipAmountAsSponsorInCents(UserTotalSponsorshipAmountAsSponsorInCentsFilterBuilder.builder()
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
    public UserViewType userViewType() {
        return cursor.getRequired("userViewType", ScalarType.enumeration(UserViewType::fromWire, UserViewType.PRIVATE));
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
    public boolean viewerCanFollow() {
        return cursor.getRequired("viewerCanFollow", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanSponsor() {
        return cursor.getRequired("viewerCanSponsor", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String viewerCopilotAgentCreatesChannel() {
        return cursor.get("viewerCopilotAgentCreatesChannel", ScalarType.STRING);
    }

    @Override
    public @Nullable String viewerCopilotAgentLogUpdatesChannel() {
        return cursor.get("viewerCopilotAgentLogUpdatesChannel", ScalarType.STRING);
    }

    @Override
    public @Nullable String viewerCopilotAgentTaskUpdatesChannel() {
        return cursor.get("viewerCopilotAgentTaskUpdatesChannel", ScalarType.STRING);
    }

    @Override
    public @Nullable String viewerCopilotAgentUpdatesChannel() {
        return cursor.get("viewerCopilotAgentUpdatesChannel", ScalarType.STRING);
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
    public <R> Page<R> watching(
            final Paging paging, final UserWatchingFilter arguments, final Function<RepositorySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "watching",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING_2, paging.after()),
                Argument.of("affiliations", REPOSITORY_AFFILIATION, arguments.affiliations()),
                Argument.of("hasIssuesEnabled", BOOLEAN, arguments.hasIssuesEnabled()),
                Argument.of(IS_LOCKED, BOOLEAN, arguments.isLocked()),
                Argument.of(
                        ORDER_BY,
                        REPOSITORY_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("ownerAffiliations", REPOSITORY_AFFILIATION, arguments.ownerAffiliations()),
                Argument.of(PRIVACY, REPOSITORY_PRIVACY, arguments.privacy()),
                Argument.of("visibility", "RepositoryVisibility", arguments.visibility()));
    }

    @Override
    public <R> Page<R> watching(final Paging paging, final Function<RepositorySelector, R> selection) {
        return watching(paging, UserWatchingFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable String websiteUrl() {
        return cursor.get("websiteUrl", ScalarType.STRING);
    }
}
