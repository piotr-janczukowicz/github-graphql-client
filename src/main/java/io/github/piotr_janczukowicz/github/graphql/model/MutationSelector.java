package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Mutation}. */
public interface MutationSelector {

    <R> @Nullable R abortQueuedMigrations(
            AbortQueuedMigrationsPayload input, Function<AbortQueuedMigrationsPayloadSelector, R> selection);

    <R> @Nullable R abortRepositoryMigration(
            AbortRepositoryMigrationPayload input, Function<AbortRepositoryMigrationPayloadSelector, R> selection);

    <R> @Nullable R acceptEnterpriseAdministratorInvitation(
            AcceptEnterpriseAdministratorInvitationPayload input,
            Function<AcceptEnterpriseAdministratorInvitationPayloadSelector, R> selection);

    <R> @Nullable R acceptEnterpriseMemberInvitation(
            AcceptEnterpriseMemberInvitationPayload input,
            Function<AcceptEnterpriseMemberInvitationPayloadSelector, R> selection);

    <R> @Nullable R acceptTopicSuggestion(
            AcceptTopicSuggestionPayload input, Function<AcceptTopicSuggestionPayloadSelector, R> selection);

    <R> @Nullable R accessUserNamespaceRepository(
            AccessUserNamespaceRepositoryPayload input,
            Function<AccessUserNamespaceRepositoryPayloadSelector, R> selection);

    <R> @Nullable R addAssigneesToAssignable(
            AddAssigneesToAssignablePayload input, Function<AddAssigneesToAssignablePayloadSelector, R> selection);

    <R> @Nullable R addBlockedBy(AddBlockedByPayload input, Function<AddBlockedByPayloadSelector, R> selection);

    <R> @Nullable R addCloseIssueReferences(
            AddCloseIssueReferencesPayload input, Function<AddCloseIssueReferencesPayloadSelector, R> selection);

    <R> @Nullable R addComment(AddCommentPayload input, Function<AddCommentPayloadSelector, R> selection);

    <R> @Nullable R addDiscussionComment(
            AddDiscussionCommentPayload input, Function<AddDiscussionCommentPayloadSelector, R> selection);

    <R> @Nullable R addDiscussionPollVote(
            AddDiscussionPollVotePayload input, Function<AddDiscussionPollVotePayloadSelector, R> selection);

    <R> @Nullable R addEnterpriseOrganizationMember(
            AddEnterpriseOrganizationMemberPayload input,
            Function<AddEnterpriseOrganizationMemberPayloadSelector, R> selection);

    <R> @Nullable R addEnterpriseSupportEntitlement(
            AddEnterpriseSupportEntitlementPayload input,
            Function<AddEnterpriseSupportEntitlementPayloadSelector, R> selection);

