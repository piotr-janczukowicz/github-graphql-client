package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AddedToMergeQueueEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AddedToProjectEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AddedToProjectV2EventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AddedToStackEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssignableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssignedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssigneeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AuditEntryActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AutoMergeDisabledEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AutoMergeEnabledEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AutoRebaseEnabledEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AutoSquashEnabledEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AutomaticBaseChangeFailedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AutomaticBaseChangeSucceededEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BaseRefChangedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BaseRefDeletedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BaseRefForcePushedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BlobSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BlockedByAddedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BlockedByRemovedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BlockingAddedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BlockingRemovedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BranchActorAllowanceActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BranchNamePatternParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BypassActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BypassForcePushAllowanceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BypassPullRequestAllowanceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CWESelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ClaimableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ClosableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ClosedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CloserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CodeCoverageParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CodeOfConductSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CodeQualityParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CodeScanningParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentDeletedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitAuthorEmailPatternParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentThreadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitMessagePatternParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitterEmailPatternParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ComparisonSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ConnectedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ConvertToDraftEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ConvertedFromDraftEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ConvertedNoteToIssueEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ConvertedToDiscussionEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedIssueContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedIssueOrRestrictedContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedPullRequestContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedPullRequestOrRestrictedContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedRepositoryContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedRepositoryOrRestrictedContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CrossReferencedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CustomPropertySourceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DemilestonedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DependencyGraphManifestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeployKeySelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeployedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentEnvironmentChangedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentReviewerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentStatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DisconnectedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCategorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DraftIssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseIdentityProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseRepositoryInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountEmailSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountsUploadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.FileExtensionRestrictionParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.FilePathRestrictionParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GenericHovercardContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitSignatureSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GpgSignatureSelector;
import io.github.piotr_janczukowicz.github.graphql.model.HeadRefDeletedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.HeadRefForcePushedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.HeadRefRestoredEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.HovercardContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentPinnedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentUnpinnedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldAddedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldChangedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldMultiSelectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldMultiSelectValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldNumberSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldNumberValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldRemovedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldTextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldTextValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrPullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeAddedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeChangedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeRemovedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabeledEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LanguageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LicenseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LinkedBranchSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MannequinSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MarkedAsDuplicateEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceCategorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MaxFilePathLengthParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MaxFileSizeParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MemberFeatureRequestNotificationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MembersCanDeleteReposClearAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MembersCanDeleteReposDisableAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MembersCanDeleteReposEnableAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MentionedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MigrationSourceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MilestonedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MinimizableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MovedColumnsInProjectEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MutationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.NodeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OIDCProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OauthApplicationCreateAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgAddBillingManagerAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgAddMemberAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgBlockUserAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgConfigDisableCollaboratorsOnlyAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgConfigEnableCollaboratorsOnlyAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgCreateAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgDisableOauthAppRestrictionsAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgDisableSamlAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgDisableTwoFactorRequirementAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgEnableOauthAppRestrictionsAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgEnableSamlAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgEnableTwoFactorRequirementAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgInviteMemberAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgInviteToBusinessAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgOauthAppAccessApprovedAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgOauthAppAccessBlockedAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgOauthAppAccessDeniedAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgOauthAppAccessRequestedAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgOauthAppAccessUnblockedAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgRemoveBillingManagerAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgRemoveMemberAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgRemoveOutsideCollaboratorAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgRestoreMemberAuditEntryMembershipSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgRestoreMemberAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgRestoreMemberMembershipOrganizationAuditEntryDataSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgRestoreMemberMembershipRepositoryAuditEntryDataSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgRestoreMemberMembershipTeamAuditEntryDataSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgUnblockUserAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgUpdateDefaultRepositoryPermissionAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgUpdateMemberAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgUpdateMemberRepositoryCreationPermissionAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrgUpdateMemberRepositoryInvitationPermissionAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIdentityProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMigrationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationTeamsHovercardContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationsHovercardContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageTagSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ParentIssueAddedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ParentIssueRemovedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PendingAssigneeSuggestionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PendingCloseSuggestionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PendingFieldSuggestionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PendingIssueSuggestionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PendingLabelSuggestionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PendingTypeSuggestionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnableItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedDiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedEnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedIssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedIssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PrivateRepositoryForkingDisableAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.PrivateRepositoryForkingEnableAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2IssueFieldValuesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemContentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldDateValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldIterationValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldLabelValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldMilestoneValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldMultiSelectValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldNumberValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldPullRequestValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldRepositoryValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldReviewerValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldSingleSelectValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldTextValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldUserValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemIssueFieldValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemStatusChangedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2IterationFieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2MultiSelectFieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SingleSelectFieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2WorkflowSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PublicKeySelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCommitCommentThreadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewThreadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestRevisionMarkerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestThreadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineItemsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PushAllowanceActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PushAllowanceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PushSelector;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReadyForReviewEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReferencedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReferencedSubjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseAssetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RemovedFromMergeQueueEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RemovedFromProjectEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RemovedFromProjectV2EventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RemovedFromStackEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RenamedTitleEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RenamedTitleSubjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReopenedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoAccessAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoAddMemberAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoAddTopicAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoArchivedAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoChangeMergeSettingAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoConfigDisableAnonymousGitAccessAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoConfigDisableCollaboratorsOnlyAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoConfigDisableContributorsOnlyAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoConfigDisableSockpuppetDisallowedAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoConfigEnableAnonymousGitAccessAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoConfigEnableCollaboratorsOnlyAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoConfigEnableContributorsOnlyAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoConfigEnableSockpuppetDisallowedAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoConfigLockAnonymousGitAccessAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoConfigUnlockAnonymousGitAccessAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoCreateAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoDestroyAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoRemoveMemberAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoRemoveTopicAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMigrationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetBypassActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryTopicSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVisibilityChangeDisableAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVisibilityChangeEnableAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVulnerabilityAlertSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequestedReviewerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequiredDeploymentsParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequiredStatusChecksParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RestrictedContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewDismissalAllowanceActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewDismissalAllowanceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewDismissedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewRequestRemovedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewRequestedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewStatusHovercardContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RuleParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RuleSourceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SavedReplySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SearchResultItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SmimeSignatureSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingFeatureableItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingFeaturedItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SshSignatureSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StarrableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusCheckRollupContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusCheckRollupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubIssueAddedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubIssueRemovedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscribableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscribedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TagNamePatternParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TagSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamAddMemberAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamAddRepositoryAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamChangeParentTeamAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamRemoveMemberAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamRemoveRepositoryAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TopicSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TransferredEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TreeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnassignedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UniformResourceLocatableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnknownSignatureSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnlabeledEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnlockedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnmarkedAsDuplicateEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnpinnedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnsubscribedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserBlockedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserListItemsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserListSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserNamespaceRepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ViewerHovercardContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VotableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowsParametersSelector;
import java.util.Map;
import java.util.Set;
import org.jspecify.annotations.Nullable;

/** Entry points of the generated selection code: the root selector of each root type and the branch registry. */
final class Selectors {

