package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CopilotEndpointsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionState;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMembershipType;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.GistOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.GistPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.GistSelector;
import io.github.piotr_janczukowicz.github.graphql.model.HovercardContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFiltersBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PackageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageType;
import io.github.piotr_janczukowicz.github.graphql.model.PinnableItemType;
import io.github.piotr_janczukowicz.github.graphql.model.ProfileItemShowcaseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectState;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2PermissionLevel;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.PublicKeySelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestState;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryAffiliation;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryContributionType;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInteractionAbilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVisibility;
import io.github.piotr_janczukowicz.github.graphql.model.SavedReplyOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SavedReplyOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SavedReplySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SocialAccountSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityAction;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityPeriod;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StarOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.StarOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.UserAnyPinnableItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserContributionsCollectionFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserEnterprisesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserGistsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserHovercardFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserIssueCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserLifetimeReceivedSponsorshipValuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserListSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserListSuggestionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserPackagesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserPinnableItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserPinnedItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserProjectsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoriesContributedToFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoryDiscussionCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoryDiscussionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSavedRepliesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsoringFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorsActivitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipForViewerAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipForViewerAsSponsorableFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipNewslettersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipsAsMaintainerFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSponsorshipsAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserStarredRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserTopRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserTotalSponsorshipAmountAsSponsorInCentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserViewType;
import io.github.piotr_janczukowicz.github.graphql.model.UserWatchingFilterBuilder;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class UserSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"anyPinnableItems\":true" + "," + "\"avatarUrl\":\"x\"" + ","
            + "\"bio\":\"x\"" + "," + "\"bioHTML\":\"x\"" + ","
            + "\"canReceiveOrganizationEmailsWhenNotificationsRestricted\":true" + ","
            + "\"commitComments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"company\":\"x\"" + "," + "\"companyHTML\":\"x\"" + ","
            + "\"contributionsCollection\":{\"contributionYears\": [1]}" + "," + "\"copilotEndpoints\":{\"api\": \"x\"}"
            + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1" + "," + "\"email\":\"x\"" + ","
            + "\"enterprises\":{\"nodes\": [{\"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"estimatedNextSponsorsPayoutInCents\":1" + ","
            + "\"followers\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"following\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"gist\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"gistComments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"gists\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"hasSponsorsListing\":true" + "," + "\"hovercard\":{\"contexts\": [{\"message\": \"x\"}]}" + ","
            + "\"id\":\"x\"" + "," + "\"interactionAbility\":{\"expiresAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"isBountyHunter\":true" + "," + "\"isCampusExpert\":true" + "," + "\"isDeveloperProgramMember\":true"
            + "," + "\"isEmployee\":true" + "," + "\"isFollowingViewer\":true" + "," + "\"isGitHubStar\":true" + ","
            + "\"isHireable\":true" + "," + "\"isSiteAdmin\":true" + "," + "\"isSponsoredBy\":true" + ","
            + "\"isSponsoringViewer\":true" + "," + "\"isViewer\":true" + ","
            + "\"issueComments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"issues\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"itemShowcase\":{\"hasPinnedItems\": true}" + ","
            + "\"lifetimeReceivedSponsorshipValues\":{\"nodes\": [{\"amountInCents\": 1}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"lists\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"location\":\"x\"" + "," + "\"login\":\"x\"" + "," + "\"monthlyEstimatedSponsorsIncomeInCents\":1"
            + "," + "\"name\":\"x\"" + "," + "\"organization\":{\"anyPinnableItems\": true}" + ","
            + "\"organizationVerifiedDomainEmails\":[\"x\"]" + ","
            + "\"organizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"packages\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pinnableItems\":{\"nodes\": [{\"__typename\": \"Gist\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pinnedItems\":{\"nodes\": [{\"__typename\": \"Gist\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"pinnedItemsRemaining\":1" + "," + "\"project\":{\"closed\": true}" + ","
            + "\"projectV2\":{\"closed\": true}" + ","
            + "\"projects\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"projectsResourcePath\":\"x\"" + "," + "\"projectsUrl\":\"x\"" + ","
            + "\"projectsV2\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"pronouns\":\"x\"" + ","
            + "\"publicKeys\":{\"nodes\": [{\"accessedAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pullRequests\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"recentProjects\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"repositories\":{\"nodes\": [{\"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"repositoriesContributedTo\":{\"nodes\": [{\"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + ","
            + "\"repositoryDiscussionComments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"repositoryDiscussions\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"resourcePath\":\"x\"" + ","
            + "\"savedReplies\":{\"nodes\": [{\"body\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"socialAccounts\":{\"nodes\": [{\"displayName\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsoring\":{\"nodes\": [{\"__typename\": \"Organization\", \"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsors\":{\"nodes\": [{\"__typename\": \"Organization\", \"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsorsActivities\":{\"nodes\": [{\"action\": \"CANCELLED_SPONSORSHIP\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"sponsorsListing\":{\"billingCountryOrRegion\": \"x\"}" + ","
            + "\"sponsorshipForViewerAsSponsor\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"sponsorshipForViewerAsSponsorable\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"sponsorshipNewsletters\":{\"nodes\": [{\"body\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsorshipsAsMaintainer\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsorshipsAsSponsor\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"starredRepositories\":{\"nodes\": [{\"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"status\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"suggestedListNames\":[{\"id\": \"x\"}]" + ","
            + "\"topRepositories\":{\"nodes\": [{\"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"totalSponsorshipAmountAsSponsorInCents\":1" + "," + "\"twitterUsername\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "," + "\"userViewType\":\"PRIVATE\""
            + "," + "\"viewerCanChangePinnedItems\":true" + "," + "\"viewerCanCreateProjects\":true" + ","
            + "\"viewerCanFollow\":true" + "," + "\"viewerCanSponsor\":true" + ","
            + "\"viewerCopilotAgentCreatesChannel\":\"x\"" + "," + "\"viewerCopilotAgentLogUpdatesChannel\":\"x\"" + ","
            + "\"viewerCopilotAgentTaskUpdatesChannel\":\"x\"" + "," + "\"viewerCopilotAgentUpdatesChannel\":\"x\""
            + "," + "\"viewerIsFollowing\":true" + "," + "\"viewerIsSponsoring\":true" + ","
            + "\"watching\":{\"nodes\": [{\"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"websiteUrl\":\"x\"" + "}";

    private static List<Object> readWithArguments(final UserSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.anyPinnableItems(UserAnyPinnableItemsFilterBuilder.builder()
                .type(PinnableItemType.GIST)
                .build()));
        values.add(
                selector.avatarUrl(UserAvatarUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.bio());
        values.add(selector.bioHTML());
        values.add(selector.canReceiveOrganizationEmailsWhenNotificationsRestricted("x"));
        values.add(selector.commitComments(Paging.first(1), CommitCommentSelector::authorAssociation));
        values.add(selector.company());
        values.add(selector.companyHTML());
        values.add(selector.contributionsCollection(
                UserContributionsCollectionFilterBuilder.builder()
                        .from(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .organizationID("x")
                        .to(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build(),
                ContributionsCollectionSelector::contributionYears));
        values.add(selector.copilotEndpoints(CopilotEndpointsSelector::api));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.email());
        values.add(selector.enterprises(
                Paging.first(1),
                UserEnterprisesFilterBuilder.builder()
                        .membershipType(EnterpriseMembershipType.ADMIN)
                        .orderBy(EnterpriseOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseOrderField.NAME)
                                .build())
                        .build(),
                EnterpriseSelector::avatarUrl));
        values.add(selector.estimatedNextSponsorsPayoutInCents());
        values.add(selector.followers(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.following(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.gist("x", GistSelector::createdAt));
        values.add(selector.gistComments(Paging.first(1), GistCommentSelector::authorAssociation));
        values.add(selector.gists(
                Paging.first(1),
                UserGistsFilterBuilder.builder()
                        .orderBy(GistOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(GistOrderField.CREATED_AT)
                                .build())
                        .privacy(GistPrivacy.ALL)
                        .build(),
                GistSelector::createdAt));
        values.add(selector.hasSponsorsListing());
        values.add(selector.hovercard(
                UserHovercardFilterBuilder.builder().primarySubjectId("x").build(),
                child -> child.contexts(HovercardContextSelector::message)));
        values.add(selector.id());
        values.add(selector.interactionAbility(RepositoryInteractionAbilitySelector::expiresAt));
        values.add(selector.isBountyHunter());
        values.add(selector.isCampusExpert());
        values.add(selector.isDeveloperProgramMember());
        values.add(selector.isEmployee());
        values.add(selector.isFollowingViewer());
        values.add(selector.isGitHubStar());
        values.add(selector.isHireable());
        values.add(selector.isSiteAdmin());
        values.add(selector.isSponsoredBy("x"));
        values.add(selector.isSponsoringViewer());
        values.add(selector.isViewer());
        values.add(selector.issueComments(
                Paging.first(1),
                UserIssueCommentsFilterBuilder.builder()
                        .orderBy(IssueCommentOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueCommentOrderField.UPDATED_AT)
                                .build())
                        .build(),
                IssueCommentSelector::authorAssociation));
        values.add(selector.issues(
                Paging.first(1),
                UserIssuesFilterBuilder.builder()
                        .filterBy(IssueFiltersBuilder.builder().build())
                        .labels(List.of("x"))
                        .orderBy(IssueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueOrderField.COMMENTS)
                                .build())
                        .states(List.of(IssueState.CLOSED))
                        .build(),
                IssueSelector::activeLockReason));
        values.add(selector.itemShowcase(ProfileItemShowcaseSelector::hasPinnedItems));
        values.add(selector.lifetimeReceivedSponsorshipValues(
                Paging.first(1),
                UserLifetimeReceivedSponsorshipValuesFilterBuilder.builder()
                        .orderBy(SponsorAndLifetimeValueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorAndLifetimeValueOrderField.LIFETIME_VALUE)
                                .build())
                        .build(),
                SponsorAndLifetimeValueSelector::amountInCents));
        values.add(selector.lists(Paging.first(1), UserListSelector::createdAt));
        values.add(selector.location());
        values.add(selector.login());
        values.add(selector.monthlyEstimatedSponsorsIncomeInCents());
        values.add(selector.name());
        values.add(selector.organization("x", OrganizationSelector::anyPinnableItems));
        values.add(selector.organizationVerifiedDomainEmails("x"));
        values.add(selector.organizations(
                Paging.first(1),
                UserOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.packages(
                Paging.first(1),
                UserPackagesFilterBuilder.builder()
                        .names(List.of("x"))
                        .orderBy(PackageOrderBuilder.builder().build())
                        .packageType(PackageType.DEBIAN)
                        .repositoryId("x")
                        .build(),
                PackageSelector::id));
        values.add(selector.pinnableItems(
                Paging.first(1),
                UserPinnableItemsFilterBuilder.builder()
                        .types(List.of(PinnableItemType.GIST))
                        .build(),
                child -> child.on(GistSelector.class, GistSelector::createdAt)));
        values.add(selector.pinnedItems(
                Paging.first(1),
                UserPinnedItemsFilterBuilder.builder()
                        .types(List.of(PinnableItemType.GIST))
                        .build(),
                child -> child.on(GistSelector.class, GistSelector::createdAt)));
        values.add(selector.pinnedItemsRemaining());
        values.add(selector.project(1, ProjectSelector::closed));
        values.add(selector.projectV2(1, ProjectV2Selector::closed));
        values.add(selector.projects(
                Paging.first(1),
                UserProjectsFilterBuilder.builder()
                        .orderBy(ProjectOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectOrderField.CREATED_AT)
                                .build())
                        .search("x")
                        .states(List.of(ProjectState.CLOSED))
                        .build(),
                ProjectSelector::closed));
        values.add(selector.projectsResourcePath());
        values.add(selector.projectsUrl());
        values.add(selector.projectsV2(
                Paging.first(1),
                UserProjectsV2FilterBuilder.builder()
                        .minPermissionLevel(ProjectV2PermissionLevel.ADMIN)
                        .orderBy(ProjectV2OrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2OrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                ProjectV2Selector::closed));
        values.add(selector.pronouns());
        values.add(selector.publicKeys(Paging.first(1), PublicKeySelector::accessedAt));
        values.add(selector.pullRequests(
                Paging.first(1),
                UserPullRequestsFilterBuilder.builder()
                        .baseRefName("x")
                        .headRefName("x")
                        .labels(List.of("x"))
                        .orderBy(IssueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueOrderField.COMMENTS)
                                .build())
                        .states(List.of(PullRequestState.CLOSED))
                        .build(),
                PullRequestSelector::activeLockReason));
        values.add(selector.recentProjects(Paging.first(1), ProjectV2Selector::closed));
        values.add(selector.repositories(
                Paging.first(1),
                UserRepositoriesFilterBuilder.builder()
                        .affiliations(List.of(RepositoryAffiliation.COLLABORATOR))
                        .hasIssuesEnabled(true)
                        .isArchived(true)
                        .isFork(true)
                        .isLocked(true)
                        .orderBy(RepositoryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(RepositoryOrderField.CREATED_AT)
                                .build())
                        .ownerAffiliations(List.of(RepositoryAffiliation.COLLABORATOR))
                        .privacy(RepositoryPrivacy.PRIVATE)
                        .visibility(RepositoryVisibility.INTERNAL)
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.repositoriesContributedTo(
                Paging.first(1),
                UserRepositoriesContributedToFilterBuilder.builder()
                        .contributionTypes(List.of(RepositoryContributionType.COMMIT))
                        .hasIssues(true)
                        .includeUserRepositories(true)
                        .isLocked(true)
                        .orderBy(RepositoryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(RepositoryOrderField.CREATED_AT)
                                .build())
                        .privacy(RepositoryPrivacy.PRIVATE)
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.repository(
                "x",
                UserRepositoryFilterBuilder.builder().followRenames(true).build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.repositoryDiscussionComments(
                Paging.first(1),
                UserRepositoryDiscussionCommentsFilterBuilder.builder()
                        .onlyAnswers(true)
                        .repositoryId("x")
                        .build(),
                DiscussionCommentSelector::authorAssociation));
        values.add(selector.repositoryDiscussions(
                Paging.first(1),
                UserRepositoryDiscussionsFilterBuilder.builder()
                        .answered(true)
                        .orderBy(DiscussionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(DiscussionOrderField.CREATED_AT)
                                .build())
                        .repositoryId("x")
                        .states(List.of(DiscussionState.CLOSED))
                        .build(),
                DiscussionSelector::activeLockReason));
        values.add(selector.resourcePath());
        values.add(selector.savedReplies(
                Paging.first(1),
                UserSavedRepliesFilterBuilder.builder()
                        .orderBy(SavedReplyOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SavedReplyOrderField.UPDATED_AT)
                                .build())
                        .build(),
                SavedReplySelector::body));
        values.add(selector.socialAccounts(Paging.first(1), SocialAccountSelector::displayName));
        values.add(selector.sponsoring(
                Paging.first(1),
                UserSponsoringFilterBuilder.builder()
                        .orderBy(SponsorOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorOrderField.LOGIN)
                                .build())
                        .build(),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsors(
                Paging.first(1),
                UserSponsorsFilterBuilder.builder()
                        .orderBy(SponsorOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorOrderField.LOGIN)
                                .build())
                        .tierId("x")
                        .build(),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsorsActivities(
                Paging.first(1),
                UserSponsorsActivitiesFilterBuilder.builder()
                        .actions(List.of(SponsorsActivityAction.CANCELLED_SPONSORSHIP))
                        .includeAsSponsor(true)
                        .includePrivate(true)
                        .orderBy(SponsorsActivityOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorsActivityOrderField.TIMESTAMP)
                                .build())
                        .period(SponsorsActivityPeriod.ALL)
                        .since(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .until(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build(),
                SponsorsActivitySelector::action));
        values.add(selector.sponsorsListing(SponsorsListingSelector::billingCountryOrRegion));
        values.add(selector.sponsorshipForViewerAsSponsor(
                UserSponsorshipForViewerAsSponsorFilterBuilder.builder()
                        .activeOnly(true)
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipForViewerAsSponsorable(
                UserSponsorshipForViewerAsSponsorableFilterBuilder.builder()
                        .activeOnly(true)
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipNewsletters(
                Paging.first(1),
                UserSponsorshipNewslettersFilterBuilder.builder()
                        .orderBy(SponsorshipNewsletterOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorshipNewsletterOrderField.CREATED_AT)
                                .build())
                        .build(),
                SponsorshipNewsletterSelector::body));
        values.add(selector.sponsorshipsAsMaintainer(
                Paging.first(1),
                UserSponsorshipsAsMaintainerFilterBuilder.builder()
                        .activeOnly(true)
                        .includePrivate(true)
                        .orderBy(SponsorshipOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorshipOrderField.CREATED_AT)
                                .build())
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipsAsSponsor(
                Paging.first(1),
                UserSponsorshipsAsSponsorFilterBuilder.builder()
                        .activeOnly(true)
                        .maintainerLogins(List.of("x"))
                        .orderBy(SponsorshipOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorshipOrderField.CREATED_AT)
                                .build())
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.starredRepositories(
                Paging.first(1),
                UserStarredRepositoriesFilterBuilder.builder()
                        .orderBy(StarOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(StarOrderField.STARRED_AT)
                                .build())
                        .ownedByViewer(true)
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.status(UserStatusSelector::createdAt));
        values.add(selector.suggestedListNames(UserListSuggestionSelector::id));
        values.add(selector.topRepositories(
                RepositoryOrderBuilder.builder()
                        .direction(OrderDirection.ASC)
                        .field(RepositoryOrderField.CREATED_AT)
                        .build(),
                Paging.first(1),
                UserTopRepositoriesFilterBuilder.builder()
                        .since(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.totalSponsorshipAmountAsSponsorInCents(
                UserTotalSponsorshipAmountAsSponsorInCentsFilterBuilder.builder()
                        .since(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .sponsorableLogins(List.of("x"))
                        .until(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build()));
        values.add(selector.twitterUsername());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.userViewType());
        values.add(selector.viewerCanChangePinnedItems());
        values.add(selector.viewerCanCreateProjects());
        values.add(selector.viewerCanFollow());
        values.add(selector.viewerCanSponsor());
        values.add(selector.viewerCopilotAgentCreatesChannel());
        values.add(selector.viewerCopilotAgentLogUpdatesChannel());
        values.add(selector.viewerCopilotAgentTaskUpdatesChannel());
        values.add(selector.viewerCopilotAgentUpdatesChannel());
        values.add(selector.viewerIsFollowing());
        values.add(selector.viewerIsSponsoring());
        values.add(selector.watching(
                Paging.first(1),
                UserWatchingFilterBuilder.builder()
                        .affiliations(List.of(RepositoryAffiliation.COLLABORATOR))
                        .hasIssuesEnabled(true)
                        .isLocked(true)
                        .orderBy(RepositoryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(RepositoryOrderField.CREATED_AT)
                                .build())
                        .ownerAffiliations(List.of(RepositoryAffiliation.COLLABORATOR))
                        .privacy(RepositoryPrivacy.PRIVATE)
                        .visibility(RepositoryVisibility.INTERNAL)
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.websiteUrl());
        return values;
    }

    private static List<Object> readWithoutArguments(final UserSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.anyPinnableItems());
        values.add(selector.avatarUrl());
        values.add(selector.contributionsCollection(ContributionsCollectionSelector::contributionYears));
        values.add(selector.enterprises(Paging.first(1), EnterpriseSelector::avatarUrl));
        values.add(selector.gists(Paging.first(1), GistSelector::createdAt));
        values.add(selector.hovercard(child -> child.contexts(HovercardContextSelector::message)));
        values.add(selector.issueComments(Paging.first(1), IssueCommentSelector::authorAssociation));
        values.add(selector.issues(Paging.first(1), IssueSelector::activeLockReason));
        values.add(selector.lifetimeReceivedSponsorshipValues(
                Paging.first(1), SponsorAndLifetimeValueSelector::amountInCents));
        values.add(selector.organizations(Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.packages(Paging.first(1), PackageSelector::id));
        values.add(selector.pinnableItems(
                Paging.first(1), child -> child.on(GistSelector.class, GistSelector::createdAt)));
        values.add(
                selector.pinnedItems(Paging.first(1), child -> child.on(GistSelector.class, GistSelector::createdAt)));
        values.add(selector.projects(Paging.first(1), ProjectSelector::closed));
        values.add(selector.projectsV2(Paging.first(1), ProjectV2Selector::closed));
        values.add(selector.pullRequests(Paging.first(1), PullRequestSelector::activeLockReason));
        values.add(selector.repositories(Paging.first(1), RepositorySelector::allowUpdateBranch));
        values.add(selector.repositoriesContributedTo(Paging.first(1), RepositorySelector::allowUpdateBranch));
        values.add(selector.repository("x", RepositorySelector::allowUpdateBranch));
        values.add(
                selector.repositoryDiscussionComments(Paging.first(1), DiscussionCommentSelector::authorAssociation));
        values.add(selector.repositoryDiscussions(Paging.first(1), DiscussionSelector::activeLockReason));
        values.add(selector.savedReplies(Paging.first(1), SavedReplySelector::body));
        values.add(selector.sponsoring(
                Paging.first(1),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsors(
                Paging.first(1),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsorsActivities(Paging.first(1), SponsorsActivitySelector::action));
        values.add(selector.sponsorshipForViewerAsSponsor(SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipForViewerAsSponsorable(SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipNewsletters(Paging.first(1), SponsorshipNewsletterSelector::body));
        values.add(selector.sponsorshipsAsMaintainer(Paging.first(1), SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipsAsSponsor(Paging.first(1), SponsorshipSelector::createdAt));
        values.add(selector.starredRepositories(Paging.first(1), RepositorySelector::allowUpdateBranch));
        values.add(selector.topRepositories(
                RepositoryOrderBuilder.builder()
                        .direction(OrderDirection.ASC)
                        .field(RepositoryOrderField.CREATED_AT)
                        .build(),
                Paging.first(1),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.totalSponsorshipAmountAsSponsorInCents());
        values.add(selector.watching(Paging.first(1), RepositorySelector::allowUpdateBranch));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UserSelectorImpl(new RecordingCursor(root)));
        final UserSelectorImpl selector = new UserSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        "x",
                        "x",
                        "x",
                        true,
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        "x",
                        "x",
                        List.of(1),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        "x",
                        new Page<>(List.of("x"), false, null),
                        1,
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        true,
                        List.of("x"),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
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
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        true,
                        new Page<>(List.of(1), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        "x",
                        1,
                        "x",
                        true,
                        List.of("x"),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        1,
                        true,
                        true,
                        new Page<>(List.of(true), false, null),
                        "x",
                        "x",
                        new Page<>(List.of(true), false, null),
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        true,
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(SponsorsActivityAction.CANCELLED_SPONSORSHIP), false, null),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        List.of("x"),
                        new Page<>(List.of(true), false, null),
                        1,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        UserViewType.PRIVATE,
                        true,
                        true,
                        true,
                        true,
                        "x",
                        "x",
                        "x",
                        "x",
                        true,
                        true,
                        new Page<>(List.of(true), false, null),
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new UserSelectorImpl(new RecordingCursor(root)));
        final UserSelectorImpl selector = new UserSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        "x",
                        List.of(1),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        List.of("x"),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(1), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        true,
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(SponsorsActivityAction.CANCELLED_SPONSORSHIP), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        1,
                        new Page<>(List.of(true), false, null));
    }
}