    <R> @Nullable R addLabelsToLabelable(
            AddLabelsToLabelablePayload input, Function<AddLabelsToLabelablePayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R addProjectCard(AddProjectCardPayload input, Function<AddProjectCardPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R addProjectColumn(
            AddProjectColumnPayload input, Function<AddProjectColumnPayloadSelector, R> selection);

    <R> @Nullable R addProjectV2DraftIssue(
            AddProjectV2DraftIssuePayload input, Function<AddProjectV2DraftIssuePayloadSelector, R> selection);

    <R> @Nullable R addProjectV2ItemById(
            AddProjectV2ItemByIdPayload input, Function<AddProjectV2ItemByIdPayloadSelector, R> selection);

    <R> @Nullable R addPullRequestCreationCapBypassUsers(
            AddPullRequestCreationCapBypassUsersPayload input,
            Function<AddPullRequestCreationCapBypassUsersPayloadSelector, R> selection);

    <R> @Nullable R addPullRequestReview(
            AddPullRequestReviewPayload input, Function<AddPullRequestReviewPayloadSelector, R> selection);

    <R> @Nullable R addPullRequestReviewComment(
            AddPullRequestReviewCommentPayload input,
            Function<AddPullRequestReviewCommentPayloadSelector, R> selection);

    <R> @Nullable R addPullRequestReviewThread(
            AddPullRequestReviewThreadPayload input, Function<AddPullRequestReviewThreadPayloadSelector, R> selection);

    <R> @Nullable R addPullRequestReviewThreadReply(
            AddPullRequestReviewThreadReplyPayload input,
            Function<AddPullRequestReviewThreadReplyPayloadSelector, R> selection);

    <R> @Nullable R addReaction(AddReactionPayload input, Function<AddReactionPayloadSelector, R> selection);

    <R> @Nullable R addRelatesTo(AddRelatesToPayload input, Function<AddRelatesToPayloadSelector, R> selection);

    <R> @Nullable R addStar(AddStarPayload input, Function<AddStarPayloadSelector, R> selection);

    <R> @Nullable R addSubIssue(AddSubIssuePayload input, Function<AddSubIssuePayloadSelector, R> selection);

    <R> @Nullable R addUpvote(AddUpvotePayload input, Function<AddUpvotePayloadSelector, R> selection);

    <R> @Nullable R addVerifiableDomain(
            AddVerifiableDomainPayload input, Function<AddVerifiableDomainPayloadSelector, R> selection);

    <R> @Nullable R applyPendingIssueSuggestions(
            ApplyPendingIssueSuggestionsPayload input,
            Function<ApplyPendingIssueSuggestionsPayloadSelector, R> selection);

    <R> @Nullable R approveDeployments(
            ApproveDeploymentsPayload input, Function<ApproveDeploymentsPayloadSelector, R> selection);

    <R> @Nullable R approveVerifiableDomain(
            ApproveVerifiableDomainPayload input, Function<ApproveVerifiableDomainPayloadSelector, R> selection);

    <R> @Nullable R archiveProjectV2Item(
            ArchiveProjectV2ItemPayload input, Function<ArchiveProjectV2ItemPayloadSelector, R> selection);

    <R> @Nullable R archivePullRequest(
            ArchivePullRequestPayload input, Function<ArchivePullRequestPayloadSelector, R> selection);

    <R> @Nullable R archiveRepository(
            ArchiveRepositoryPayload input, Function<ArchiveRepositoryPayloadSelector, R> selection);

    <R> @Nullable R cancelEnterpriseAdminInvitation(
            CancelEnterpriseAdminInvitationPayload input,
            Function<CancelEnterpriseAdminInvitationPayloadSelector, R> selection);

    <R> @Nullable R cancelEnterpriseMemberInvitation(
            CancelEnterpriseMemberInvitationPayload input,
            Function<CancelEnterpriseMemberInvitationPayloadSelector, R> selection);

    <R> @Nullable R cancelSponsorship(
            CancelSponsorshipPayload input, Function<CancelSponsorshipPayloadSelector, R> selection);

    <R> @Nullable R changeUserStatus(
            ChangeUserStatusPayload input, Function<ChangeUserStatusPayloadSelector, R> selection);

    <R> @Nullable R clearLabelsFromLabelable(
            ClearLabelsFromLabelablePayload input, Function<ClearLabelsFromLabelablePayloadSelector, R> selection);

    <R> @Nullable R clearProjectV2ItemFieldValue(
            ClearProjectV2ItemFieldValuePayload input,
            Function<ClearProjectV2ItemFieldValuePayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R cloneProject(CloneProjectPayload input, Function<CloneProjectPayloadSelector, R> selection);

    <R> @Nullable R cloneTemplateRepository(
            CloneTemplateRepositoryPayload input, Function<CloneTemplateRepositoryPayloadSelector, R> selection);

    <R> @Nullable R closeDiscussion(
            CloseDiscussionPayload input, Function<CloseDiscussionPayloadSelector, R> selection);

    <R> @Nullable R closeIssue(CloseIssuePayload input, Function<CloseIssuePayloadSelector, R> selection);

    <R> @Nullable R closePullRequest(
            ClosePullRequestPayload input, Function<ClosePullRequestPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R convertProjectCardNoteToIssue(
            ConvertProjectCardNoteToIssuePayload input,
            Function<ConvertProjectCardNoteToIssuePayloadSelector, R> selection);

    <R> @Nullable R convertProjectV2DraftIssueItemToIssue(
            ConvertProjectV2DraftIssueItemToIssuePayload input,
            Function<ConvertProjectV2DraftIssueItemToIssuePayloadSelector, R> selection);

    <R> @Nullable R convertPullRequestToDraft(
            ConvertPullRequestToDraftPayload input, Function<ConvertPullRequestToDraftPayloadSelector, R> selection);

    <R> @Nullable R copyProjectV2(CopyProjectV2Payload input, Function<CopyProjectV2PayloadSelector, R> selection);

    <R> @Nullable R createAttributionInvitation(
            CreateAttributionInvitationPayload input,
            Function<CreateAttributionInvitationPayloadSelector, R> selection);

    <R> @Nullable R createBranchProtectionRule(
            CreateBranchProtectionRulePayload input, Function<CreateBranchProtectionRulePayloadSelector, R> selection);

    <R> @Nullable R createCheckRun(CreateCheckRunPayload input, Function<CreateCheckRunPayloadSelector, R> selection);

    <R> @Nullable R createCheckSuite(
            CreateCheckSuitePayload input, Function<CreateCheckSuitePayloadSelector, R> selection);

    <R> @Nullable R createCommitOnBranch(
            CreateCommitOnBranchPayload input, Function<CreateCommitOnBranchPayloadSelector, R> selection);

    <R> @Nullable R createDeployment(
            CreateDeploymentPayload input, Function<CreateDeploymentPayloadSelector, R> selection);

    <R> @Nullable R createDeploymentStatus(
            CreateDeploymentStatusPayload input, Function<CreateDeploymentStatusPayloadSelector, R> selection);

    <R> @Nullable R createDiscussion(
            CreateDiscussionPayload input, Function<CreateDiscussionPayloadSelector, R> selection);

    <R> @Nullable R createEnterpriseOrganization(
            CreateEnterpriseOrganizationPayload input,
            Function<CreateEnterpriseOrganizationPayloadSelector, R> selection);

    <R> @Nullable R createEnvironment(
            CreateEnvironmentPayload input, Function<CreateEnvironmentPayloadSelector, R> selection);

    <R> @Nullable R createIpAllowListEntry(
            CreateIpAllowListEntryPayload input, Function<CreateIpAllowListEntryPayloadSelector, R> selection);

    <R> @Nullable R createIssue(CreateIssuePayload input, Function<CreateIssuePayloadSelector, R> selection);

    <R> @Nullable R createIssueField(
            CreateIssueFieldPayload input, Function<CreateIssueFieldPayloadSelector, R> selection);

    <R> @Nullable R createIssueFieldValue(
            CreateIssueFieldValuePayload input, Function<CreateIssueFieldValuePayloadSelector, R> selection);

    <R> @Nullable R createIssueType(
            CreateIssueTypePayload input, Function<CreateIssueTypePayloadSelector, R> selection);

    <R> @Nullable R createLabel(CreateLabelPayload input, Function<CreateLabelPayloadSelector, R> selection);

    <R> @Nullable R createLinkedBranch(
            CreateLinkedBranchPayload input, Function<CreateLinkedBranchPayloadSelector, R> selection);

    <R> @Nullable R createMigrationSource(
            CreateMigrationSourcePayload input, Function<CreateMigrationSourcePayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R createProject(CreateProjectPayload input, Function<CreateProjectPayloadSelector, R> selection);

    <R> @Nullable R createProjectV2(
            CreateProjectV2Payload input, Function<CreateProjectV2PayloadSelector, R> selection);

    <R> @Nullable R createProjectV2Field(
            CreateProjectV2FieldPayload input, Function<CreateProjectV2FieldPayloadSelector, R> selection);

    <R> @Nullable R createProjectV2IssueField(
            CreateProjectV2IssueFieldPayload input, Function<CreateProjectV2IssueFieldPayloadSelector, R> selection);

    <R> @Nullable R createProjectV2StatusUpdate(
            CreateProjectV2StatusUpdatePayload input,
            Function<CreateProjectV2StatusUpdatePayloadSelector, R> selection);

    <R> @Nullable R createProjectV2View(
            CreateProjectV2ViewPayload input, Function<CreateProjectV2ViewPayloadSelector, R> selection);

    <R> @Nullable R createPullRequest(
            CreatePullRequestPayload input, Function<CreatePullRequestPayloadSelector, R> selection);

    <R> @Nullable R createRef(CreateRefPayload input, Function<CreateRefPayloadSelector, R> selection);

    <R> @Nullable R createRepository(
            CreateRepositoryPayload input, Function<CreateRepositoryPayloadSelector, R> selection);

    <R> @Nullable R createRepositoryCustomProperty(
            CreateRepositoryCustomPropertyPayload input,
            Function<CreateRepositoryCustomPropertyPayloadSelector, R> selection);

    <R> @Nullable R createRepositoryRuleset(
            CreateRepositoryRulesetPayload input, Function<CreateRepositoryRulesetPayloadSelector, R> selection);

    <R> @Nullable R createSponsorsListing(
            CreateSponsorsListingPayload input, Function<CreateSponsorsListingPayloadSelector, R> selection);

    <R> @Nullable R createSponsorsTier(
            CreateSponsorsTierPayload input, Function<CreateSponsorsTierPayloadSelector, R> selection);

    <R> @Nullable R createSponsorship(
            CreateSponsorshipPayload input, Function<CreateSponsorshipPayloadSelector, R> selection);

    <R> @Nullable R createSponsorships(
            CreateSponsorshipsPayload input, Function<CreateSponsorshipsPayloadSelector, R> selection);

    <R> @Nullable R createUserList(CreateUserListPayload input, Function<CreateUserListPayloadSelector, R> selection);

    <R> @Nullable R declineTopicSuggestion(
            DeclineTopicSuggestionPayload input, Function<DeclineTopicSuggestionPayloadSelector, R> selection);

    <R> @Nullable R deleteBranchProtectionRule(
            DeleteBranchProtectionRulePayload input, Function<DeleteBranchProtectionRulePayloadSelector, R> selection);

    <R> @Nullable R deleteDeployment(
            DeleteDeploymentPayload input, Function<DeleteDeploymentPayloadSelector, R> selection);

    <R> @Nullable R deleteDiscussion(
            DeleteDiscussionPayload input, Function<DeleteDiscussionPayloadSelector, R> selection);

    <R> @Nullable R deleteDiscussionComment(
            DeleteDiscussionCommentPayload input, Function<DeleteDiscussionCommentPayloadSelector, R> selection);

    <R> @Nullable R deleteEnvironment(
            DeleteEnvironmentPayload input, Function<DeleteEnvironmentPayloadSelector, R> selection);

    <R> @Nullable R deleteIpAllowListEntry(
            DeleteIpAllowListEntryPayload input, Function<DeleteIpAllowListEntryPayloadSelector, R> selection);

    <R> @Nullable R deleteIssue(DeleteIssuePayload input, Function<DeleteIssuePayloadSelector, R> selection);

    <R> @Nullable R deleteIssueComment(
            DeleteIssueCommentPayload input, Function<DeleteIssueCommentPayloadSelector, R> selection);

    <R> @Nullable R deleteIssueField(
            DeleteIssueFieldPayload input, Function<DeleteIssueFieldPayloadSelector, R> selection);

    <R> @Nullable R deleteIssueFieldValue(
            DeleteIssueFieldValuePayload input, Function<DeleteIssueFieldValuePayloadSelector, R> selection);

    <R> @Nullable R deleteIssueType(
            DeleteIssueTypePayload input, Function<DeleteIssueTypePayloadSelector, R> selection);

    <R> @Nullable R deleteLabel(DeleteLabelPayload input, Function<DeleteLabelPayloadSelector, R> selection);

    <R> @Nullable R deleteLinkedBranch(
            DeleteLinkedBranchPayload input, Function<DeleteLinkedBranchPayloadSelector, R> selection);

    <R> @Nullable R deletePackageVersion(
            DeletePackageVersionPayload input, Function<DeletePackageVersionPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R deleteProject(DeleteProjectPayload input, Function<DeleteProjectPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R deleteProjectCard(
            DeleteProjectCardPayload input, Function<DeleteProjectCardPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R deleteProjectColumn(
            DeleteProjectColumnPayload input, Function<DeleteProjectColumnPayloadSelector, R> selection);

    <R> @Nullable R deleteProjectV2(
            DeleteProjectV2Payload input, Function<DeleteProjectV2PayloadSelector, R> selection);

    <R> @Nullable R deleteProjectV2Field(
            DeleteProjectV2FieldPayload input, Function<DeleteProjectV2FieldPayloadSelector, R> selection);

    <R> @Nullable R deleteProjectV2Item(
            DeleteProjectV2ItemPayload input, Function<DeleteProjectV2ItemPayloadSelector, R> selection);

    <R> @Nullable R deleteProjectV2StatusUpdate(
            DeleteProjectV2StatusUpdatePayload input,
            Function<DeleteProjectV2StatusUpdatePayloadSelector, R> selection);

    <R> @Nullable R deleteProjectV2View(
            DeleteProjectV2ViewPayload input, Function<DeleteProjectV2ViewPayloadSelector, R> selection);

    <R> @Nullable R deleteProjectV2Workflow(
            DeleteProjectV2WorkflowPayload input, Function<DeleteProjectV2WorkflowPayloadSelector, R> selection);

    <R> @Nullable R deletePullRequestReview(
            DeletePullRequestReviewPayload input, Function<DeletePullRequestReviewPayloadSelector, R> selection);

    <R> @Nullable R deletePullRequestReviewComment(
            DeletePullRequestReviewCommentPayload input,
            Function<DeletePullRequestReviewCommentPayloadSelector, R> selection);

    <R> @Nullable R deleteRef(DeleteRefPayload input, Function<DeleteRefPayloadSelector, R> selection);

    <R> @Nullable R deleteRepositoryCustomProperty(
            DeleteRepositoryCustomPropertyPayload input,
            Function<DeleteRepositoryCustomPropertyPayloadSelector, R> selection);

    <R> @Nullable R deleteRepositoryRuleset(
            DeleteRepositoryRulesetPayload input, Function<DeleteRepositoryRulesetPayloadSelector, R> selection);

    <R> @Nullable R deleteUserList(DeleteUserListPayload input, Function<DeleteUserListPayloadSelector, R> selection);

    <R> @Nullable R deleteVerifiableDomain(
            DeleteVerifiableDomainPayload input, Function<DeleteVerifiableDomainPayloadSelector, R> selection);

    <R> @Nullable R dequeuePullRequest(
            DequeuePullRequestPayload input, Function<DequeuePullRequestPayloadSelector, R> selection);

    <R> @Nullable R disablePullRequestAutoMerge(
            DisablePullRequestAutoMergePayload input,
            Function<DisablePullRequestAutoMergePayloadSelector, R> selection);

    <R> @Nullable R dismissPullRequestReview(
            DismissPullRequestReviewPayload input, Function<DismissPullRequestReviewPayloadSelector, R> selection);

    <R> @Nullable R dismissRepositoryVulnerabilityAlert(
            DismissRepositoryVulnerabilityAlertPayload input,
            Function<DismissRepositoryVulnerabilityAlertPayloadSelector, R> selection);

    <R> @Nullable R enablePullRequestAutoMerge(
            EnablePullRequestAutoMergePayload input, Function<EnablePullRequestAutoMergePayloadSelector, R> selection);

    <R> @Nullable R enqueuePullRequest(
            EnqueuePullRequestPayload input, Function<EnqueuePullRequestPayloadSelector, R> selection);

    <R> @Nullable R followOrganization(
            FollowOrganizationPayload input, Function<FollowOrganizationPayloadSelector, R> selection);

    <R> @Nullable R followUser(FollowUserPayload input, Function<FollowUserPayloadSelector, R> selection);

    <R> @Nullable R grantEnterpriseOrganizationsMigratorRole(
            GrantEnterpriseOrganizationsMigratorRolePayload input,
            Function<GrantEnterpriseOrganizationsMigratorRolePayloadSelector, R> selection);

    <R> @Nullable R grantMigratorRole(
            GrantMigratorRolePayload input, Function<GrantMigratorRolePayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R importProject(ImportProjectPayload input, Function<ImportProjectPayloadSelector, R> selection);

    <R> @Nullable R inviteEnterpriseAdmin(
            InviteEnterpriseAdminPayload input, Function<InviteEnterpriseAdminPayloadSelector, R> selection);

    <R> @Nullable R inviteEnterpriseMember(
            InviteEnterpriseMemberPayload input, Function<InviteEnterpriseMemberPayloadSelector, R> selection);

    <R> @Nullable R linkProjectV2ToRepository(
            LinkProjectV2ToRepositoryPayload input, Function<LinkProjectV2ToRepositoryPayloadSelector, R> selection);

    <R> @Nullable R linkProjectV2ToTeam(
            LinkProjectV2ToTeamPayload input, Function<LinkProjectV2ToTeamPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R linkRepositoryToProject(
            LinkRepositoryToProjectPayload input, Function<LinkRepositoryToProjectPayloadSelector, R> selection);

    <R> @Nullable R lockLockable(LockLockablePayload input, Function<LockLockablePayloadSelector, R> selection);

    <R> @Nullable R markDiscussionCommentAsAnswer(
            MarkDiscussionCommentAsAnswerPayload input,
            Function<MarkDiscussionCommentAsAnswerPayloadSelector, R> selection);

    <R> @Nullable R markFileAsViewed(
            MarkFileAsViewedPayload input, Function<MarkFileAsViewedPayloadSelector, R> selection);

    <R> @Nullable R markProjectV2AsTemplate(
            MarkProjectV2AsTemplatePayload input, Function<MarkProjectV2AsTemplatePayloadSelector, R> selection);

    <R> @Nullable R markPullRequestReadyForReview(
            MarkPullRequestReadyForReviewPayload input,
            Function<MarkPullRequestReadyForReviewPayloadSelector, R> selection);

    <R> @Nullable R mergeBranch(MergeBranchPayload input, Function<MergeBranchPayloadSelector, R> selection);

    <R> @Nullable R mergePullRequest(
            MergePullRequestPayload input, Function<MergePullRequestPayloadSelector, R> selection);

    <R> @Nullable R minimizeComment(
            MinimizeCommentPayload input, Function<MinimizeCommentPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R moveProjectCard(
            MoveProjectCardPayload input, Function<MoveProjectCardPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R moveProjectColumn(
            MoveProjectColumnPayload input, Function<MoveProjectColumnPayloadSelector, R> selection);

    <R> @Nullable R pinEnvironment(PinEnvironmentPayload input, Function<PinEnvironmentPayloadSelector, R> selection);

    <R> @Nullable R pinIssue(PinIssuePayload input, Function<PinIssuePayloadSelector, R> selection);

    <R> @Nullable R pinIssueComment(
            PinIssueCommentPayload input, Function<PinIssueCommentPayloadSelector, R> selection);

    <R> @Nullable R promoteRepositoryCustomProperty(
            PromoteRepositoryCustomPropertyPayload input,
            Function<PromoteRepositoryCustomPropertyPayloadSelector, R> selection);

    <R> @Nullable R publishSponsorsTier(
            PublishSponsorsTierPayload input, Function<PublishSponsorsTierPayloadSelector, R> selection);

    <R> @Nullable R regenerateEnterpriseIdentityProviderRecoveryCodes(
            RegenerateEnterpriseIdentityProviderRecoveryCodesPayload input,
            Function<RegenerateEnterpriseIdentityProviderRecoveryCodesPayloadSelector, R> selection);

    <R> @Nullable R regenerateVerifiableDomainToken(
            RegenerateVerifiableDomainTokenPayload input,
            Function<RegenerateVerifiableDomainTokenPayloadSelector, R> selection);

    <R> @Nullable R rejectDeployments(
            RejectDeploymentsPayload input, Function<RejectDeploymentsPayloadSelector, R> selection);

    <R> @Nullable R rejectPendingIssueSuggestions(
            RejectPendingIssueSuggestionsPayload input,
            Function<RejectPendingIssueSuggestionsPayloadSelector, R> selection);

    <R> @Nullable R removeAssigneesFromAssignable(
            RemoveAssigneesFromAssignablePayload input,
            Function<RemoveAssigneesFromAssignablePayloadSelector, R> selection);

    <R> @Nullable R removeBlockedBy(
            RemoveBlockedByPayload input, Function<RemoveBlockedByPayloadSelector, R> selection);

    <R> @Nullable R removeCloseIssueReferences(
            RemoveCloseIssueReferencesPayload input, Function<RemoveCloseIssueReferencesPayloadSelector, R> selection);

    <R> @Nullable R removeEnterpriseAdmin(
            RemoveEnterpriseAdminPayload input, Function<RemoveEnterpriseAdminPayloadSelector, R> selection);

    <R> @Nullable R removeEnterpriseIdentityProvider(
            RemoveEnterpriseIdentityProviderPayload input,
            Function<RemoveEnterpriseIdentityProviderPayloadSelector, R> selection);

    <R> @Nullable R removeEnterpriseMember(
            RemoveEnterpriseMemberPayload input, Function<RemoveEnterpriseMemberPayloadSelector, R> selection);

    <R> @Nullable R removeEnterpriseOrganization(
            RemoveEnterpriseOrganizationPayload input,
            Function<RemoveEnterpriseOrganizationPayloadSelector, R> selection);

    <R> @Nullable R removeEnterpriseSupportEntitlement(
            RemoveEnterpriseSupportEntitlementPayload input,
            Function<RemoveEnterpriseSupportEntitlementPayloadSelector, R> selection);

    <R> @Nullable R removeLabelsFromLabelable(
            RemoveLabelsFromLabelablePayload input, Function<RemoveLabelsFromLabelablePayloadSelector, R> selection);

    <R> @Nullable R removeOutsideCollaborator(
            RemoveOutsideCollaboratorPayload input, Function<RemoveOutsideCollaboratorPayloadSelector, R> selection);

    <R> @Nullable R removePullRequestCreationCapBypassUsers(
            RemovePullRequestCreationCapBypassUsersPayload input,
            Function<RemovePullRequestCreationCapBypassUsersPayloadSelector, R> selection);

    <R> @Nullable R removeReaction(RemoveReactionPayload input, Function<RemoveReactionPayloadSelector, R> selection);

    <R> @Nullable R removeRelatesTo(
            RemoveRelatesToPayload input, Function<RemoveRelatesToPayloadSelector, R> selection);

    <R> @Nullable R removeStar(RemoveStarPayload input, Function<RemoveStarPayloadSelector, R> selection);

    <R> @Nullable R removeSubIssue(RemoveSubIssuePayload input, Function<RemoveSubIssuePayloadSelector, R> selection);

    <R> @Nullable R removeUpvote(RemoveUpvotePayload input, Function<RemoveUpvotePayloadSelector, R> selection);

    <R> @Nullable R reopenDiscussion(
            ReopenDiscussionPayload input, Function<ReopenDiscussionPayloadSelector, R> selection);

    <R> @Nullable R reopenIssue(ReopenIssuePayload input, Function<ReopenIssuePayloadSelector, R> selection);

    <R> @Nullable R reopenPullRequest(
            ReopenPullRequestPayload input, Function<ReopenPullRequestPayloadSelector, R> selection);

    <R> @Nullable R reorderEnvironment(
            ReorderEnvironmentPayload input, Function<ReorderEnvironmentPayloadSelector, R> selection);

    <R> @Nullable R replaceActorsForAssignable(
            ReplaceActorsForAssignablePayload input, Function<ReplaceActorsForAssignablePayloadSelector, R> selection);

    <R> @Nullable R reprioritizeSubIssue(
            ReprioritizeSubIssuePayload input, Function<ReprioritizeSubIssuePayloadSelector, R> selection);

    <R> @Nullable R requestReviews(RequestReviewsPayload input, Function<RequestReviewsPayloadSelector, R> selection);

    <R> @Nullable R requestReviewsByLogin(
            RequestReviewsByLoginPayload input, Function<RequestReviewsByLoginPayloadSelector, R> selection);

    <R> @Nullable R rerequestCheckSuite(
            RerequestCheckSuitePayload input, Function<RerequestCheckSuitePayloadSelector, R> selection);

    <R> @Nullable R rerequestReviews(
            RerequestReviewsPayload input, Function<RerequestReviewsPayloadSelector, R> selection);

    <R> @Nullable R resolveReviewThread(
            ResolveReviewThreadPayload input, Function<ResolveReviewThreadPayloadSelector, R> selection);

    <R> @Nullable R retireSponsorsTier(
            RetireSponsorsTierPayload input, Function<RetireSponsorsTierPayloadSelector, R> selection);

    <R> @Nullable R revertPullRequest(
            RevertPullRequestPayload input, Function<RevertPullRequestPayloadSelector, R> selection);

    <R> @Nullable R revokeEnterpriseOrganizationsMigratorRole(
            RevokeEnterpriseOrganizationsMigratorRolePayload input,
            Function<RevokeEnterpriseOrganizationsMigratorRolePayloadSelector, R> selection);

    <R> @Nullable R revokeMigratorRole(
            RevokeMigratorRolePayload input, Function<RevokeMigratorRolePayloadSelector, R> selection);

    <R> @Nullable R setEnterpriseIdentityProvider(
            SetEnterpriseIdentityProviderPayload input,
            Function<SetEnterpriseIdentityProviderPayloadSelector, R> selection);

    <R> @Nullable R setIssueFieldValue(
            SetIssueFieldValuePayload input, Function<SetIssueFieldValuePayloadSelector, R> selection);

    <R> @Nullable R setOrganizationInteractionLimit(
            SetOrganizationInteractionLimitPayload input,
            Function<SetOrganizationInteractionLimitPayloadSelector, R> selection);

    <R> @Nullable R setRepositoryCustomPropertyValues(
            SetRepositoryCustomPropertyValuesPayload input,
            Function<SetRepositoryCustomPropertyValuesPayloadSelector, R> selection);

    <R> @Nullable R setRepositoryInteractionLimit(
            SetRepositoryInteractionLimitPayload input,
            Function<SetRepositoryInteractionLimitPayloadSelector, R> selection);

    <R> @Nullable R setUserInteractionLimit(
            SetUserInteractionLimitPayload input, Function<SetUserInteractionLimitPayloadSelector, R> selection);

    <R> @Nullable R startOrganizationMigration(
            StartOrganizationMigrationPayload input, Function<StartOrganizationMigrationPayloadSelector, R> selection);

    <R> @Nullable R startRepositoryMigration(
            StartRepositoryMigrationPayload input, Function<StartRepositoryMigrationPayloadSelector, R> selection);

    <R> @Nullable R submitPullRequestReview(
            SubmitPullRequestReviewPayload input, Function<SubmitPullRequestReviewPayloadSelector, R> selection);

    <R> @Nullable R transferEnterpriseOrganization(
            TransferEnterpriseOrganizationPayload input,
            Function<TransferEnterpriseOrganizationPayloadSelector, R> selection);

    <R> @Nullable R transferIssue(TransferIssuePayload input, Function<TransferIssuePayloadSelector, R> selection);

    <R> @Nullable R unarchiveProjectV2Item(
            UnarchiveProjectV2ItemPayload input, Function<UnarchiveProjectV2ItemPayloadSelector, R> selection);

    <R> @Nullable R unarchivePullRequest(
            UnarchivePullRequestPayload input, Function<UnarchivePullRequestPayloadSelector, R> selection);

    <R> @Nullable R unarchiveRepository(
            UnarchiveRepositoryPayload input, Function<UnarchiveRepositoryPayloadSelector, R> selection);

    <R> @Nullable R unfollowOrganization(
            UnfollowOrganizationPayload input, Function<UnfollowOrganizationPayloadSelector, R> selection);

    <R> @Nullable R unfollowUser(UnfollowUserPayload input, Function<UnfollowUserPayloadSelector, R> selection);

    <R> @Nullable R unlinkProjectV2FromRepository(
            UnlinkProjectV2FromRepositoryPayload input,
            Function<UnlinkProjectV2FromRepositoryPayloadSelector, R> selection);

    <R> @Nullable R unlinkProjectV2FromTeam(
            UnlinkProjectV2FromTeamPayload input, Function<UnlinkProjectV2FromTeamPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R unlinkRepositoryFromProject(
            UnlinkRepositoryFromProjectPayload input,
            Function<UnlinkRepositoryFromProjectPayloadSelector, R> selection);

    <R> @Nullable R unlockLockable(UnlockLockablePayload input, Function<UnlockLockablePayloadSelector, R> selection);

    <R> @Nullable R unmarkDiscussionCommentAsAnswer(
            UnmarkDiscussionCommentAsAnswerPayload input,
            Function<UnmarkDiscussionCommentAsAnswerPayloadSelector, R> selection);

    <R> @Nullable R unmarkFileAsViewed(
            UnmarkFileAsViewedPayload input, Function<UnmarkFileAsViewedPayloadSelector, R> selection);

    <R> @Nullable R unmarkIssueAsDuplicate(
            UnmarkIssueAsDuplicatePayload input, Function<UnmarkIssueAsDuplicatePayloadSelector, R> selection);

    <R> @Nullable R unmarkProjectV2AsTemplate(
            UnmarkProjectV2AsTemplatePayload input, Function<UnmarkProjectV2AsTemplatePayloadSelector, R> selection);

    <R> @Nullable R unminimizeComment(
            UnminimizeCommentPayload input, Function<UnminimizeCommentPayloadSelector, R> selection);

    <R> @Nullable R unpinIssue(UnpinIssuePayload input, Function<UnpinIssuePayloadSelector, R> selection);

    <R> @Nullable R unpinIssueComment(
            UnpinIssueCommentPayload input, Function<UnpinIssueCommentPayloadSelector, R> selection);

    <R> @Nullable R unresolveReviewThread(
            UnresolveReviewThreadPayload input, Function<UnresolveReviewThreadPayloadSelector, R> selection);

    <R> @Nullable R updateBranchProtectionRule(
            UpdateBranchProtectionRulePayload input, Function<UpdateBranchProtectionRulePayloadSelector, R> selection);

    <R> @Nullable R updateCheckRun(UpdateCheckRunPayload input, Function<UpdateCheckRunPayloadSelector, R> selection);

    <R> @Nullable R updateCheckSuitePreferences(
            UpdateCheckSuitePreferencesPayload input,
            Function<UpdateCheckSuitePreferencesPayloadSelector, R> selection);

    <R> @Nullable R updateDiscussion(
            UpdateDiscussionPayload input, Function<UpdateDiscussionPayloadSelector, R> selection);

    <R> @Nullable R updateDiscussionComment(
            UpdateDiscussionCommentPayload input, Function<UpdateDiscussionCommentPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseAdministratorRole(
            UpdateEnterpriseAdministratorRolePayload input,
            Function<UpdateEnterpriseAdministratorRolePayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseAllowPrivateRepositoryForkingSetting(
            UpdateEnterpriseAllowPrivateRepositoryForkingSettingPayload input,
            Function<UpdateEnterpriseAllowPrivateRepositoryForkingSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseDefaultRepositoryPermissionSetting(
            UpdateEnterpriseDefaultRepositoryPermissionSettingPayload input,
            Function<UpdateEnterpriseDefaultRepositoryPermissionSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseDeployKeySetting(
            UpdateEnterpriseDeployKeySettingPayload input,
            Function<UpdateEnterpriseDeployKeySettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseMembersCanChangeRepositoryVisibilitySetting(
            UpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingPayload input,
            Function<UpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseMembersCanCreateRepositoriesSetting(
            UpdateEnterpriseMembersCanCreateRepositoriesSettingPayload input,
            Function<UpdateEnterpriseMembersCanCreateRepositoriesSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseMembersCanDeleteIssuesSetting(
            UpdateEnterpriseMembersCanDeleteIssuesSettingPayload input,
            Function<UpdateEnterpriseMembersCanDeleteIssuesSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseMembersCanDeleteRepositoriesSetting(
            UpdateEnterpriseMembersCanDeleteRepositoriesSettingPayload input,
            Function<UpdateEnterpriseMembersCanDeleteRepositoriesSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseMembersCanInviteCollaboratorsSetting(
            UpdateEnterpriseMembersCanInviteCollaboratorsSettingPayload input,
            Function<UpdateEnterpriseMembersCanInviteCollaboratorsSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseMembersCanMakePurchasesSetting(
            UpdateEnterpriseMembersCanMakePurchasesSettingPayload input,
            Function<UpdateEnterpriseMembersCanMakePurchasesSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseMembersCanUpdateProtectedBranchesSetting(
            UpdateEnterpriseMembersCanUpdateProtectedBranchesSettingPayload input,
            Function<UpdateEnterpriseMembersCanUpdateProtectedBranchesSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseMembersCanViewDependencyInsightsSetting(
            UpdateEnterpriseMembersCanViewDependencyInsightsSettingPayload input,
            Function<UpdateEnterpriseMembersCanViewDependencyInsightsSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseOrganizationProjectsSetting(
            UpdateEnterpriseOrganizationProjectsSettingPayload input,
            Function<UpdateEnterpriseOrganizationProjectsSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseOwnerOrganizationRole(
            UpdateEnterpriseOwnerOrganizationRolePayload input,
            Function<UpdateEnterpriseOwnerOrganizationRolePayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseProfile(
            UpdateEnterpriseProfilePayload input, Function<UpdateEnterpriseProfilePayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseRepositoryProjectsSetting(
            UpdateEnterpriseRepositoryProjectsSettingPayload input,
            Function<UpdateEnterpriseRepositoryProjectsSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseTwoFactorAuthenticationDisallowedMethodsSetting(
            UpdateEnterpriseTwoFactorAuthenticationDisallowedMethodsSettingPayload input,
            Function<UpdateEnterpriseTwoFactorAuthenticationDisallowedMethodsSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnterpriseTwoFactorAuthenticationRequiredSetting(
            UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayload input,
            Function<UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadSelector, R> selection);

    <R> @Nullable R updateEnvironment(
            UpdateEnvironmentPayload input, Function<UpdateEnvironmentPayloadSelector, R> selection);

    <R> @Nullable R updateIpAllowListEnabledSetting(
            UpdateIpAllowListEnabledSettingPayload input,
            Function<UpdateIpAllowListEnabledSettingPayloadSelector, R> selection);

    <R> @Nullable R updateIpAllowListEntry(
            UpdateIpAllowListEntryPayload input, Function<UpdateIpAllowListEntryPayloadSelector, R> selection);

    <R> @Nullable R updateIpAllowListForInstalledAppsEnabledSetting(
            UpdateIpAllowListForInstalledAppsEnabledSettingPayload input,
            Function<UpdateIpAllowListForInstalledAppsEnabledSettingPayloadSelector, R> selection);

    <R> @Nullable R updateIpAllowListUserLevelEnforcementEnabledSetting(
            UpdateIpAllowListUserLevelEnforcementEnabledSettingPayload input,
            Function<UpdateIpAllowListUserLevelEnforcementEnabledSettingPayloadSelector, R> selection);

    <R> @Nullable R updateIssue(UpdateIssuePayload input, Function<UpdateIssuePayloadSelector, R> selection);

    <R> @Nullable R updateIssueComment(
            UpdateIssueCommentPayload input, Function<UpdateIssueCommentPayloadSelector, R> selection);

    <R> @Nullable R updateIssueField(
            UpdateIssueFieldPayload input, Function<UpdateIssueFieldPayloadSelector, R> selection);

    <R> @Nullable R updateIssueFieldValue(
            UpdateIssueFieldValuePayload input, Function<UpdateIssueFieldValuePayloadSelector, R> selection);

    <R> @Nullable R updateIssueIssueType(
            UpdateIssueIssueTypePayload input, Function<UpdateIssueIssueTypePayloadSelector, R> selection);

    <R> @Nullable R updateIssueType(
            UpdateIssueTypePayload input, Function<UpdateIssueTypePayloadSelector, R> selection);

    <R> @Nullable R updateLabel(UpdateLabelPayload input, Function<UpdateLabelPayloadSelector, R> selection);

    <R> @Nullable R updateNotificationRestrictionSetting(
            UpdateNotificationRestrictionSettingPayload input,
            Function<UpdateNotificationRestrictionSettingPayloadSelector, R> selection);

    <R> @Nullable R updateOrganizationAllowPrivateRepositoryForkingSetting(
            UpdateOrganizationAllowPrivateRepositoryForkingSettingPayload input,
            Function<UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadSelector, R> selection);

    <R> @Nullable R updateOrganizationWebCommitSignoffSetting(
            UpdateOrganizationWebCommitSignoffSettingPayload input,
            Function<UpdateOrganizationWebCommitSignoffSettingPayloadSelector, R> selection);

    <R> @Nullable R updatePatreonSponsorability(
            UpdatePatreonSponsorabilityPayload input,
            Function<UpdatePatreonSponsorabilityPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R updateProject(UpdateProjectPayload input, Function<UpdateProjectPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R updateProjectCard(
            UpdateProjectCardPayload input, Function<UpdateProjectCardPayloadSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R updateProjectColumn(
            UpdateProjectColumnPayload input, Function<UpdateProjectColumnPayloadSelector, R> selection);

    <R> @Nullable R updateProjectV2(
            UpdateProjectV2Payload input, Function<UpdateProjectV2PayloadSelector, R> selection);

    <R> @Nullable R updateProjectV2Collaborators(
            UpdateProjectV2CollaboratorsPayload input,
            Function<UpdateProjectV2CollaboratorsPayloadSelector, R> selection);

    <R> @Nullable R updateProjectV2DraftIssue(
            UpdateProjectV2DraftIssuePayload input, Function<UpdateProjectV2DraftIssuePayloadSelector, R> selection);

    <R> @Nullable R updateProjectV2Field(
            UpdateProjectV2FieldPayload input, Function<UpdateProjectV2FieldPayloadSelector, R> selection);

    <R> @Nullable R updateProjectV2ItemFieldValue(
            UpdateProjectV2ItemFieldValuePayload input,
            Function<UpdateProjectV2ItemFieldValuePayloadSelector, R> selection);

    <R> @Nullable R updateProjectV2ItemPosition(
            UpdateProjectV2ItemPositionPayload input,
            Function<UpdateProjectV2ItemPositionPayloadSelector, R> selection);

    <R> @Nullable R updateProjectV2StatusUpdate(
            UpdateProjectV2StatusUpdatePayload input,
            Function<UpdateProjectV2StatusUpdatePayloadSelector, R> selection);

    <R> @Nullable R updateProjectV2View(
            UpdateProjectV2ViewPayload input, Function<UpdateProjectV2ViewPayloadSelector, R> selection);

    <R> @Nullable R updatePullRequest(
            UpdatePullRequestPayload input, Function<UpdatePullRequestPayloadSelector, R> selection);

    <R> @Nullable R updatePullRequestBranch(
            UpdatePullRequestBranchPayload input, Function<UpdatePullRequestBranchPayloadSelector, R> selection);

    <R> @Nullable R updatePullRequestReview(
            UpdatePullRequestReviewPayload input, Function<UpdatePullRequestReviewPayloadSelector, R> selection);

    <R> @Nullable R updatePullRequestReviewComment(
            UpdatePullRequestReviewCommentPayload input,
            Function<UpdatePullRequestReviewCommentPayloadSelector, R> selection);

    <R> @Nullable R updateRef(UpdateRefPayload input, Function<UpdateRefPayloadSelector, R> selection);

    <R> @Nullable R updateRefs(UpdateRefsPayload input, Function<UpdateRefsPayloadSelector, R> selection);

    <R> @Nullable R updateRepository(
            UpdateRepositoryPayload input, Function<UpdateRepositoryPayloadSelector, R> selection);

    <R> @Nullable R updateRepositoryCustomProperty(
            UpdateRepositoryCustomPropertyPayload input,
            Function<UpdateRepositoryCustomPropertyPayloadSelector, R> selection);

    <R> @Nullable R updateRepositoryRuleset(
            UpdateRepositoryRulesetPayload input, Function<UpdateRepositoryRulesetPayloadSelector, R> selection);

    <R> @Nullable R updateRepositoryWebCommitSignoffSetting(
            UpdateRepositoryWebCommitSignoffSettingPayload input,
            Function<UpdateRepositoryWebCommitSignoffSettingPayloadSelector, R> selection);

    <R> @Nullable R updateSponsorshipPreferences(
            UpdateSponsorshipPreferencesPayload input,
            Function<UpdateSponsorshipPreferencesPayloadSelector, R> selection);

    <R> @Nullable R updateSubscription(
            UpdateSubscriptionPayload input, Function<UpdateSubscriptionPayloadSelector, R> selection);

    <R> @Nullable R updateTeamReviewAssignment(
            UpdateTeamReviewAssignmentPayload input, Function<UpdateTeamReviewAssignmentPayloadSelector, R> selection);

    <R> @Nullable R updateTeamsRepository(
            UpdateTeamsRepositoryPayload input, Function<UpdateTeamsRepositoryPayloadSelector, R> selection);

    <R> @Nullable R updateTopics(UpdateTopicsPayload input, Function<UpdateTopicsPayloadSelector, R> selection);

    <R> @Nullable R updateUserList(UpdateUserListPayload input, Function<UpdateUserListPayloadSelector, R> selection);

    <R> @Nullable R updateUserListsForItem(
            UpdateUserListsForItemPayload input, Function<UpdateUserListsForItemPayloadSelector, R> selection);

    <R> @Nullable R verifyVerifiableDomain(
            VerifyVerifiableDomainPayload input, Function<VerifyVerifiableDomainPayloadSelector, R> selection);
}
