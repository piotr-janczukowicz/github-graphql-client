package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateBranchProtectionRuleInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateBranchProtectionRulePayload(
        @Nullable Boolean allowsDeletions,
        @Nullable Boolean allowsForcePushes,
        @Nullable Boolean blocksCreations,
        String branchProtectionRuleId,
        @Nullable List<String> bypassForcePushActorIds,
        @Nullable List<String> bypassPullRequestActorIds,
        @Nullable String clientMutationId,
        @Nullable Boolean dismissesStaleReviews,
        @Nullable Boolean isAdminEnforced,
        @Nullable Boolean lockAllowsFetchAndMerge,
        @Nullable Boolean lockBranch,
        @Nullable String pattern,
        @Nullable List<String> pushActorIds,
        @Nullable Boolean requireLastPushApproval,
        @Nullable Integer requiredApprovingReviewCount,
        @Nullable List<String> requiredDeploymentEnvironments,
        @Nullable List<String> requiredStatusCheckContexts,
        @Nullable List<RequiredStatusCheckInput> requiredStatusChecks,
        @Nullable Boolean requiresApprovingReviews,
        @Nullable Boolean requiresCodeOwnerReviews,
        @Nullable Boolean requiresCommitSignatures,
        @Nullable Boolean requiresConversationResolution,
        @Nullable Boolean requiresDeployments,
        @Nullable Boolean requiresLinearHistory,
        @Nullable Boolean requiresStatusChecks,
        @Nullable Boolean requiresStrictStatusChecks,
        @Nullable Boolean restrictsPushes,
        @Nullable Boolean restrictsReviewDismissals,
        @Nullable List<String> reviewDismissalActorIds) {

    public UpdateBranchProtectionRulePayload {
        requireNonNull(branchProtectionRuleId, "branchProtectionRuleId");
        bypassForcePushActorIds = ListUtils.copyOrNull(bypassForcePushActorIds);
        bypassPullRequestActorIds = ListUtils.copyOrNull(bypassPullRequestActorIds);
        pushActorIds = ListUtils.copyOrNull(pushActorIds);
        requiredDeploymentEnvironments = ListUtils.copyOrNull(requiredDeploymentEnvironments);
        requiredStatusCheckContexts = ListUtils.copyOrNull(requiredStatusCheckContexts);
        requiredStatusChecks = ListUtils.copyOrNull(requiredStatusChecks);
        reviewDismissalActorIds = ListUtils.copyOrNull(reviewDismissalActorIds);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.allowsDeletions != null) {
            variable.put("allowsDeletions", this.allowsDeletions);
        }
        if (this.allowsForcePushes != null) {
            variable.put("allowsForcePushes", this.allowsForcePushes);
        }
        if (this.blocksCreations != null) {
            variable.put("blocksCreations", this.blocksCreations);
        }
        variable.put("branchProtectionRuleId", this.branchProtectionRuleId);
        if (this.bypassForcePushActorIds != null) {
            variable.put("bypassForcePushActorIds", this.bypassForcePushActorIds);
        }
        if (this.bypassPullRequestActorIds != null) {
            variable.put("bypassPullRequestActorIds", this.bypassPullRequestActorIds);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.dismissesStaleReviews != null) {
            variable.put("dismissesStaleReviews", this.dismissesStaleReviews);
        }
        if (this.isAdminEnforced != null) {
            variable.put("isAdminEnforced", this.isAdminEnforced);
        }
        if (this.lockAllowsFetchAndMerge != null) {
            variable.put("lockAllowsFetchAndMerge", this.lockAllowsFetchAndMerge);
        }
        if (this.lockBranch != null) {
            variable.put("lockBranch", this.lockBranch);
        }
        if (this.pattern != null) {
            variable.put("pattern", this.pattern);
        }
        if (this.pushActorIds != null) {
            variable.put("pushActorIds", this.pushActorIds);
        }
        if (this.requireLastPushApproval != null) {
            variable.put("requireLastPushApproval", this.requireLastPushApproval);
        }
        if (this.requiredApprovingReviewCount != null) {
            variable.put("requiredApprovingReviewCount", this.requiredApprovingReviewCount);
        }
        if (this.requiredDeploymentEnvironments != null) {
            variable.put("requiredDeploymentEnvironments", this.requiredDeploymentEnvironments);
        }
        if (this.requiredStatusCheckContexts != null) {
            variable.put("requiredStatusCheckContexts", this.requiredStatusCheckContexts);
        }
        if (this.requiredStatusChecks != null) {
            variable.put(
                    "requiredStatusChecks",
                    this.requiredStatusChecks.stream()
                            .map(RequiredStatusCheckInput::toVariable)
                            .toList());
        }
        if (this.requiresApprovingReviews != null) {
            variable.put("requiresApprovingReviews", this.requiresApprovingReviews);
        }
        if (this.requiresCodeOwnerReviews != null) {
            variable.put("requiresCodeOwnerReviews", this.requiresCodeOwnerReviews);
        }
        if (this.requiresCommitSignatures != null) {
            variable.put("requiresCommitSignatures", this.requiresCommitSignatures);
        }
        if (this.requiresConversationResolution != null) {
            variable.put("requiresConversationResolution", this.requiresConversationResolution);
        }
        if (this.requiresDeployments != null) {
            variable.put("requiresDeployments", this.requiresDeployments);
        }
        if (this.requiresLinearHistory != null) {
            variable.put("requiresLinearHistory", this.requiresLinearHistory);
        }
        if (this.requiresStatusChecks != null) {
            variable.put("requiresStatusChecks", this.requiresStatusChecks);
        }
        if (this.requiresStrictStatusChecks != null) {
            variable.put("requiresStrictStatusChecks", this.requiresStrictStatusChecks);
        }
        if (this.restrictsPushes != null) {
            variable.put("restrictsPushes", this.restrictsPushes);
        }
        if (this.restrictsReviewDismissals != null) {
            variable.put("restrictsReviewDismissals", this.restrictsReviewDismissals);
        }
        if (this.reviewDismissalActorIds != null) {
            variable.put("reviewDismissalActorIds", this.reviewDismissalActorIds);
        }
        return Collections.unmodifiableMap(variable);
    }
}
