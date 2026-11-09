package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleConflictSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleMatchingRefsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleMatchingRefsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BypassForcePushAllowanceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BypassPullRequestAllowanceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PushAllowanceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequiredStatusCheckDescriptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewDismissalAllowanceSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code BranchProtectionRule}; used by the generated selection code only. */
final class BranchProtectionRuleSelectorImpl implements BranchProtectionRuleSelector {

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private final Cursor cursor;

    BranchProtectionRuleSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean allowsDeletions() {
        return cursor.getRequired("allowsDeletions", ScalarType.BOOLEAN);
    }

    @Override
    public boolean allowsForcePushes() {
        return cursor.getRequired("allowsForcePushes", ScalarType.BOOLEAN);
    }

    @Override
    public boolean blocksCreations() {
        return cursor.getRequired("blocksCreations", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> branchProtectionRuleConflicts(
            final Paging paging, final Function<BranchProtectionRuleConflictSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "branchProtectionRuleConflicts",
                child -> selection.apply(new BranchProtectionRuleConflictSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> bypassForcePushAllowances(
            final Paging paging, final Function<BypassForcePushAllowanceSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "bypassForcePushAllowances",
                child -> selection.apply(new BypassForcePushAllowanceSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> bypassPullRequestAllowances(
            final Paging paging, final Function<BypassPullRequestAllowanceSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "bypassPullRequestAllowances",
                child -> selection.apply(new BypassPullRequestAllowanceSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> @Nullable R creator(final Function<ActorSelector, R> selection) {
        return cursor.object("creator", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public boolean dismissesStaleReviews() {
        return cursor.getRequired("dismissesStaleReviews", ScalarType.BOOLEAN);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isAdminEnforced() {
        return cursor.getRequired("isAdminEnforced", ScalarType.BOOLEAN);
    }

    @Override
    public boolean lockAllowsFetchAndMerge() {
        return cursor.getRequired("lockAllowsFetchAndMerge", ScalarType.BOOLEAN);
    }

    @Override
    public boolean lockBranch() {
        return cursor.getRequired("lockBranch", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> matchingRefs(
            final Paging paging,
            final BranchProtectionRuleMatchingRefsFilter arguments,
            final Function<RefSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "matchingRefs",
                child -> selection.apply(new RefSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("query", STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> matchingRefs(final Paging paging, final Function<RefSelector, R> selection) {
        return matchingRefs(
                paging, BranchProtectionRuleMatchingRefsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String pattern() {
        return cursor.getRequired("pattern", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> pushAllowances(final Paging paging, final Function<PushAllowanceSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "pushAllowances",
                child -> selection.apply(new PushAllowanceSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> @Nullable R repository(final Function<RepositorySelector, R> selection) {
        return cursor.object("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public boolean requireLastPushApproval() {
        return cursor.getRequired("requireLastPushApproval", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Integer requiredApprovingReviewCount() {
        return cursor.get("requiredApprovingReviewCount", ScalarType.INT);
    }

    @Override
    public List<String> requiredDeploymentEnvironments() {
        return cursor.scalarList("requiredDeploymentEnvironments", ScalarType.STRING);
    }

    @Override
    public List<String> requiredStatusCheckContexts() {
        return cursor.scalarList("requiredStatusCheckContexts", ScalarType.STRING);
    }

    @Override
    public <R> List<R> requiredStatusChecks(final Function<RequiredStatusCheckDescriptionSelector, R> selection) {
        return cursor.list(
                "requiredStatusChecks",
                child -> selection.apply(new RequiredStatusCheckDescriptionSelectorImpl(child)));
    }

    @Override
    public boolean requiresApprovingReviews() {
        return cursor.getRequired("requiresApprovingReviews", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requiresCodeOwnerReviews() {
        return cursor.getRequired("requiresCodeOwnerReviews", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requiresCommitSignatures() {
        return cursor.getRequired("requiresCommitSignatures", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requiresConversationResolution() {
        return cursor.getRequired("requiresConversationResolution", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requiresDeployments() {
        return cursor.getRequired("requiresDeployments", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requiresLinearHistory() {
        return cursor.getRequired("requiresLinearHistory", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requiresStatusChecks() {
        return cursor.getRequired("requiresStatusChecks", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requiresStrictStatusChecks() {
        return cursor.getRequired("requiresStrictStatusChecks", ScalarType.BOOLEAN);
    }

    @Override
    public boolean restrictsPushes() {
        return cursor.getRequired("restrictsPushes", ScalarType.BOOLEAN);
    }

    @Override
    public boolean restrictsReviewDismissals() {
        return cursor.getRequired("restrictsReviewDismissals", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> reviewDismissalAllowances(
            final Paging paging, final Function<ReviewDismissalAllowanceSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "reviewDismissalAllowances",
                child -> selection.apply(new ReviewDismissalAllowanceSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }
}
