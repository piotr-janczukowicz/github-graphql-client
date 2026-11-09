package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code BranchProtectionRule}. */
public interface BranchProtectionRuleSelector {

    boolean allowsDeletions();

    boolean allowsForcePushes();

    boolean blocksCreations();

    <R> Page<R> branchProtectionRuleConflicts(
            Paging paging, Function<BranchProtectionRuleConflictSelector, R> selection);

    <R> Page<R> bypassForcePushAllowances(Paging paging, Function<BypassForcePushAllowanceSelector, R> selection);

    <R> Page<R> bypassPullRequestAllowances(Paging paging, Function<BypassPullRequestAllowanceSelector, R> selection);

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    @Nullable Integer databaseId();

    boolean dismissesStaleReviews();

    String id();

    boolean isAdminEnforced();

    boolean lockAllowsFetchAndMerge();

    boolean lockBranch();

    <R> Page<R> matchingRefs(
            Paging paging, BranchProtectionRuleMatchingRefsFilter arguments, Function<RefSelector, R> selection);

    <R> Page<R> matchingRefs(Paging paging, Function<RefSelector, R> selection);

    String pattern();

    <R> Page<R> pushAllowances(Paging paging, Function<PushAllowanceSelector, R> selection);

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);

    boolean requireLastPushApproval();

    @Nullable Integer requiredApprovingReviewCount();

    List<String> requiredDeploymentEnvironments();

    List<String> requiredStatusCheckContexts();

    <R> List<R> requiredStatusChecks(Function<RequiredStatusCheckDescriptionSelector, R> selection);

    boolean requiresApprovingReviews();

    boolean requiresCodeOwnerReviews();

    boolean requiresCommitSignatures();

    boolean requiresConversationResolution();

    boolean requiresDeployments();

    boolean requiresLinearHistory();

    boolean requiresStatusChecks();

    boolean requiresStrictStatusChecks();

    boolean restrictsPushes();

    boolean restrictsReviewDismissals();

    <R> Page<R> reviewDismissalAllowances(Paging paging, Function<ReviewDismissalAllowanceSelector, R> selection);
}