    private static final Map<Class<?>, Branch> BRANCHES = Map.ofEntries(
            Map.entry(
                    AddedToMergeQueueEventSelector.class,
                    new Branch("AddedToMergeQueueEvent", AddedToMergeQueueEventSelectorImpl::new)),
            Map.entry(
                    AddedToProjectEventSelector.class,
                    new Branch("AddedToProjectEvent", AddedToProjectEventSelectorImpl::new)),
            Map.entry(
                    AddedToProjectV2EventSelector.class,
                    new Branch("AddedToProjectV2Event", AddedToProjectV2EventSelectorImpl::new)),
            Map.entry(
                    AddedToStackEventSelector.class,
                    new Branch("AddedToStackEvent", AddedToStackEventSelectorImpl::new)),
            Map.entry(AppSelector.class, new Branch("App", AppSelectorImpl::new)),
            Map.entry(AssignedEventSelector.class, new Branch("AssignedEvent", AssignedEventSelectorImpl::new)),
            Map.entry(
                    AutoMergeDisabledEventSelector.class,
                    new Branch("AutoMergeDisabledEvent", AutoMergeDisabledEventSelectorImpl::new)),
            Map.entry(
                    AutoMergeEnabledEventSelector.class,
                    new Branch("AutoMergeEnabledEvent", AutoMergeEnabledEventSelectorImpl::new)),
            Map.entry(
                    AutoRebaseEnabledEventSelector.class,
                    new Branch("AutoRebaseEnabledEvent", AutoRebaseEnabledEventSelectorImpl::new)),
            Map.entry(
                    AutoSquashEnabledEventSelector.class,
                    new Branch("AutoSquashEnabledEvent", AutoSquashEnabledEventSelectorImpl::new)),
            Map.entry(
                    AutomaticBaseChangeFailedEventSelector.class,
                    new Branch("AutomaticBaseChangeFailedEvent", AutomaticBaseChangeFailedEventSelectorImpl::new)),
            Map.entry(
                    AutomaticBaseChangeSucceededEventSelector.class,
                    new Branch(
                            "AutomaticBaseChangeSucceededEvent", AutomaticBaseChangeSucceededEventSelectorImpl::new)),
            Map.entry(
                    BaseRefChangedEventSelector.class,
                    new Branch("BaseRefChangedEvent", BaseRefChangedEventSelectorImpl::new)),
            Map.entry(
                    BaseRefDeletedEventSelector.class,
                    new Branch("BaseRefDeletedEvent", BaseRefDeletedEventSelectorImpl::new)),
            Map.entry(
                    BaseRefForcePushedEventSelector.class,
                    new Branch("BaseRefForcePushedEvent", BaseRefForcePushedEventSelectorImpl::new)),
            Map.entry(BlobSelector.class, new Branch("Blob", BlobSelectorImpl::new)),
            Map.entry(
                    BlockedByAddedEventSelector.class,
                    new Branch("BlockedByAddedEvent", BlockedByAddedEventSelectorImpl::new)),
            Map.entry(
                    BlockedByRemovedEventSelector.class,
                    new Branch("BlockedByRemovedEvent", BlockedByRemovedEventSelectorImpl::new)),
            Map.entry(
                    BlockingAddedEventSelector.class,
                    new Branch("BlockingAddedEvent", BlockingAddedEventSelectorImpl::new)),
            Map.entry(
                    BlockingRemovedEventSelector.class,
                    new Branch("BlockingRemovedEvent", BlockingRemovedEventSelectorImpl::new)),
            Map.entry(BotSelector.class, new Branch("Bot", BotSelectorImpl::new)),
            Map.entry(
                    BranchNamePatternParametersSelector.class,
                    new Branch("BranchNamePatternParameters", BranchNamePatternParametersSelectorImpl::new)),
            Map.entry(
                    BranchProtectionRuleSelector.class,
                    new Branch("BranchProtectionRule", BranchProtectionRuleSelectorImpl::new)),
            Map.entry(
                    BypassForcePushAllowanceSelector.class,
                    new Branch("BypassForcePushAllowance", BypassForcePushAllowanceSelectorImpl::new)),
            Map.entry(
                    BypassPullRequestAllowanceSelector.class,
                    new Branch("BypassPullRequestAllowance", BypassPullRequestAllowanceSelectorImpl::new)),
            Map.entry(CWESelector.class, new Branch("CWE", CWESelectorImpl::new)),
            Map.entry(CheckRunSelector.class, new Branch("CheckRun", CheckRunSelectorImpl::new)),
            Map.entry(CheckSuiteSelector.class, new Branch("CheckSuite", CheckSuiteSelectorImpl::new)),
            Map.entry(ClosedEventSelector.class, new Branch("ClosedEvent", ClosedEventSelectorImpl::new)),
            Map.entry(
                    CodeCoverageParametersSelector.class,
                    new Branch("CodeCoverageParameters", CodeCoverageParametersSelectorImpl::new)),
            Map.entry(CodeOfConductSelector.class, new Branch("CodeOfConduct", CodeOfConductSelectorImpl::new)),
            Map.entry(
                    CodeQualityParametersSelector.class,
                    new Branch("CodeQualityParameters", CodeQualityParametersSelectorImpl::new)),
            Map.entry(
                    CodeScanningParametersSelector.class,
                    new Branch("CodeScanningParameters", CodeScanningParametersSelectorImpl::new)),
            Map.entry(
                    CommentDeletedEventSelector.class,
                    new Branch("CommentDeletedEvent", CommentDeletedEventSelectorImpl::new)),
            Map.entry(CommitSelector.class, new Branch("Commit", CommitSelectorImpl::new)),
            Map.entry(
                    CommitAuthorEmailPatternParametersSelector.class,
                    new Branch(
                            "CommitAuthorEmailPatternParameters", CommitAuthorEmailPatternParametersSelectorImpl::new)),
            Map.entry(CommitCommentSelector.class, new Branch("CommitComment", CommitCommentSelectorImpl::new)),
            Map.entry(
                    CommitCommentThreadSelector.class,
                    new Branch("CommitCommentThread", CommitCommentThreadSelectorImpl::new)),
            Map.entry(
                    CommitMessagePatternParametersSelector.class,
                    new Branch("CommitMessagePatternParameters", CommitMessagePatternParametersSelectorImpl::new)),
            Map.entry(
                    CommitterEmailPatternParametersSelector.class,
                    new Branch("CommitterEmailPatternParameters", CommitterEmailPatternParametersSelectorImpl::new)),
            Map.entry(ComparisonSelector.class, new Branch("Comparison", ComparisonSelectorImpl::new)),
            Map.entry(ConnectedEventSelector.class, new Branch("ConnectedEvent", ConnectedEventSelectorImpl::new)),
            Map.entry(
                    ConvertToDraftEventSelector.class,
                    new Branch("ConvertToDraftEvent", ConvertToDraftEventSelectorImpl::new)),
            Map.entry(
                    ConvertedFromDraftEventSelector.class,
                    new Branch("ConvertedFromDraftEvent", ConvertedFromDraftEventSelectorImpl::new)),
            Map.entry(
                    ConvertedNoteToIssueEventSelector.class,
                    new Branch("ConvertedNoteToIssueEvent", ConvertedNoteToIssueEventSelectorImpl::new)),
            Map.entry(
                    ConvertedToDiscussionEventSelector.class,
                    new Branch("ConvertedToDiscussionEvent", ConvertedToDiscussionEventSelectorImpl::new)),
            Map.entry(
                    CopilotCodeReviewParametersSelector.class,
                    new Branch("CopilotCodeReviewParameters", CopilotCodeReviewParametersSelectorImpl::new)),
            Map.entry(
                    CreatedIssueContributionSelector.class,
                    new Branch("CreatedIssueContribution", CreatedIssueContributionSelectorImpl::new)),
            Map.entry(
                    CreatedPullRequestContributionSelector.class,
                    new Branch("CreatedPullRequestContribution", CreatedPullRequestContributionSelectorImpl::new)),
            Map.entry(
                    CreatedRepositoryContributionSelector.class,
                    new Branch("CreatedRepositoryContribution", CreatedRepositoryContributionSelectorImpl::new)),
            Map.entry(
                    CrossReferencedEventSelector.class,
                    new Branch("CrossReferencedEvent", CrossReferencedEventSelectorImpl::new)),
            Map.entry(
                    DemilestonedEventSelector.class,
                    new Branch("DemilestonedEvent", DemilestonedEventSelectorImpl::new)),
            Map.entry(
                    DependencyGraphManifestSelector.class,
                    new Branch("DependencyGraphManifest", DependencyGraphManifestSelectorImpl::new)),
            Map.entry(DeployKeySelector.class, new Branch("DeployKey", DeployKeySelectorImpl::new)),
            Map.entry(DeployedEventSelector.class, new Branch("DeployedEvent", DeployedEventSelectorImpl::new)),
            Map.entry(DeploymentSelector.class, new Branch("Deployment", DeploymentSelectorImpl::new)),
            Map.entry(
                    DeploymentEnvironmentChangedEventSelector.class,
                    new Branch(
                            "DeploymentEnvironmentChangedEvent", DeploymentEnvironmentChangedEventSelectorImpl::new)),
            Map.entry(
                    DeploymentReviewSelector.class, new Branch("DeploymentReview", DeploymentReviewSelectorImpl::new)),
            Map.entry(
                    DeploymentStatusSelector.class, new Branch("DeploymentStatus", DeploymentStatusSelectorImpl::new)),
            Map.entry(
                    DisconnectedEventSelector.class,
                    new Branch("DisconnectedEvent", DisconnectedEventSelectorImpl::new)),
            Map.entry(DiscussionSelector.class, new Branch("Discussion", DiscussionSelectorImpl::new)),
            Map.entry(
                    DiscussionCategorySelector.class,
                    new Branch("DiscussionCategory", DiscussionCategorySelectorImpl::new)),
            Map.entry(
                    DiscussionCommentSelector.class,
                    new Branch("DiscussionComment", DiscussionCommentSelectorImpl::new)),
            Map.entry(DiscussionPollSelector.class, new Branch("DiscussionPoll", DiscussionPollSelectorImpl::new)),
            Map.entry(
                    DiscussionPollOptionSelector.class,
                    new Branch("DiscussionPollOption", DiscussionPollOptionSelectorImpl::new)),
            Map.entry(DraftIssueSelector.class, new Branch("DraftIssue", DraftIssueSelectorImpl::new)),
            Map.entry(EnterpriseSelector.class, new Branch("Enterprise", EnterpriseSelectorImpl::new)),
            Map.entry(
                    EnterpriseAdministratorInvitationSelector.class,
                    new Branch(
                            "EnterpriseAdministratorInvitation", EnterpriseAdministratorInvitationSelectorImpl::new)),
            Map.entry(
                    EnterpriseIdentityProviderSelector.class,
                    new Branch("EnterpriseIdentityProvider", EnterpriseIdentityProviderSelectorImpl::new)),
            Map.entry(
                    EnterpriseMemberInvitationSelector.class,
                    new Branch("EnterpriseMemberInvitation", EnterpriseMemberInvitationSelectorImpl::new)),
            Map.entry(
                    EnterpriseRepositoryInfoSelector.class,
                    new Branch("EnterpriseRepositoryInfo", EnterpriseRepositoryInfoSelectorImpl::new)),
            Map.entry(
                    EnterpriseServerInstallationSelector.class,
                    new Branch("EnterpriseServerInstallation", EnterpriseServerInstallationSelectorImpl::new)),
            Map.entry(
                    EnterpriseServerUserAccountSelector.class,
                    new Branch("EnterpriseServerUserAccount", EnterpriseServerUserAccountSelectorImpl::new)),
            Map.entry(
                    EnterpriseServerUserAccountEmailSelector.class,
                    new Branch("EnterpriseServerUserAccountEmail", EnterpriseServerUserAccountEmailSelectorImpl::new)),
            Map.entry(
                    EnterpriseServerUserAccountsUploadSelector.class,
                    new Branch(
                            "EnterpriseServerUserAccountsUpload", EnterpriseServerUserAccountsUploadSelectorImpl::new)),
            Map.entry(EnterpriseTeamSelector.class, new Branch("EnterpriseTeam", EnterpriseTeamSelectorImpl::new)),
            Map.entry(
                    EnterpriseUserAccountSelector.class,
                    new Branch("EnterpriseUserAccount", EnterpriseUserAccountSelectorImpl::new)),
            Map.entry(EnvironmentSelector.class, new Branch("Environment", EnvironmentSelectorImpl::new)),
            Map.entry(
                    ExternalIdentitySelector.class, new Branch("ExternalIdentity", ExternalIdentitySelectorImpl::new)),
            Map.entry(
                    FileExtensionRestrictionParametersSelector.class,
                    new Branch(
                            "FileExtensionRestrictionParameters", FileExtensionRestrictionParametersSelectorImpl::new)),
            Map.entry(
                    FilePathRestrictionParametersSelector.class,
                    new Branch("FilePathRestrictionParameters", FilePathRestrictionParametersSelectorImpl::new)),
            Map.entry(
                    GenericHovercardContextSelector.class,
                    new Branch("GenericHovercardContext", GenericHovercardContextSelectorImpl::new)),
            Map.entry(GistSelector.class, new Branch("Gist", GistSelectorImpl::new)),
            Map.entry(GistCommentSelector.class, new Branch("GistComment", GistCommentSelectorImpl::new)),
            Map.entry(GpgSignatureSelector.class, new Branch("GpgSignature", GpgSignatureSelectorImpl::new)),
            Map.entry(
                    HeadRefDeletedEventSelector.class,
                    new Branch("HeadRefDeletedEvent", HeadRefDeletedEventSelectorImpl::new)),
            Map.entry(
                    HeadRefForcePushedEventSelector.class,
                    new Branch("HeadRefForcePushedEvent", HeadRefForcePushedEventSelectorImpl::new)),
            Map.entry(
                    HeadRefRestoredEventSelector.class,
                    new Branch("HeadRefRestoredEvent", HeadRefRestoredEventSelectorImpl::new)),
            Map.entry(
                    IpAllowListEntrySelector.class, new Branch("IpAllowListEntry", IpAllowListEntrySelectorImpl::new)),
            Map.entry(IssueSelector.class, new Branch("Issue", IssueSelectorImpl::new)),
            Map.entry(IssueCommentSelector.class, new Branch("IssueComment", IssueCommentSelectorImpl::new)),
            Map.entry(
                    IssueCommentPinnedEventSelector.class,
                    new Branch("IssueCommentPinnedEvent", IssueCommentPinnedEventSelectorImpl::new)),
            Map.entry(
                    IssueCommentUnpinnedEventSelector.class,
                    new Branch("IssueCommentUnpinnedEvent", IssueCommentUnpinnedEventSelectorImpl::new)),
            Map.entry(
                    IssueFieldAddedEventSelector.class,
                    new Branch("IssueFieldAddedEvent", IssueFieldAddedEventSelectorImpl::new)),
            Map.entry(
                    IssueFieldChangedEventSelector.class,
                    new Branch("IssueFieldChangedEvent", IssueFieldChangedEventSelectorImpl::new)),
            Map.entry(IssueFieldDateSelector.class, new Branch("IssueFieldDate", IssueFieldDateSelectorImpl::new)),
            Map.entry(
                    IssueFieldDateValueSelector.class,
                    new Branch("IssueFieldDateValue", IssueFieldDateValueSelectorImpl::new)),
            Map.entry(
                    IssueFieldMultiSelectSelector.class,
                    new Branch("IssueFieldMultiSelect", IssueFieldMultiSelectSelectorImpl::new)),
            Map.entry(
                    IssueFieldMultiSelectValueSelector.class,
                    new Branch("IssueFieldMultiSelectValue", IssueFieldMultiSelectValueSelectorImpl::new)),
            Map.entry(
                    IssueFieldNumberSelector.class, new Branch("IssueFieldNumber", IssueFieldNumberSelectorImpl::new)),
            Map.entry(
                    IssueFieldNumberValueSelector.class,
                    new Branch("IssueFieldNumberValue", IssueFieldNumberValueSelectorImpl::new)),
            Map.entry(
                    IssueFieldRemovedEventSelector.class,
                    new Branch("IssueFieldRemovedEvent", IssueFieldRemovedEventSelectorImpl::new)),
            Map.entry(
                    IssueFieldSingleSelectSelector.class,
                    new Branch("IssueFieldSingleSelect", IssueFieldSingleSelectSelectorImpl::new)),
            Map.entry(
                    IssueFieldSingleSelectOptionSelector.class,
                    new Branch("IssueFieldSingleSelectOption", IssueFieldSingleSelectOptionSelectorImpl::new)),
            Map.entry(
                    IssueFieldSingleSelectValueSelector.class,
                    new Branch("IssueFieldSingleSelectValue", IssueFieldSingleSelectValueSelectorImpl::new)),
            Map.entry(IssueFieldTextSelector.class, new Branch("IssueFieldText", IssueFieldTextSelectorImpl::new)),
            Map.entry(
                    IssueFieldTextValueSelector.class,
                    new Branch("IssueFieldTextValue", IssueFieldTextValueSelectorImpl::new)),
            Map.entry(IssueTypeSelector.class, new Branch("IssueType", IssueTypeSelectorImpl::new)),
            Map.entry(
                    IssueTypeAddedEventSelector.class,
                    new Branch("IssueTypeAddedEvent", IssueTypeAddedEventSelectorImpl::new)),
            Map.entry(
                    IssueTypeChangedEventSelector.class,
                    new Branch("IssueTypeChangedEvent", IssueTypeChangedEventSelectorImpl::new)),
            Map.entry(
                    IssueTypeRemovedEventSelector.class,
                    new Branch("IssueTypeRemovedEvent", IssueTypeRemovedEventSelectorImpl::new)),
            Map.entry(LabelSelector.class, new Branch("Label", LabelSelectorImpl::new)),
            Map.entry(LabeledEventSelector.class, new Branch("LabeledEvent", LabeledEventSelectorImpl::new)),
            Map.entry(LanguageSelector.class, new Branch("Language", LanguageSelectorImpl::new)),
            Map.entry(LicenseSelector.class, new Branch("License", LicenseSelectorImpl::new)),
            Map.entry(LinkedBranchSelector.class, new Branch("LinkedBranch", LinkedBranchSelectorImpl::new)),
            Map.entry(LockedEventSelector.class, new Branch("LockedEvent", LockedEventSelectorImpl::new)),
            Map.entry(MannequinSelector.class, new Branch("Mannequin", MannequinSelectorImpl::new)),
            Map.entry(
                    MarkedAsDuplicateEventSelector.class,
                    new Branch("MarkedAsDuplicateEvent", MarkedAsDuplicateEventSelectorImpl::new)),
            Map.entry(
                    MarketplaceCategorySelector.class,
                    new Branch("MarketplaceCategory", MarketplaceCategorySelectorImpl::new)),
            Map.entry(
                    MarketplaceListingSelector.class,
                    new Branch("MarketplaceListing", MarketplaceListingSelectorImpl::new)),
            Map.entry(
                    MaxFilePathLengthParametersSelector.class,
                    new Branch("MaxFilePathLengthParameters", MaxFilePathLengthParametersSelectorImpl::new)),
            Map.entry(
                    MaxFileSizeParametersSelector.class,
                    new Branch("MaxFileSizeParameters", MaxFileSizeParametersSelectorImpl::new)),
            Map.entry(
                    MemberFeatureRequestNotificationSelector.class,
                    new Branch("MemberFeatureRequestNotification", MemberFeatureRequestNotificationSelectorImpl::new)),
            Map.entry(
                    MembersCanDeleteReposClearAuditEntrySelector.class,
                    new Branch(
                            "MembersCanDeleteReposClearAuditEntry",
                            MembersCanDeleteReposClearAuditEntrySelectorImpl::new)),
            Map.entry(
                    MembersCanDeleteReposDisableAuditEntrySelector.class,
                    new Branch(
                            "MembersCanDeleteReposDisableAuditEntry",
                            MembersCanDeleteReposDisableAuditEntrySelectorImpl::new)),
            Map.entry(
                    MembersCanDeleteReposEnableAuditEntrySelector.class,
                    new Branch(
                            "MembersCanDeleteReposEnableAuditEntry",
                            MembersCanDeleteReposEnableAuditEntrySelectorImpl::new)),
            Map.entry(MentionedEventSelector.class, new Branch("MentionedEvent", MentionedEventSelectorImpl::new)),
            Map.entry(MergeQueueSelector.class, new Branch("MergeQueue", MergeQueueSelectorImpl::new)),
            Map.entry(MergeQueueEntrySelector.class, new Branch("MergeQueueEntry", MergeQueueEntrySelectorImpl::new)),
            Map.entry(
                    MergeQueueParametersSelector.class,
                    new Branch("MergeQueueParameters", MergeQueueParametersSelectorImpl::new)),
            Map.entry(MergedEventSelector.class, new Branch("MergedEvent", MergedEventSelectorImpl::new)),
            Map.entry(MigrationSourceSelector.class, new Branch("MigrationSource", MigrationSourceSelectorImpl::new)),
            Map.entry(MilestoneSelector.class, new Branch("Milestone", MilestoneSelectorImpl::new)),
            Map.entry(MilestonedEventSelector.class, new Branch("MilestonedEvent", MilestonedEventSelectorImpl::new)),
            Map.entry(
                    MovedColumnsInProjectEventSelector.class,
                    new Branch("MovedColumnsInProjectEvent", MovedColumnsInProjectEventSelectorImpl::new)),
            Map.entry(OIDCProviderSelector.class, new Branch("OIDCProvider", OIDCProviderSelectorImpl::new)),
            Map.entry(
                    OauthApplicationCreateAuditEntrySelector.class,
                    new Branch("OauthApplicationCreateAuditEntry", OauthApplicationCreateAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgAddBillingManagerAuditEntrySelector.class,
                    new Branch("OrgAddBillingManagerAuditEntry", OrgAddBillingManagerAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgAddMemberAuditEntrySelector.class,
                    new Branch("OrgAddMemberAuditEntry", OrgAddMemberAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgBlockUserAuditEntrySelector.class,
                    new Branch("OrgBlockUserAuditEntry", OrgBlockUserAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgConfigDisableCollaboratorsOnlyAuditEntrySelector.class,
                    new Branch(
                            "OrgConfigDisableCollaboratorsOnlyAuditEntry",
                            OrgConfigDisableCollaboratorsOnlyAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgConfigEnableCollaboratorsOnlyAuditEntrySelector.class,
                    new Branch(
                            "OrgConfigEnableCollaboratorsOnlyAuditEntry",
                            OrgConfigEnableCollaboratorsOnlyAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgCreateAuditEntrySelector.class,
                    new Branch("OrgCreateAuditEntry", OrgCreateAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgDisableOauthAppRestrictionsAuditEntrySelector.class,
                    new Branch(
                            "OrgDisableOauthAppRestrictionsAuditEntry",
                            OrgDisableOauthAppRestrictionsAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgDisableSamlAuditEntrySelector.class,
                    new Branch("OrgDisableSamlAuditEntry", OrgDisableSamlAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgDisableTwoFactorRequirementAuditEntrySelector.class,
                    new Branch(
                            "OrgDisableTwoFactorRequirementAuditEntry",
                            OrgDisableTwoFactorRequirementAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgEnableOauthAppRestrictionsAuditEntrySelector.class,
                    new Branch(
                            "OrgEnableOauthAppRestrictionsAuditEntry",
                            OrgEnableOauthAppRestrictionsAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgEnableSamlAuditEntrySelector.class,
                    new Branch("OrgEnableSamlAuditEntry", OrgEnableSamlAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgEnableTwoFactorRequirementAuditEntrySelector.class,
                    new Branch(
                            "OrgEnableTwoFactorRequirementAuditEntry",
                            OrgEnableTwoFactorRequirementAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgInviteMemberAuditEntrySelector.class,
                    new Branch("OrgInviteMemberAuditEntry", OrgInviteMemberAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgInviteToBusinessAuditEntrySelector.class,
                    new Branch("OrgInviteToBusinessAuditEntry", OrgInviteToBusinessAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgOauthAppAccessApprovedAuditEntrySelector.class,
                    new Branch(
                            "OrgOauthAppAccessApprovedAuditEntry",
                            OrgOauthAppAccessApprovedAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgOauthAppAccessBlockedAuditEntrySelector.class,
                    new Branch(
                            "OrgOauthAppAccessBlockedAuditEntry", OrgOauthAppAccessBlockedAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgOauthAppAccessDeniedAuditEntrySelector.class,
                    new Branch(
                            "OrgOauthAppAccessDeniedAuditEntry", OrgOauthAppAccessDeniedAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgOauthAppAccessRequestedAuditEntrySelector.class,
                    new Branch(
                            "OrgOauthAppAccessRequestedAuditEntry",
                            OrgOauthAppAccessRequestedAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgOauthAppAccessUnblockedAuditEntrySelector.class,
                    new Branch(
                            "OrgOauthAppAccessUnblockedAuditEntry",
                            OrgOauthAppAccessUnblockedAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgRemoveBillingManagerAuditEntrySelector.class,
                    new Branch(
                            "OrgRemoveBillingManagerAuditEntry", OrgRemoveBillingManagerAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgRemoveMemberAuditEntrySelector.class,
                    new Branch("OrgRemoveMemberAuditEntry", OrgRemoveMemberAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgRemoveOutsideCollaboratorAuditEntrySelector.class,
                    new Branch(
                            "OrgRemoveOutsideCollaboratorAuditEntry",
                            OrgRemoveOutsideCollaboratorAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgRestoreMemberAuditEntrySelector.class,
                    new Branch("OrgRestoreMemberAuditEntry", OrgRestoreMemberAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgRestoreMemberMembershipOrganizationAuditEntryDataSelector.class,
                    new Branch(
                            "OrgRestoreMemberMembershipOrganizationAuditEntryData",
                            OrgRestoreMemberMembershipOrganizationAuditEntryDataSelectorImpl::new)),
            Map.entry(
                    OrgRestoreMemberMembershipRepositoryAuditEntryDataSelector.class,
                    new Branch(
                            "OrgRestoreMemberMembershipRepositoryAuditEntryData",
                            OrgRestoreMemberMembershipRepositoryAuditEntryDataSelectorImpl::new)),
            Map.entry(
                    OrgRestoreMemberMembershipTeamAuditEntryDataSelector.class,
                    new Branch(
                            "OrgRestoreMemberMembershipTeamAuditEntryData",
                            OrgRestoreMemberMembershipTeamAuditEntryDataSelectorImpl::new)),
            Map.entry(
                    OrgUnblockUserAuditEntrySelector.class,
                    new Branch("OrgUnblockUserAuditEntry", OrgUnblockUserAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgUpdateDefaultRepositoryPermissionAuditEntrySelector.class,
                    new Branch(
                            "OrgUpdateDefaultRepositoryPermissionAuditEntry",
                            OrgUpdateDefaultRepositoryPermissionAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgUpdateMemberAuditEntrySelector.class,
                    new Branch("OrgUpdateMemberAuditEntry", OrgUpdateMemberAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgUpdateMemberRepositoryCreationPermissionAuditEntrySelector.class,
                    new Branch(
                            "OrgUpdateMemberRepositoryCreationPermissionAuditEntry",
                            OrgUpdateMemberRepositoryCreationPermissionAuditEntrySelectorImpl::new)),
            Map.entry(
                    OrgUpdateMemberRepositoryInvitationPermissionAuditEntrySelector.class,
                    new Branch(
                            "OrgUpdateMemberRepositoryInvitationPermissionAuditEntry",
                            OrgUpdateMemberRepositoryInvitationPermissionAuditEntrySelectorImpl::new)),
            Map.entry(OrganizationSelector.class, new Branch("Organization", OrganizationSelectorImpl::new)),
            Map.entry(
                    OrganizationIdentityProviderSelector.class,
                    new Branch("OrganizationIdentityProvider", OrganizationIdentityProviderSelectorImpl::new)),
            Map.entry(
                    OrganizationInvitationSelector.class,
                    new Branch("OrganizationInvitation", OrganizationInvitationSelectorImpl::new)),
            Map.entry(
                    OrganizationMigrationSelector.class,
                    new Branch("OrganizationMigration", OrganizationMigrationSelectorImpl::new)),
            Map.entry(
                    OrganizationTeamsHovercardContextSelector.class,
                    new Branch(
                            "OrganizationTeamsHovercardContext", OrganizationTeamsHovercardContextSelectorImpl::new)),
            Map.entry(
                    OrganizationsHovercardContextSelector.class,
                    new Branch("OrganizationsHovercardContext", OrganizationsHovercardContextSelectorImpl::new)),
            Map.entry(PackageSelector.class, new Branch("Package", PackageSelectorImpl::new)),
            Map.entry(PackageFileSelector.class, new Branch("PackageFile", PackageFileSelectorImpl::new)),
            Map.entry(PackageTagSelector.class, new Branch("PackageTag", PackageTagSelectorImpl::new)),
            Map.entry(PackageVersionSelector.class, new Branch("PackageVersion", PackageVersionSelectorImpl::new)),
            Map.entry(
                    ParentIssueAddedEventSelector.class,
                    new Branch("ParentIssueAddedEvent", ParentIssueAddedEventSelectorImpl::new)),
            Map.entry(
                    ParentIssueRemovedEventSelector.class,
                    new Branch("ParentIssueRemovedEvent", ParentIssueRemovedEventSelectorImpl::new)),
            Map.entry(
                    PendingAssigneeSuggestionSelector.class,
                    new Branch("PendingAssigneeSuggestion", PendingAssigneeSuggestionSelectorImpl::new)),
            Map.entry(
                    PendingCloseSuggestionSelector.class,
                    new Branch("PendingCloseSuggestion", PendingCloseSuggestionSelectorImpl::new)),
            Map.entry(
                    PendingFieldSuggestionSelector.class,
                    new Branch("PendingFieldSuggestion", PendingFieldSuggestionSelectorImpl::new)),
            Map.entry(
                    PendingLabelSuggestionSelector.class,
                    new Branch("PendingLabelSuggestion", PendingLabelSuggestionSelectorImpl::new)),
            Map.entry(
                    PendingTypeSuggestionSelector.class,
                    new Branch("PendingTypeSuggestion", PendingTypeSuggestionSelectorImpl::new)),
            Map.entry(
                    PinnedDiscussionSelector.class, new Branch("PinnedDiscussion", PinnedDiscussionSelectorImpl::new)),
            Map.entry(
                    PinnedEnvironmentSelector.class,
                    new Branch("PinnedEnvironment", PinnedEnvironmentSelectorImpl::new)),
            Map.entry(PinnedEventSelector.class, new Branch("PinnedEvent", PinnedEventSelectorImpl::new)),
            Map.entry(PinnedIssueSelector.class, new Branch("PinnedIssue", PinnedIssueSelectorImpl::new)),
            Map.entry(
                    PinnedIssueCommentSelector.class,
                    new Branch("PinnedIssueComment", PinnedIssueCommentSelectorImpl::new)),
            Map.entry(
                    PrivateRepositoryForkingDisableAuditEntrySelector.class,
                    new Branch(
                            "PrivateRepositoryForkingDisableAuditEntry",
                            PrivateRepositoryForkingDisableAuditEntrySelectorImpl::new)),
            Map.entry(
                    PrivateRepositoryForkingEnableAuditEntrySelector.class,
                    new Branch(
                            "PrivateRepositoryForkingEnableAuditEntry",
                            PrivateRepositoryForkingEnableAuditEntrySelectorImpl::new)),
            Map.entry(ProjectSelector.class, new Branch("Project", ProjectSelectorImpl::new)),
            Map.entry(ProjectCardSelector.class, new Branch("ProjectCard", ProjectCardSelectorImpl::new)),
            Map.entry(ProjectColumnSelector.class, new Branch("ProjectColumn", ProjectColumnSelectorImpl::new)),
            Map.entry(ProjectV2Selector.class, new Branch("ProjectV2", ProjectV2SelectorImpl::new)),
            Map.entry(ProjectV2FieldSelector.class, new Branch("ProjectV2Field", ProjectV2FieldSelectorImpl::new)),
            Map.entry(ProjectV2ItemSelector.class, new Branch("ProjectV2Item", ProjectV2ItemSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldDateValueSelector.class,
                    new Branch("ProjectV2ItemFieldDateValue", ProjectV2ItemFieldDateValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldIterationValueSelector.class,
                    new Branch("ProjectV2ItemFieldIterationValue", ProjectV2ItemFieldIterationValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldLabelValueSelector.class,
                    new Branch("ProjectV2ItemFieldLabelValue", ProjectV2ItemFieldLabelValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldMilestoneValueSelector.class,
                    new Branch("ProjectV2ItemFieldMilestoneValue", ProjectV2ItemFieldMilestoneValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldMultiSelectValueSelector.class,
                    new Branch(
                            "ProjectV2ItemFieldMultiSelectValue", ProjectV2ItemFieldMultiSelectValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldNumberValueSelector.class,
                    new Branch("ProjectV2ItemFieldNumberValue", ProjectV2ItemFieldNumberValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldPullRequestValueSelector.class,
                    new Branch(
                            "ProjectV2ItemFieldPullRequestValue", ProjectV2ItemFieldPullRequestValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldRepositoryValueSelector.class,
                    new Branch(
                            "ProjectV2ItemFieldRepositoryValue", ProjectV2ItemFieldRepositoryValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldReviewerValueSelector.class,
                    new Branch("ProjectV2ItemFieldReviewerValue", ProjectV2ItemFieldReviewerValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldSingleSelectValueSelector.class,
                    new Branch(
                            "ProjectV2ItemFieldSingleSelectValue",
                            ProjectV2ItemFieldSingleSelectValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldTextValueSelector.class,
                    new Branch("ProjectV2ItemFieldTextValue", ProjectV2ItemFieldTextValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemFieldUserValueSelector.class,
                    new Branch("ProjectV2ItemFieldUserValue", ProjectV2ItemFieldUserValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemIssueFieldValueSelector.class,
                    new Branch("ProjectV2ItemIssueFieldValue", ProjectV2ItemIssueFieldValueSelectorImpl::new)),
            Map.entry(
                    ProjectV2ItemStatusChangedEventSelector.class,
                    new Branch("ProjectV2ItemStatusChangedEvent", ProjectV2ItemStatusChangedEventSelectorImpl::new)),
            Map.entry(
                    ProjectV2IterationFieldSelector.class,
                    new Branch("ProjectV2IterationField", ProjectV2IterationFieldSelectorImpl::new)),
            Map.entry(
                    ProjectV2MultiSelectFieldSelector.class,
                    new Branch("ProjectV2MultiSelectField", ProjectV2MultiSelectFieldSelectorImpl::new)),
            Map.entry(
                    ProjectV2SingleSelectFieldSelector.class,
                    new Branch("ProjectV2SingleSelectField", ProjectV2SingleSelectFieldSelectorImpl::new)),
            Map.entry(
                    ProjectV2StatusUpdateSelector.class,
                    new Branch("ProjectV2StatusUpdate", ProjectV2StatusUpdateSelectorImpl::new)),
            Map.entry(ProjectV2ViewSelector.class, new Branch("ProjectV2View", ProjectV2ViewSelectorImpl::new)),
            Map.entry(
                    ProjectV2WorkflowSelector.class,
                    new Branch("ProjectV2Workflow", ProjectV2WorkflowSelectorImpl::new)),
            Map.entry(PublicKeySelector.class, new Branch("PublicKey", PublicKeySelectorImpl::new)),
            Map.entry(PullRequestSelector.class, new Branch("PullRequest", PullRequestSelectorImpl::new)),
            Map.entry(
                    PullRequestCommitSelector.class,
                    new Branch("PullRequestCommit", PullRequestCommitSelectorImpl::new)),
            Map.entry(
                    PullRequestCommitCommentThreadSelector.class,
                    new Branch("PullRequestCommitCommentThread", PullRequestCommitCommentThreadSelectorImpl::new)),
            Map.entry(
                    PullRequestParametersSelector.class,
                    new Branch("PullRequestParameters", PullRequestParametersSelectorImpl::new)),
            Map.entry(
                    PullRequestReviewSelector.class,
                    new Branch("PullRequestReview", PullRequestReviewSelectorImpl::new)),
            Map.entry(
                    PullRequestReviewCommentSelector.class,
                    new Branch("PullRequestReviewComment", PullRequestReviewCommentSelectorImpl::new)),
            Map.entry(
                    PullRequestReviewThreadSelector.class,
                    new Branch("PullRequestReviewThread", PullRequestReviewThreadSelectorImpl::new)),
            Map.entry(
                    PullRequestRevisionMarkerSelector.class,
                    new Branch("PullRequestRevisionMarker", PullRequestRevisionMarkerSelectorImpl::new)),
            Map.entry(
                    PullRequestStackSelector.class, new Branch("PullRequestStack", PullRequestStackSelectorImpl::new)),
            Map.entry(
                    PullRequestStackEntrySelector.class,
                    new Branch("PullRequestStackEntry", PullRequestStackEntrySelectorImpl::new)),
            Map.entry(
                    PullRequestThreadSelector.class,
                    new Branch("PullRequestThread", PullRequestThreadSelectorImpl::new)),
            Map.entry(PushSelector.class, new Branch("Push", PushSelectorImpl::new)),
            Map.entry(PushAllowanceSelector.class, new Branch("PushAllowance", PushAllowanceSelectorImpl::new)),
            Map.entry(QuerySelector.class, new Branch("Query", QuerySelectorImpl::new)),
            Map.entry(ReactionSelector.class, new Branch("Reaction", ReactionSelectorImpl::new)),
            Map.entry(
                    ReadyForReviewEventSelector.class,
                    new Branch("ReadyForReviewEvent", ReadyForReviewEventSelectorImpl::new)),
            Map.entry(RefSelector.class, new Branch("Ref", RefSelectorImpl::new)),
            Map.entry(ReferencedEventSelector.class, new Branch("ReferencedEvent", ReferencedEventSelectorImpl::new)),
            Map.entry(ReleaseSelector.class, new Branch("Release", ReleaseSelectorImpl::new)),
            Map.entry(ReleaseAssetSelector.class, new Branch("ReleaseAsset", ReleaseAssetSelectorImpl::new)),
            Map.entry(
                    RemovedFromMergeQueueEventSelector.class,
                    new Branch("RemovedFromMergeQueueEvent", RemovedFromMergeQueueEventSelectorImpl::new)),
            Map.entry(
                    RemovedFromProjectEventSelector.class,
                    new Branch("RemovedFromProjectEvent", RemovedFromProjectEventSelectorImpl::new)),
            Map.entry(
                    RemovedFromProjectV2EventSelector.class,
                    new Branch("RemovedFromProjectV2Event", RemovedFromProjectV2EventSelectorImpl::new)),
            Map.entry(
                    RemovedFromStackEventSelector.class,
                    new Branch("RemovedFromStackEvent", RemovedFromStackEventSelectorImpl::new)),
            Map.entry(
                    RenamedTitleEventSelector.class,
                    new Branch("RenamedTitleEvent", RenamedTitleEventSelectorImpl::new)),
            Map.entry(ReopenedEventSelector.class, new Branch("ReopenedEvent", ReopenedEventSelectorImpl::new)),
            Map.entry(
                    RepoAccessAuditEntrySelector.class,
                    new Branch("RepoAccessAuditEntry", RepoAccessAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoAddMemberAuditEntrySelector.class,
                    new Branch("RepoAddMemberAuditEntry", RepoAddMemberAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoAddTopicAuditEntrySelector.class,
                    new Branch("RepoAddTopicAuditEntry", RepoAddTopicAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoArchivedAuditEntrySelector.class,
                    new Branch("RepoArchivedAuditEntry", RepoArchivedAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoChangeMergeSettingAuditEntrySelector.class,
                    new Branch("RepoChangeMergeSettingAuditEntry", RepoChangeMergeSettingAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoConfigDisableAnonymousGitAccessAuditEntrySelector.class,
                    new Branch(
                            "RepoConfigDisableAnonymousGitAccessAuditEntry",
                            RepoConfigDisableAnonymousGitAccessAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoConfigDisableCollaboratorsOnlyAuditEntrySelector.class,
                    new Branch(
                            "RepoConfigDisableCollaboratorsOnlyAuditEntry",
                            RepoConfigDisableCollaboratorsOnlyAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoConfigDisableContributorsOnlyAuditEntrySelector.class,
                    new Branch(
                            "RepoConfigDisableContributorsOnlyAuditEntry",
                            RepoConfigDisableContributorsOnlyAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoConfigDisableSockpuppetDisallowedAuditEntrySelector.class,
                    new Branch(
                            "RepoConfigDisableSockpuppetDisallowedAuditEntry",
                            RepoConfigDisableSockpuppetDisallowedAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoConfigEnableAnonymousGitAccessAuditEntrySelector.class,
                    new Branch(
                            "RepoConfigEnableAnonymousGitAccessAuditEntry",
                            RepoConfigEnableAnonymousGitAccessAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoConfigEnableCollaboratorsOnlyAuditEntrySelector.class,
                    new Branch(
                            "RepoConfigEnableCollaboratorsOnlyAuditEntry",
                            RepoConfigEnableCollaboratorsOnlyAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoConfigEnableContributorsOnlyAuditEntrySelector.class,
                    new Branch(
                            "RepoConfigEnableContributorsOnlyAuditEntry",
                            RepoConfigEnableContributorsOnlyAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoConfigEnableSockpuppetDisallowedAuditEntrySelector.class,
                    new Branch(
                            "RepoConfigEnableSockpuppetDisallowedAuditEntry",
                            RepoConfigEnableSockpuppetDisallowedAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoConfigLockAnonymousGitAccessAuditEntrySelector.class,
                    new Branch(
                            "RepoConfigLockAnonymousGitAccessAuditEntry",
                            RepoConfigLockAnonymousGitAccessAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoConfigUnlockAnonymousGitAccessAuditEntrySelector.class,
                    new Branch(
                            "RepoConfigUnlockAnonymousGitAccessAuditEntry",
                            RepoConfigUnlockAnonymousGitAccessAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoCreateAuditEntrySelector.class,
                    new Branch("RepoCreateAuditEntry", RepoCreateAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoDestroyAuditEntrySelector.class,
                    new Branch("RepoDestroyAuditEntry", RepoDestroyAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoRemoveMemberAuditEntrySelector.class,
                    new Branch("RepoRemoveMemberAuditEntry", RepoRemoveMemberAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepoRemoveTopicAuditEntrySelector.class,
                    new Branch("RepoRemoveTopicAuditEntry", RepoRemoveTopicAuditEntrySelectorImpl::new)),
            Map.entry(RepositorySelector.class, new Branch("Repository", RepositorySelectorImpl::new)),
            Map.entry(
                    RepositoryCustomPropertySelector.class,
                    new Branch("RepositoryCustomProperty", RepositoryCustomPropertySelectorImpl::new)),
            Map.entry(
                    RepositoryInvitationSelector.class,
                    new Branch("RepositoryInvitation", RepositoryInvitationSelectorImpl::new)),
            Map.entry(
                    RepositoryMigrationSelector.class,
                    new Branch("RepositoryMigration", RepositoryMigrationSelectorImpl::new)),
            Map.entry(RepositoryRuleSelector.class, new Branch("RepositoryRule", RepositoryRuleSelectorImpl::new)),
            Map.entry(
                    RepositoryRulesetSelector.class,
                    new Branch("RepositoryRuleset", RepositoryRulesetSelectorImpl::new)),
            Map.entry(
                    RepositoryRulesetBypassActorSelector.class,
                    new Branch("RepositoryRulesetBypassActor", RepositoryRulesetBypassActorSelectorImpl::new)),
            Map.entry(RepositoryTopicSelector.class, new Branch("RepositoryTopic", RepositoryTopicSelectorImpl::new)),
            Map.entry(
                    RepositoryVisibilityChangeDisableAuditEntrySelector.class,
                    new Branch(
                            "RepositoryVisibilityChangeDisableAuditEntry",
                            RepositoryVisibilityChangeDisableAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepositoryVisibilityChangeEnableAuditEntrySelector.class,
                    new Branch(
                            "RepositoryVisibilityChangeEnableAuditEntry",
                            RepositoryVisibilityChangeEnableAuditEntrySelectorImpl::new)),
            Map.entry(
                    RepositoryVulnerabilityAlertSelector.class,
                    new Branch("RepositoryVulnerabilityAlert", RepositoryVulnerabilityAlertSelectorImpl::new)),
            Map.entry(
                    RequiredDeploymentsParametersSelector.class,
                    new Branch("RequiredDeploymentsParameters", RequiredDeploymentsParametersSelectorImpl::new)),
            Map.entry(
                    RequiredStatusChecksParametersSelector.class,
                    new Branch("RequiredStatusChecksParameters", RequiredStatusChecksParametersSelectorImpl::new)),
            Map.entry(
                    RestrictedContributionSelector.class,
                    new Branch("RestrictedContribution", RestrictedContributionSelectorImpl::new)),
            Map.entry(
                    ReviewDismissalAllowanceSelector.class,
                    new Branch("ReviewDismissalAllowance", ReviewDismissalAllowanceSelectorImpl::new)),
            Map.entry(
                    ReviewDismissedEventSelector.class,
                    new Branch("ReviewDismissedEvent", ReviewDismissedEventSelectorImpl::new)),
            Map.entry(ReviewRequestSelector.class, new Branch("ReviewRequest", ReviewRequestSelectorImpl::new)),
            Map.entry(
                    ReviewRequestRemovedEventSelector.class,
                    new Branch("ReviewRequestRemovedEvent", ReviewRequestRemovedEventSelectorImpl::new)),
            Map.entry(
                    ReviewRequestedEventSelector.class,
                    new Branch("ReviewRequestedEvent", ReviewRequestedEventSelectorImpl::new)),
            Map.entry(
                    ReviewStatusHovercardContextSelector.class,
                    new Branch("ReviewStatusHovercardContext", ReviewStatusHovercardContextSelectorImpl::new)),
            Map.entry(SavedReplySelector.class, new Branch("SavedReply", SavedReplySelectorImpl::new)),
            Map.entry(
                    SecurityAdvisorySelector.class, new Branch("SecurityAdvisory", SecurityAdvisorySelectorImpl::new)),
            Map.entry(SmimeSignatureSelector.class, new Branch("SmimeSignature", SmimeSignatureSelectorImpl::new)),
            Map.entry(
                    SponsorsActivitySelector.class, new Branch("SponsorsActivity", SponsorsActivitySelectorImpl::new)),
            Map.entry(SponsorsListingSelector.class, new Branch("SponsorsListing", SponsorsListingSelectorImpl::new)),
            Map.entry(
                    SponsorsListingFeaturedItemSelector.class,
                    new Branch("SponsorsListingFeaturedItem", SponsorsListingFeaturedItemSelectorImpl::new)),
            Map.entry(SponsorsTierSelector.class, new Branch("SponsorsTier", SponsorsTierSelectorImpl::new)),
            Map.entry(SponsorshipSelector.class, new Branch("Sponsorship", SponsorshipSelectorImpl::new)),
            Map.entry(
                    SponsorshipNewsletterSelector.class,
                    new Branch("SponsorshipNewsletter", SponsorshipNewsletterSelectorImpl::new)),
            Map.entry(SshSignatureSelector.class, new Branch("SshSignature", SshSignatureSelectorImpl::new)),
            Map.entry(StatusSelector.class, new Branch("Status", StatusSelectorImpl::new)),
            Map.entry(
                    StatusCheckRollupSelector.class,
                    new Branch("StatusCheckRollup", StatusCheckRollupSelectorImpl::new)),
            Map.entry(StatusContextSelector.class, new Branch("StatusContext", StatusContextSelectorImpl::new)),
            Map.entry(
                    SubIssueAddedEventSelector.class,
                    new Branch("SubIssueAddedEvent", SubIssueAddedEventSelectorImpl::new)),
            Map.entry(
                    SubIssueRemovedEventSelector.class,
                    new Branch("SubIssueRemovedEvent", SubIssueRemovedEventSelectorImpl::new)),
            Map.entry(SubscribedEventSelector.class, new Branch("SubscribedEvent", SubscribedEventSelectorImpl::new)),
            Map.entry(TagSelector.class, new Branch("Tag", TagSelectorImpl::new)),
            Map.entry(
                    TagNamePatternParametersSelector.class,
                    new Branch("TagNamePatternParameters", TagNamePatternParametersSelectorImpl::new)),
            Map.entry(TeamSelector.class, new Branch("Team", TeamSelectorImpl::new)),
            Map.entry(
                    TeamAddMemberAuditEntrySelector.class,
                    new Branch("TeamAddMemberAuditEntry", TeamAddMemberAuditEntrySelectorImpl::new)),
            Map.entry(
                    TeamAddRepositoryAuditEntrySelector.class,
                    new Branch("TeamAddRepositoryAuditEntry", TeamAddRepositoryAuditEntrySelectorImpl::new)),
            Map.entry(
                    TeamChangeParentTeamAuditEntrySelector.class,
                    new Branch("TeamChangeParentTeamAuditEntry", TeamChangeParentTeamAuditEntrySelectorImpl::new)),
            Map.entry(
                    TeamRemoveMemberAuditEntrySelector.class,
                    new Branch("TeamRemoveMemberAuditEntry", TeamRemoveMemberAuditEntrySelectorImpl::new)),
            Map.entry(
                    TeamRemoveRepositoryAuditEntrySelector.class,
                    new Branch("TeamRemoveRepositoryAuditEntry", TeamRemoveRepositoryAuditEntrySelectorImpl::new)),
            Map.entry(TopicSelector.class, new Branch("Topic", TopicSelectorImpl::new)),
            Map.entry(
                    TransferredEventSelector.class, new Branch("TransferredEvent", TransferredEventSelectorImpl::new)),
            Map.entry(TreeSelector.class, new Branch("Tree", TreeSelectorImpl::new)),
            Map.entry(UnassignedEventSelector.class, new Branch("UnassignedEvent", UnassignedEventSelectorImpl::new)),
            Map.entry(
                    UnknownSignatureSelector.class, new Branch("UnknownSignature", UnknownSignatureSelectorImpl::new)),
            Map.entry(UnlabeledEventSelector.class, new Branch("UnlabeledEvent", UnlabeledEventSelectorImpl::new)),
            Map.entry(UnlockedEventSelector.class, new Branch("UnlockedEvent", UnlockedEventSelectorImpl::new)),
            Map.entry(
                    UnmarkedAsDuplicateEventSelector.class,
                    new Branch("UnmarkedAsDuplicateEvent", UnmarkedAsDuplicateEventSelectorImpl::new)),
            Map.entry(UnpinnedEventSelector.class, new Branch("UnpinnedEvent", UnpinnedEventSelectorImpl::new)),
            Map.entry(
                    UnsubscribedEventSelector.class,
                    new Branch("UnsubscribedEvent", UnsubscribedEventSelectorImpl::new)),
            Map.entry(
                    UpdateParametersSelector.class, new Branch("UpdateParameters", UpdateParametersSelectorImpl::new)),
            Map.entry(UserSelector.class, new Branch("User", UserSelectorImpl::new)),
            Map.entry(
                    UserBlockedEventSelector.class, new Branch("UserBlockedEvent", UserBlockedEventSelectorImpl::new)),
            Map.entry(UserContentEditSelector.class, new Branch("UserContentEdit", UserContentEditSelectorImpl::new)),
            Map.entry(UserListSelector.class, new Branch("UserList", UserListSelectorImpl::new)),
            Map.entry(
                    UserNamespaceRepositorySelector.class,
                    new Branch("UserNamespaceRepository", UserNamespaceRepositorySelectorImpl::new)),
            Map.entry(UserStatusSelector.class, new Branch("UserStatus", UserStatusSelectorImpl::new)),
            Map.entry(
                    VerifiableDomainSelector.class, new Branch("VerifiableDomain", VerifiableDomainSelectorImpl::new)),
            Map.entry(
                    ViewerHovercardContextSelector.class,
                    new Branch("ViewerHovercardContext", ViewerHovercardContextSelectorImpl::new)),
            Map.entry(WorkflowSelector.class, new Branch("Workflow", WorkflowSelectorImpl::new)),
            Map.entry(WorkflowRunSelector.class, new Branch("WorkflowRun", WorkflowRunSelectorImpl::new)),
            Map.entry(WorkflowRunFileSelector.class, new Branch("WorkflowRunFile", WorkflowRunFileSelectorImpl::new)),
            Map.entry(
                    WorkflowsParametersSelector.class,
                    new Branch("WorkflowsParameters", WorkflowsParametersSelectorImpl::new)));

    private static final Map<Class<?>, Set<Class<?>>> POSSIBLE = Map.ofEntries(
            Map.entry(
                    ActorSelector.class,
                    Set.<Class<?>>of(
                            BotSelector.class,
                            EnterpriseUserAccountSelector.class,
                            MannequinSelector.class,
                            OrganizationSelector.class,
                            UserSelector.class)),
            Map.entry(AssignableSelector.class, Set.<Class<?>>of(IssueSelector.class, PullRequestSelector.class)),
            Map.entry(
                    AssigneeSelector.class,
                    Set.<Class<?>>of(
                            BotSelector.class,
                            MannequinSelector.class,
                            OrganizationSelector.class,
                            UserSelector.class)),
            Map.entry(
                    AuditEntryActorSelector.class,
                    Set.<Class<?>>of(BotSelector.class, OrganizationSelector.class, UserSelector.class)),
            Map.entry(
                    BranchActorAllowanceActorSelector.class,
                    Set.<Class<?>>of(AppSelector.class, TeamSelector.class, UserSelector.class)),
            Map.entry(
                    BypassActorSelector.class,
                    Set.<Class<?>>of(
                            AppSelector.class, EnterpriseTeamSelector.class, TeamSelector.class, UserSelector.class)),
            Map.entry(ClaimableSelector.class, Set.<Class<?>>of(MannequinSelector.class, UserSelector.class)),
            Map.entry(
                    ClosableSelector.class,
                    Set.<Class<?>>of(
                            DiscussionSelector.class,
                            IssueSelector.class,
                            MilestoneSelector.class,
                            ProjectSelector.class,
                            ProjectV2Selector.class,
                            PullRequestSelector.class)),
            Map.entry(
                    CloserSelector.class,
                    Set.<Class<?>>of(CommitSelector.class, ProjectV2Selector.class, PullRequestSelector.class)),
            Map.entry(
                    CreatedIssueOrRestrictedContributionSelector.class,
                    Set.<Class<?>>of(CreatedIssueContributionSelector.class, RestrictedContributionSelector.class)),
            Map.entry(
                    CreatedPullRequestOrRestrictedContributionSelector.class,
                    Set.<Class<?>>of(
                            CreatedPullRequestContributionSelector.class, RestrictedContributionSelector.class)),
            Map.entry(
                    CreatedRepositoryOrRestrictedContributionSelector.class,
                    Set.<Class<?>>of(
                            CreatedRepositoryContributionSelector.class, RestrictedContributionSelector.class)),
            Map.entry(
                    CustomPropertySourceSelector.class,
                    Set.<Class<?>>of(EnterpriseSelector.class, OrganizationSelector.class)),
            Map.entry(DeploymentReviewerSelector.class, Set.<Class<?>>of(TeamSelector.class, UserSelector.class)),
            Map.entry(
                    EnterpriseMemberSelector.class,
                    Set.<Class<?>>of(EnterpriseUserAccountSelector.class, UserSelector.class)),
            Map.entry(
                    GitObjectSelector.class,
                    Set.<Class<?>>of(BlobSelector.class, CommitSelector.class, TagSelector.class, TreeSelector.class)),
            Map.entry(
                    GitSignatureSelector.class,
                    Set.<Class<?>>of(
                            GpgSignatureSelector.class,
                            SmimeSignatureSelector.class,
                            SshSignatureSelector.class,
                            UnknownSignatureSelector.class)),
            Map.entry(
                    HovercardContextSelector.class,
                    Set.<Class<?>>of(
                            GenericHovercardContextSelector.class,
                            OrganizationTeamsHovercardContextSelector.class,
                            OrganizationsHovercardContextSelector.class,
                            ReviewStatusHovercardContextSelector.class,
                            ViewerHovercardContextSelector.class)),
            Map.entry(
                    IpAllowListOwnerSelector.class,
                    Set.<Class<?>>of(AppSelector.class, EnterpriseSelector.class, OrganizationSelector.class)),
            Map.entry(
                    IssueFieldValueSelector.class,
                    Set.<Class<?>>of(
                            IssueFieldDateValueSelector.class,
                            IssueFieldMultiSelectValueSelector.class,
                            IssueFieldNumberValueSelector.class,
                            IssueFieldSingleSelectValueSelector.class,
                            IssueFieldTextValueSelector.class)),
            Map.entry(
                    IssueFieldsSelector.class,
                    Set.<Class<?>>of(
                            IssueFieldDateSelector.class,
                            IssueFieldMultiSelectSelector.class,
                            IssueFieldNumberSelector.class,
                            IssueFieldSingleSelectSelector.class,
                            IssueFieldTextSelector.class)),
            Map.entry(
                    IssueOrPullRequestSelector.class, Set.<Class<?>>of(IssueSelector.class, PullRequestSelector.class)),
            Map.entry(
                    IssueTimelineItemSelector.class,
                    Set.<Class<?>>of(
                            AssignedEventSelector.class,
                            ClosedEventSelector.class,
                            CommitSelector.class,
                            CrossReferencedEventSelector.class,
                            DemilestonedEventSelector.class,
                            IssueCommentSelector.class,
                            LabeledEventSelector.class,
                            LockedEventSelector.class,
                            MilestonedEventSelector.class,
                            ReferencedEventSelector.class,
                            RenamedTitleEventSelector.class,
                            ReopenedEventSelector.class,
                            SubscribedEventSelector.class,
                            TransferredEventSelector.class,
                            UnassignedEventSelector.class,
                            UnlabeledEventSelector.class,
                            UnlockedEventSelector.class,
                            UnsubscribedEventSelector.class,
                            UserBlockedEventSelector.class)),
            Map.entry(
                    IssueTimelineItemsSelector.class,
                    Set.<Class<?>>of(
                            AddedToProjectEventSelector.class,
                            AddedToProjectV2EventSelector.class,
                            AssignedEventSelector.class,
                            BlockedByAddedEventSelector.class,
                            BlockedByRemovedEventSelector.class,
                            BlockingAddedEventSelector.class,
                            BlockingRemovedEventSelector.class,
                            ClosedEventSelector.class,
                            CommentDeletedEventSelector.class,
                            ConnectedEventSelector.class,
                            ConvertedFromDraftEventSelector.class,
                            ConvertedNoteToIssueEventSelector.class,
                            ConvertedToDiscussionEventSelector.class,
                            CrossReferencedEventSelector.class,
                            DemilestonedEventSelector.class,
                            DisconnectedEventSelector.class,
                            IssueCommentSelector.class,
                            IssueCommentPinnedEventSelector.class,
                            IssueCommentUnpinnedEventSelector.class,
                            IssueFieldAddedEventSelector.class,
                            IssueFieldChangedEventSelector.class,
                            IssueFieldRemovedEventSelector.class,
                            IssueTypeAddedEventSelector.class,
                            IssueTypeChangedEventSelector.class,
                            IssueTypeRemovedEventSelector.class,
                            LabeledEventSelector.class,
                            LockedEventSelector.class,
                            MarkedAsDuplicateEventSelector.class,
                            MentionedEventSelector.class,
                            MilestonedEventSelector.class,
                            MovedColumnsInProjectEventSelector.class,
                            ParentIssueAddedEventSelector.class,
                            ParentIssueRemovedEventSelector.class,
                            PinnedEventSelector.class,
                            ProjectV2ItemStatusChangedEventSelector.class,
                            ReferencedEventSelector.class,
                            RemovedFromProjectEventSelector.class,
                            RemovedFromProjectV2EventSelector.class,
                            RenamedTitleEventSelector.class,
                            ReopenedEventSelector.class,
                            SubIssueAddedEventSelector.class,
                            SubIssueRemovedEventSelector.class,
                            SubscribedEventSelector.class,
                            TransferredEventSelector.class,
                            UnassignedEventSelector.class,
                            UnlabeledEventSelector.class,
                            UnlockedEventSelector.class,
                            UnmarkedAsDuplicateEventSelector.class,
                            UnpinnedEventSelector.class,
                            UnsubscribedEventSelector.class,
                            UserBlockedEventSelector.class)),
            Map.entry(
                    LabelableSelector.class,
                    Set.<Class<?>>of(DiscussionSelector.class, IssueSelector.class, PullRequestSelector.class)),
            Map.entry(
                    LockableSelector.class,
                    Set.<Class<?>>of(DiscussionSelector.class, IssueSelector.class, PullRequestSelector.class)),
            Map.entry(MilestoneItemSelector.class, Set.<Class<?>>of(IssueSelector.class, PullRequestSelector.class)),
            Map.entry(
                    MinimizableSelector.class,
                    Set.<Class<?>>of(
                            CommitCommentSelector.class,
                            DiscussionCommentSelector.class,
                            GistCommentSelector.class,
                            IssueCommentSelector.class,
                            PullRequestReviewSelector.class,
                            PullRequestReviewCommentSelector.class)),
            Map.entry(
                    NodeSelector.class,
                    Set.<Class<?>>of(
                            AddedToMergeQueueEventSelector.class,
                            AddedToProjectEventSelector.class,
                            AddedToProjectV2EventSelector.class,
                            AddedToStackEventSelector.class,
                            AppSelector.class,
                            AssignedEventSelector.class,
                            AutoMergeDisabledEventSelector.class,
                            AutoMergeEnabledEventSelector.class,
                            AutoRebaseEnabledEventSelector.class,
                            AutoSquashEnabledEventSelector.class,
                            AutomaticBaseChangeFailedEventSelector.class,
                            AutomaticBaseChangeSucceededEventSelector.class,
                            BaseRefChangedEventSelector.class,
                            BaseRefDeletedEventSelector.class,
                            BaseRefForcePushedEventSelector.class,
                            BlobSelector.class,
                            BlockedByAddedEventSelector.class,
                            BlockedByRemovedEventSelector.class,
                            BlockingAddedEventSelector.class,
                            BlockingRemovedEventSelector.class,
                            BotSelector.class,
                            BranchProtectionRuleSelector.class,
                            BypassForcePushAllowanceSelector.class,
                            BypassPullRequestAllowanceSelector.class,
                            CWESelector.class,
                            CheckRunSelector.class,
                            CheckSuiteSelector.class,
                            ClosedEventSelector.class,
                            CodeOfConductSelector.class,
                            CommentDeletedEventSelector.class,
                            CommitSelector.class,
                            CommitCommentSelector.class,
                            CommitCommentThreadSelector.class,
                            ComparisonSelector.class,
                            ConnectedEventSelector.class,
                            ConvertToDraftEventSelector.class,
                            ConvertedFromDraftEventSelector.class,
                            ConvertedNoteToIssueEventSelector.class,
                            ConvertedToDiscussionEventSelector.class,
                            CrossReferencedEventSelector.class,
                            DemilestonedEventSelector.class,
                            DependencyGraphManifestSelector.class,
                            DeployKeySelector.class,
                            DeployedEventSelector.class,
                            DeploymentSelector.class,
                            DeploymentEnvironmentChangedEventSelector.class,
                            DeploymentReviewSelector.class,
                            DeploymentStatusSelector.class,
                            DisconnectedEventSelector.class,
                            DiscussionSelector.class,
                            DiscussionCategorySelector.class,
                            DiscussionCommentSelector.class,
                            DiscussionPollSelector.class,
                            DiscussionPollOptionSelector.class,
                            DraftIssueSelector.class,
                            EnterpriseSelector.class,
                            EnterpriseAdministratorInvitationSelector.class,
                            EnterpriseIdentityProviderSelector.class,
                            EnterpriseMemberInvitationSelector.class,
                            EnterpriseRepositoryInfoSelector.class,
                            EnterpriseServerInstallationSelector.class,
                            EnterpriseServerUserAccountSelector.class,
                            EnterpriseServerUserAccountEmailSelector.class,
                            EnterpriseServerUserAccountsUploadSelector.class,
                            EnterpriseTeamSelector.class,
                            EnterpriseUserAccountSelector.class,
                            EnvironmentSelector.class,
                            ExternalIdentitySelector.class,
                            GistSelector.class,
                            GistCommentSelector.class,
                            HeadRefDeletedEventSelector.class,
                            HeadRefForcePushedEventSelector.class,
                            HeadRefRestoredEventSelector.class,
                            IpAllowListEntrySelector.class,
                            IssueSelector.class,
                            IssueCommentSelector.class,
                            IssueCommentPinnedEventSelector.class,
                            IssueCommentUnpinnedEventSelector.class,
                            IssueFieldAddedEventSelector.class,
                            IssueFieldChangedEventSelector.class,
                            IssueFieldDateSelector.class,
                            IssueFieldDateValueSelector.class,
                            IssueFieldMultiSelectSelector.class,
                            IssueFieldMultiSelectValueSelector.class,
                            IssueFieldNumberSelector.class,
                            IssueFieldNumberValueSelector.class,
                            IssueFieldRemovedEventSelector.class,
                            IssueFieldSingleSelectSelector.class,
                            IssueFieldSingleSelectOptionSelector.class,
                            IssueFieldSingleSelectValueSelector.class,
                            IssueFieldTextSelector.class,
                            IssueFieldTextValueSelector.class,
                            IssueTypeSelector.class,
                            IssueTypeAddedEventSelector.class,
                            IssueTypeChangedEventSelector.class,
                            IssueTypeRemovedEventSelector.class,
                            LabelSelector.class,
                            LabeledEventSelector.class,
                            LanguageSelector.class,
                            LicenseSelector.class,
                            LinkedBranchSelector.class,
                            LockedEventSelector.class,
                            MannequinSelector.class,
                            MarkedAsDuplicateEventSelector.class,
                            MarketplaceCategorySelector.class,
                            MarketplaceListingSelector.class,
                            MemberFeatureRequestNotificationSelector.class,
                            MembersCanDeleteReposClearAuditEntrySelector.class,
                            MembersCanDeleteReposDisableAuditEntrySelector.class,
                            MembersCanDeleteReposEnableAuditEntrySelector.class,
                            MentionedEventSelector.class,
                            MergeQueueSelector.class,
                            MergeQueueEntrySelector.class,
                            MergedEventSelector.class,
                            MigrationSourceSelector.class,
                            MilestoneSelector.class,
                            MilestonedEventSelector.class,
                            MovedColumnsInProjectEventSelector.class,
                            OIDCProviderSelector.class,
                            OauthApplicationCreateAuditEntrySelector.class,
                            OrgAddBillingManagerAuditEntrySelector.class,
                            OrgAddMemberAuditEntrySelector.class,
                            OrgBlockUserAuditEntrySelector.class,
                            OrgConfigDisableCollaboratorsOnlyAuditEntrySelector.class,
                            OrgConfigEnableCollaboratorsOnlyAuditEntrySelector.class,
                            OrgCreateAuditEntrySelector.class,
                            OrgDisableOauthAppRestrictionsAuditEntrySelector.class,
                            OrgDisableSamlAuditEntrySelector.class,
                            OrgDisableTwoFactorRequirementAuditEntrySelector.class,
                            OrgEnableOauthAppRestrictionsAuditEntrySelector.class,
                            OrgEnableSamlAuditEntrySelector.class,
                            OrgEnableTwoFactorRequirementAuditEntrySelector.class,
                            OrgInviteMemberAuditEntrySelector.class,
                            OrgInviteToBusinessAuditEntrySelector.class,
                            OrgOauthAppAccessApprovedAuditEntrySelector.class,
                            OrgOauthAppAccessBlockedAuditEntrySelector.class,
                            OrgOauthAppAccessDeniedAuditEntrySelector.class,
                            OrgOauthAppAccessRequestedAuditEntrySelector.class,
                            OrgOauthAppAccessUnblockedAuditEntrySelector.class,
                            OrgRemoveBillingManagerAuditEntrySelector.class,
                            OrgRemoveMemberAuditEntrySelector.class,
                            OrgRemoveOutsideCollaboratorAuditEntrySelector.class,
                            OrgRestoreMemberAuditEntrySelector.class,
                            OrgUnblockUserAuditEntrySelector.class,
                            OrgUpdateDefaultRepositoryPermissionAuditEntrySelector.class,
                            OrgUpdateMemberAuditEntrySelector.class,
                            OrgUpdateMemberRepositoryCreationPermissionAuditEntrySelector.class,
                            OrgUpdateMemberRepositoryInvitationPermissionAuditEntrySelector.class,
                            OrganizationSelector.class,
                            OrganizationIdentityProviderSelector.class,
                            OrganizationInvitationSelector.class,
                            OrganizationMigrationSelector.class,
                            PackageSelector.class,
                            PackageFileSelector.class,
                            PackageTagSelector.class,
                            PackageVersionSelector.class,
                            ParentIssueAddedEventSelector.class,
                            ParentIssueRemovedEventSelector.class,
                            PendingAssigneeSuggestionSelector.class,
                            PendingCloseSuggestionSelector.class,
                            PendingFieldSuggestionSelector.class,
                            PendingLabelSuggestionSelector.class,
                            PendingTypeSuggestionSelector.class,
                            PinnedDiscussionSelector.class,
                            PinnedEnvironmentSelector.class,
                            PinnedEventSelector.class,
                            PinnedIssueSelector.class,
                            PinnedIssueCommentSelector.class,
                            PrivateRepositoryForkingDisableAuditEntrySelector.class,
                            PrivateRepositoryForkingEnableAuditEntrySelector.class,
                            ProjectSelector.class,
                            ProjectCardSelector.class,
                            ProjectColumnSelector.class,
                            ProjectV2Selector.class,
                            ProjectV2FieldSelector.class,
                            ProjectV2ItemSelector.class,
                            ProjectV2ItemFieldDateValueSelector.class,
                            ProjectV2ItemFieldIterationValueSelector.class,
                            ProjectV2ItemFieldMultiSelectValueSelector.class,
                            ProjectV2ItemFieldNumberValueSelector.class,
                            ProjectV2ItemFieldSingleSelectValueSelector.class,
                            ProjectV2ItemFieldTextValueSelector.class,
                            ProjectV2ItemStatusChangedEventSelector.class,
                            ProjectV2IterationFieldSelector.class,
                            ProjectV2MultiSelectFieldSelector.class,
                            ProjectV2SingleSelectFieldSelector.class,
                            ProjectV2StatusUpdateSelector.class,
                            ProjectV2ViewSelector.class,
                            ProjectV2WorkflowSelector.class,
                            PublicKeySelector.class,
                            PullRequestSelector.class,
                            PullRequestCommitSelector.class,
                            PullRequestCommitCommentThreadSelector.class,
                            PullRequestReviewSelector.class,
                            PullRequestReviewCommentSelector.class,
                            PullRequestReviewThreadSelector.class,
                            PullRequestStackSelector.class,
                            PullRequestStackEntrySelector.class,
                            PullRequestThreadSelector.class,
                            PushSelector.class,
                            PushAllowanceSelector.class,
                            QuerySelector.class,
                            ReactionSelector.class,
                            ReadyForReviewEventSelector.class,
                            RefSelector.class,
                            ReferencedEventSelector.class,
                            ReleaseSelector.class,
                            ReleaseAssetSelector.class,
                            RemovedFromMergeQueueEventSelector.class,
                            RemovedFromProjectEventSelector.class,
                            RemovedFromProjectV2EventSelector.class,
                            RemovedFromStackEventSelector.class,
                            RenamedTitleEventSelector.class,
                            ReopenedEventSelector.class,
                            RepoAccessAuditEntrySelector.class,
                            RepoAddMemberAuditEntrySelector.class,
                            RepoAddTopicAuditEntrySelector.class,
                            RepoArchivedAuditEntrySelector.class,
                            RepoChangeMergeSettingAuditEntrySelector.class,
                            RepoConfigDisableAnonymousGitAccessAuditEntrySelector.class,
                            RepoConfigDisableCollaboratorsOnlyAuditEntrySelector.class,
                            RepoConfigDisableContributorsOnlyAuditEntrySelector.class,
                            RepoConfigDisableSockpuppetDisallowedAuditEntrySelector.class,
                            RepoConfigEnableAnonymousGitAccessAuditEntrySelector.class,
                            RepoConfigEnableCollaboratorsOnlyAuditEntrySelector.class,
                            RepoConfigEnableContributorsOnlyAuditEntrySelector.class,
                            RepoConfigEnableSockpuppetDisallowedAuditEntrySelector.class,
                            RepoConfigLockAnonymousGitAccessAuditEntrySelector.class,
                            RepoConfigUnlockAnonymousGitAccessAuditEntrySelector.class,
                            RepoCreateAuditEntrySelector.class,
                            RepoDestroyAuditEntrySelector.class,
                            RepoRemoveMemberAuditEntrySelector.class,
                            RepoRemoveTopicAuditEntrySelector.class,
                            RepositorySelector.class,
                            RepositoryCustomPropertySelector.class,
                            RepositoryInvitationSelector.class,
                            RepositoryMigrationSelector.class,
                            RepositoryRuleSelector.class,
                            RepositoryRulesetSelector.class,
                            RepositoryRulesetBypassActorSelector.class,
                            RepositoryTopicSelector.class,
                            RepositoryVisibilityChangeDisableAuditEntrySelector.class,
                            RepositoryVisibilityChangeEnableAuditEntrySelector.class,
                            RepositoryVulnerabilityAlertSelector.class,
                            ReviewDismissalAllowanceSelector.class,
                            ReviewDismissedEventSelector.class,
                            ReviewRequestSelector.class,
                            ReviewRequestRemovedEventSelector.class,
                            ReviewRequestedEventSelector.class,
                            SavedReplySelector.class,
                            SecurityAdvisorySelector.class,
                            SponsorsActivitySelector.class,
                            SponsorsListingSelector.class,
                            SponsorsListingFeaturedItemSelector.class,
                            SponsorsTierSelector.class,
                            SponsorshipSelector.class,
                            SponsorshipNewsletterSelector.class,
                            StatusSelector.class,
                            StatusCheckRollupSelector.class,
                            StatusContextSelector.class,
                            SubIssueAddedEventSelector.class,
                            SubIssueRemovedEventSelector.class,
                            SubscribedEventSelector.class,
                            TagSelector.class,
                            TeamSelector.class,
                            TeamAddMemberAuditEntrySelector.class,
                            TeamAddRepositoryAuditEntrySelector.class,
                            TeamChangeParentTeamAuditEntrySelector.class,
                            TeamRemoveMemberAuditEntrySelector.class,
                            TeamRemoveRepositoryAuditEntrySelector.class,
                            TopicSelector.class,
                            TransferredEventSelector.class,
                            TreeSelector.class,
                            UnassignedEventSelector.class,
                            UnlabeledEventSelector.class,
                            UnlockedEventSelector.class,
                            UnmarkedAsDuplicateEventSelector.class,
                            UnpinnedEventSelector.class,
                            UnsubscribedEventSelector.class,
                            UserSelector.class,
                            UserBlockedEventSelector.class,
                            UserContentEditSelector.class,
                            UserListSelector.class,
                            UserNamespaceRepositorySelector.class,
                            UserStatusSelector.class,
                            VerifiableDomainSelector.class,
                            WorkflowSelector.class,
                            WorkflowRunSelector.class,
                            WorkflowRunFileSelector.class)),
            Map.entry(
                    OrgRestoreMemberAuditEntryMembershipSelector.class,
                    Set.<Class<?>>of(
                            OrgRestoreMemberMembershipOrganizationAuditEntryDataSelector.class,
                            OrgRestoreMemberMembershipRepositoryAuditEntryDataSelector.class,
                            OrgRestoreMemberMembershipTeamAuditEntryDataSelector.class)),
            Map.entry(
                    OrganizationAuditEntrySelector.class,
                    Set.<Class<?>>of(
                            MembersCanDeleteReposClearAuditEntrySelector.class,
                            MembersCanDeleteReposDisableAuditEntrySelector.class,
                            MembersCanDeleteReposEnableAuditEntrySelector.class,
                            OauthApplicationCreateAuditEntrySelector.class,
                            OrgAddBillingManagerAuditEntrySelector.class,
                            OrgAddMemberAuditEntrySelector.class,
                            OrgBlockUserAuditEntrySelector.class,
                            OrgConfigDisableCollaboratorsOnlyAuditEntrySelector.class,
                            OrgConfigEnableCollaboratorsOnlyAuditEntrySelector.class,
                            OrgCreateAuditEntrySelector.class,
                            OrgDisableOauthAppRestrictionsAuditEntrySelector.class,
                            OrgDisableSamlAuditEntrySelector.class,
                            OrgDisableTwoFactorRequirementAuditEntrySelector.class,
                            OrgEnableOauthAppRestrictionsAuditEntrySelector.class,
                            OrgEnableSamlAuditEntrySelector.class,
                            OrgEnableTwoFactorRequirementAuditEntrySelector.class,
                            OrgInviteMemberAuditEntrySelector.class,
                            OrgInviteToBusinessAuditEntrySelector.class,
                            OrgOauthAppAccessApprovedAuditEntrySelector.class,
                            OrgOauthAppAccessBlockedAuditEntrySelector.class,
                            OrgOauthAppAccessDeniedAuditEntrySelector.class,
                            OrgOauthAppAccessRequestedAuditEntrySelector.class,
                            OrgOauthAppAccessUnblockedAuditEntrySelector.class,
                            OrgRemoveBillingManagerAuditEntrySelector.class,
                            OrgRemoveMemberAuditEntrySelector.class,
                            OrgRemoveOutsideCollaboratorAuditEntrySelector.class,
                            OrgRestoreMemberAuditEntrySelector.class,
                            OrgUnblockUserAuditEntrySelector.class,
                            OrgUpdateDefaultRepositoryPermissionAuditEntrySelector.class,
                            OrgUpdateMemberAuditEntrySelector.class,
                            OrgUpdateMemberRepositoryCreationPermissionAuditEntrySelector.class,
                            OrgUpdateMemberRepositoryInvitationPermissionAuditEntrySelector.class,
                            PrivateRepositoryForkingDisableAuditEntrySelector.class,
                            PrivateRepositoryForkingEnableAuditEntrySelector.class,
                            RepoAccessAuditEntrySelector.class,
                            RepoAddMemberAuditEntrySelector.class,
                            RepoAddTopicAuditEntrySelector.class,
                            RepoArchivedAuditEntrySelector.class,
                            RepoChangeMergeSettingAuditEntrySelector.class,
                            RepoConfigDisableAnonymousGitAccessAuditEntrySelector.class,
                            RepoConfigDisableCollaboratorsOnlyAuditEntrySelector.class,
                            RepoConfigDisableContributorsOnlyAuditEntrySelector.class,
                            RepoConfigDisableSockpuppetDisallowedAuditEntrySelector.class,
                            RepoConfigEnableAnonymousGitAccessAuditEntrySelector.class,
                            RepoConfigEnableCollaboratorsOnlyAuditEntrySelector.class,
                            RepoConfigEnableContributorsOnlyAuditEntrySelector.class,
                            RepoConfigEnableSockpuppetDisallowedAuditEntrySelector.class,
                            RepoConfigLockAnonymousGitAccessAuditEntrySelector.class,
                            RepoConfigUnlockAnonymousGitAccessAuditEntrySelector.class,
                            RepoCreateAuditEntrySelector.class,
                            RepoDestroyAuditEntrySelector.class,
                            RepoRemoveMemberAuditEntrySelector.class,
                            RepoRemoveTopicAuditEntrySelector.class,
                            RepositoryVisibilityChangeDisableAuditEntrySelector.class,
                            RepositoryVisibilityChangeEnableAuditEntrySelector.class,
                            TeamAddMemberAuditEntrySelector.class,
                            TeamAddRepositoryAuditEntrySelector.class,
                            TeamChangeParentTeamAuditEntrySelector.class,
                            TeamRemoveMemberAuditEntrySelector.class,
                            TeamRemoveRepositoryAuditEntrySelector.class)),
            Map.entry(
                    PendingIssueSuggestionSelector.class,
                    Set.<Class<?>>of(
                            PendingAssigneeSuggestionSelector.class,
                            PendingCloseSuggestionSelector.class,
                            PendingFieldSuggestionSelector.class,
                            PendingLabelSuggestionSelector.class,
                            PendingTypeSuggestionSelector.class)),
            Map.entry(PinnableItemSelector.class, Set.<Class<?>>of(GistSelector.class, RepositorySelector.class)),
            Map.entry(ProjectCardItemSelector.class, Set.<Class<?>>of(IssueSelector.class, PullRequestSelector.class)),
            Map.entry(
                    ProjectOwnerSelector.class,
                    Set.<Class<?>>of(OrganizationSelector.class, RepositorySelector.class, UserSelector.class)),
            Map.entry(ProjectV2ActorSelector.class, Set.<Class<?>>of(TeamSelector.class, UserSelector.class)),
            Map.entry(
                    ProjectV2FieldConfigurationSelector.class,
                    Set.<Class<?>>of(
                            ProjectV2FieldSelector.class,
                            ProjectV2IterationFieldSelector.class,
                            ProjectV2MultiSelectFieldSelector.class,
                            ProjectV2SingleSelectFieldSelector.class)),
            Map.entry(
                    ProjectV2IssueFieldValuesSelector.class,
                    Set.<Class<?>>of(
                            IssueFieldDateValueSelector.class,
                            IssueFieldMultiSelectValueSelector.class,
                            IssueFieldNumberValueSelector.class,
                            IssueFieldSingleSelectValueSelector.class,
                            IssueFieldTextValueSelector.class)),
            Map.entry(
                    ProjectV2ItemContentSelector.class,
                    Set.<Class<?>>of(DraftIssueSelector.class, IssueSelector.class, PullRequestSelector.class)),
            Map.entry(
                    ProjectV2ItemFieldValueSelector.class,
                    Set.<Class<?>>of(
                            ProjectV2ItemFieldDateValueSelector.class,
                            ProjectV2ItemFieldIterationValueSelector.class,
                            ProjectV2ItemFieldLabelValueSelector.class,
                            ProjectV2ItemFieldMilestoneValueSelector.class,
                            ProjectV2ItemFieldMultiSelectValueSelector.class,
                            ProjectV2ItemFieldNumberValueSelector.class,
                            ProjectV2ItemFieldPullRequestValueSelector.class,
                            ProjectV2ItemFieldRepositoryValueSelector.class,
                            ProjectV2ItemFieldReviewerValueSelector.class,
                            ProjectV2ItemFieldSingleSelectValueSelector.class,
                            ProjectV2ItemFieldTextValueSelector.class,
                            ProjectV2ItemFieldUserValueSelector.class,
                            ProjectV2ItemIssueFieldValueSelector.class)),
            Map.entry(
                    ProjectV2OwnerSelector.class,
                    Set.<Class<?>>of(
                            IssueSelector.class,
                            OrganizationSelector.class,
                            PullRequestSelector.class,
                            UserSelector.class)),
            Map.entry(
                    PullRequestTimelineItemSelector.class,
                    Set.<Class<?>>of(
                            AssignedEventSelector.class,
                            BaseRefDeletedEventSelector.class,
                            BaseRefForcePushedEventSelector.class,
                            ClosedEventSelector.class,
                            CommitSelector.class,
                            CommitCommentThreadSelector.class,
                            CrossReferencedEventSelector.class,
                            DemilestonedEventSelector.class,
                            DeployedEventSelector.class,
                            DeploymentEnvironmentChangedEventSelector.class,
                            HeadRefDeletedEventSelector.class,
                            HeadRefForcePushedEventSelector.class,
                            HeadRefRestoredEventSelector.class,
                            IssueCommentSelector.class,
                            LabeledEventSelector.class,
                            LockedEventSelector.class,
                            MergedEventSelector.class,
                            MilestonedEventSelector.class,
                            PullRequestReviewSelector.class,
                            PullRequestReviewCommentSelector.class,
                            PullRequestReviewThreadSelector.class,
                            ReferencedEventSelector.class,
                            RenamedTitleEventSelector.class,
                            ReopenedEventSelector.class,
                            ReviewDismissedEventSelector.class,
                            ReviewRequestRemovedEventSelector.class,
                            ReviewRequestedEventSelector.class,
                            SubscribedEventSelector.class,
                            UnassignedEventSelector.class,
                            UnlabeledEventSelector.class,
                            UnlockedEventSelector.class,
                            UnsubscribedEventSelector.class,
                            UserBlockedEventSelector.class)),
            Map.entry(
                    PullRequestTimelineItemsSelector.class,
                    Set.<Class<?>>of(
                            AddedToMergeQueueEventSelector.class,
                            AddedToProjectEventSelector.class,
                            AddedToProjectV2EventSelector.class,
                            AddedToStackEventSelector.class,
                            AssignedEventSelector.class,
                            AutoMergeDisabledEventSelector.class,
                            AutoMergeEnabledEventSelector.class,
                            AutoRebaseEnabledEventSelector.class,
                            AutoSquashEnabledEventSelector.class,
                            AutomaticBaseChangeFailedEventSelector.class,
                            AutomaticBaseChangeSucceededEventSelector.class,
                            BaseRefChangedEventSelector.class,
                            BaseRefDeletedEventSelector.class,
                            BaseRefForcePushedEventSelector.class,
                            BlockedByAddedEventSelector.class,
                            BlockedByRemovedEventSelector.class,
                            BlockingAddedEventSelector.class,
                            BlockingRemovedEventSelector.class,
                            ClosedEventSelector.class,
                            CommentDeletedEventSelector.class,
                            ConnectedEventSelector.class,
                            ConvertToDraftEventSelector.class,
                            ConvertedFromDraftEventSelector.class,
                            ConvertedNoteToIssueEventSelector.class,
                            ConvertedToDiscussionEventSelector.class,
                            CrossReferencedEventSelector.class,
                            DemilestonedEventSelector.class,
                            DeployedEventSelector.class,
                            DeploymentEnvironmentChangedEventSelector.class,
                            DisconnectedEventSelector.class,
                            HeadRefDeletedEventSelector.class,
                            HeadRefForcePushedEventSelector.class,
                            HeadRefRestoredEventSelector.class,
                            IssueCommentSelector.class,
                            IssueCommentPinnedEventSelector.class,
                            IssueCommentUnpinnedEventSelector.class,
                            IssueFieldAddedEventSelector.class,
                            IssueFieldChangedEventSelector.class,
                            IssueFieldRemovedEventSelector.class,
                            IssueTypeAddedEventSelector.class,
                            IssueTypeChangedEventSelector.class,
                            IssueTypeRemovedEventSelector.class,
                            LabeledEventSelector.class,
                            LockedEventSelector.class,
                            MarkedAsDuplicateEventSelector.class,
                            MentionedEventSelector.class,
                            MergedEventSelector.class,
                            MilestonedEventSelector.class,
                            MovedColumnsInProjectEventSelector.class,
                            ParentIssueAddedEventSelector.class,
                            ParentIssueRemovedEventSelector.class,
                            PinnedEventSelector.class,
                            ProjectV2ItemStatusChangedEventSelector.class,
                            PullRequestCommitSelector.class,
                            PullRequestCommitCommentThreadSelector.class,
                            PullRequestReviewSelector.class,
                            PullRequestReviewThreadSelector.class,
                            PullRequestRevisionMarkerSelector.class,
                            ReadyForReviewEventSelector.class,
                            ReferencedEventSelector.class,
                            RemovedFromMergeQueueEventSelector.class,
                            RemovedFromProjectEventSelector.class,
                            RemovedFromProjectV2EventSelector.class,
                            RemovedFromStackEventSelector.class,
                            RenamedTitleEventSelector.class,
                            ReopenedEventSelector.class,
                            ReviewDismissedEventSelector.class,
                            ReviewRequestRemovedEventSelector.class,
                            ReviewRequestedEventSelector.class,
                            SubIssueAddedEventSelector.class,
                            SubIssueRemovedEventSelector.class,
                            SubscribedEventSelector.class,
                            TransferredEventSelector.class,
                            UnassignedEventSelector.class,
                            UnlabeledEventSelector.class,
                            UnlockedEventSelector.class,
                            UnmarkedAsDuplicateEventSelector.class,
                            UnpinnedEventSelector.class,
                            UnsubscribedEventSelector.class,
                            UserBlockedEventSelector.class)),
            Map.entry(
                    PushAllowanceActorSelector.class,
                    Set.<Class<?>>of(AppSelector.class, TeamSelector.class, UserSelector.class)),
            Map.entry(
                    ReactableSelector.class,
                    Set.<Class<?>>of(
                            CommitCommentSelector.class,
                            DiscussionSelector.class,
                            DiscussionCommentSelector.class,
                            IssueSelector.class,
                            IssueCommentSelector.class,
                            PullRequestSelector.class,
                            PullRequestReviewSelector.class,
                            PullRequestReviewCommentSelector.class,
                            ReleaseSelector.class)),
            Map.entry(
                    ReactorSelector.class,
                    Set.<Class<?>>of(
                            BotSelector.class,
                            MannequinSelector.class,
                            OrganizationSelector.class,
                            UserSelector.class)),
            Map.entry(
                    ReferencedSubjectSelector.class, Set.<Class<?>>of(IssueSelector.class, PullRequestSelector.class)),
            Map.entry(
                    RenamedTitleSubjectSelector.class,
                    Set.<Class<?>>of(IssueSelector.class, PullRequestSelector.class)),
            Map.entry(RepositoryInfoSelector.class, Set.<Class<?>>of(RepositorySelector.class)),
            Map.entry(RepositoryOwnerSelector.class, Set.<Class<?>>of(OrganizationSelector.class, UserSelector.class)),
            Map.entry(
                    RequestedReviewerSelector.class,
                    Set.<Class<?>>of(
                            BotSelector.class,
                            EnterpriseTeamSelector.class,
                            MannequinSelector.class,
                            TeamSelector.class,
                            UserSelector.class)),
            Map.entry(
                    ReviewDismissalAllowanceActorSelector.class,
                    Set.<Class<?>>of(AppSelector.class, TeamSelector.class, UserSelector.class)),
            Map.entry(
                    RuleParametersSelector.class,
                    Set.<Class<?>>of(
                            BranchNamePatternParametersSelector.class,
                            CodeCoverageParametersSelector.class,
                            CodeQualityParametersSelector.class,
                            CodeScanningParametersSelector.class,
                            CommitAuthorEmailPatternParametersSelector.class,
                            CommitMessagePatternParametersSelector.class,
                            CommitterEmailPatternParametersSelector.class,
                            CopilotCodeReviewParametersSelector.class,
                            FileExtensionRestrictionParametersSelector.class,
                            FilePathRestrictionParametersSelector.class,
                            MaxFilePathLengthParametersSelector.class,
                            MaxFileSizeParametersSelector.class,
                            MergeQueueParametersSelector.class,
                            PullRequestParametersSelector.class,
                            RequiredDeploymentsParametersSelector.class,
                            RequiredStatusChecksParametersSelector.class,
                            TagNamePatternParametersSelector.class,
                            UpdateParametersSelector.class,
                            WorkflowsParametersSelector.class)),
            Map.entry(
                    RuleSourceSelector.class,
                    Set.<Class<?>>of(EnterpriseSelector.class, OrganizationSelector.class, RepositorySelector.class)),
            Map.entry(
                    SearchResultItemSelector.class,
                    Set.<Class<?>>of(
                            AppSelector.class,
                            DiscussionSelector.class,
                            IssueSelector.class,
                            MarketplaceListingSelector.class,
                            OrganizationSelector.class,
                            PullRequestSelector.class,
                            RepositorySelector.class,
                            UserSelector.class)),
            Map.entry(SponsorSelector.class, Set.<Class<?>>of(OrganizationSelector.class, UserSelector.class)),
            Map.entry(SponsorableSelector.class, Set.<Class<?>>of(OrganizationSelector.class, UserSelector.class)),
            Map.entry(SponsorableItemSelector.class, Set.<Class<?>>of(OrganizationSelector.class, UserSelector.class)),
            Map.entry(
                    SponsorsListingFeatureableItemSelector.class,
                    Set.<Class<?>>of(RepositorySelector.class, UserSelector.class)),
            Map.entry(
                    StarrableSelector.class,
                    Set.<Class<?>>of(GistSelector.class, RepositorySelector.class, TopicSelector.class)),
            Map.entry(
                    StatusCheckRollupContextSelector.class,
                    Set.<Class<?>>of(CheckRunSelector.class, StatusContextSelector.class)),
            Map.entry(
                    SubscribableSelector.class,
                    Set.<Class<?>>of(
                            CommitSelector.class,
                            DiscussionSelector.class,
                            IssueSelector.class,
                            PullRequestSelector.class,
                            RepositorySelector.class,
                            TeamSelector.class)),
            Map.entry(
                    UniformResourceLocatableSelector.class,
                    Set.<Class<?>>of(
                            BotSelector.class,
                            CheckRunSelector.class,
                            ClosedEventSelector.class,
                            CommitSelector.class,
                            ConvertToDraftEventSelector.class,
                            CrossReferencedEventSelector.class,
                            GistSelector.class,
                            IssueSelector.class,
                            MannequinSelector.class,
                            MergedEventSelector.class,
                            MilestoneSelector.class,
                            OrganizationSelector.class,
                            PullRequestSelector.class,
                            PullRequestCommitSelector.class,
                            ReadyForReviewEventSelector.class,
                            ReleaseSelector.class,
                            RepositorySelector.class,
                            RepositoryTopicSelector.class,
                            ReviewDismissedEventSelector.class,
                            UserSelector.class,
                            WorkflowSelector.class,
                            WorkflowRunSelector.class,
                            WorkflowRunFileSelector.class)),
            Map.entry(UserListItemsSelector.class, Set.<Class<?>>of(RepositorySelector.class)),
            Map.entry(
                    VerifiableDomainOwnerSelector.class,
                    Set.<Class<?>>of(EnterpriseSelector.class, OrganizationSelector.class)),
            Map.entry(
                    VotableSelector.class,
                    Set.<Class<?>>of(DiscussionSelector.class, DiscussionCommentSelector.class)));

    private Selectors() {}

    static QuerySelector query(final Cursor cursor) {
        return new QuerySelectorImpl(cursor);
    }

    static MutationSelector mutation(final Cursor cursor) {
        return new MutationSelectorImpl(cursor);
    }

    static @Nullable Branch branch(final Class<?> type) {
        return BRANCHES.get(type);
    }

    static Set<Class<?>> possible(final Class<?> abstractType) {
        return POSSIBLE.getOrDefault(abstractType, Set.of());
    }
}
