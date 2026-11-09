package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateBranchProtectionRulePayloadTest {

    @Test
    void constructor_shouldFail_whenBranchProtectionRuleIdIsNull() {
        final UpdateBranchProtectionRulePayloadBuilder builder = UpdateBranchProtectionRulePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("branchProtectionRuleId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateBranchProtectionRulePayload input = UpdateBranchProtectionRulePayloadBuilder.builder()
                .branchProtectionRuleId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("branchProtectionRuleId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateBranchProtectionRulePayload input = UpdateBranchProtectionRulePayloadBuilder.builder()
                .allowsDeletions(true)
                .allowsForcePushes(true)
                .blocksCreations(true)
                .branchProtectionRuleId("x")
                .bypassForcePushActorIds(List.of("x"))
                .bypassPullRequestActorIds(List.of("x"))
                .clientMutationId("x")
                .dismissesStaleReviews(true)
                .isAdminEnforced(true)
                .lockAllowsFetchAndMerge(true)
                .lockBranch(true)
                .pattern("x")
                .pushActorIds(List.of("x"))
                .requireLastPushApproval(true)
                .requiredApprovingReviewCount(1)
                .requiredDeploymentEnvironments(List.of("x"))
                .requiredStatusCheckContexts(List.of("x"))
                .requiredStatusChecks(List.of(
                        RequiredStatusCheckInputBuilder.builder().context("x").build()))
                .requiresApprovingReviews(true)
                .requiresCodeOwnerReviews(true)
                .requiresCommitSignatures(true)
                .requiresConversationResolution(true)
                .requiresDeployments(true)
                .requiresLinearHistory(true)
                .requiresStatusChecks(true)
                .requiresStrictStatusChecks(true)
                .restrictsPushes(true)
                .restrictsReviewDismissals(true)
                .reviewDismissalActorIds(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("allowsDeletions", true),
                        entry("allowsForcePushes", true),
                        entry("blocksCreations", true),
                        entry("branchProtectionRuleId", "x"),
                        entry("bypassForcePushActorIds", List.of("x")),
                        entry("bypassPullRequestActorIds", List.of("x")),
                        entry("clientMutationId", "x"),
                        entry("dismissesStaleReviews", true),
                        entry("isAdminEnforced", true),
                        entry("lockAllowsFetchAndMerge", true),
                        entry("lockBranch", true),
                        entry("pattern", "x"),
                        entry("pushActorIds", List.of("x")),
                        entry("requireLastPushApproval", true),
                        entry("requiredApprovingReviewCount", 1),
                        entry("requiredDeploymentEnvironments", List.of("x")),
                        entry("requiredStatusCheckContexts", List.of("x")),
                        entry("requiredStatusChecks", List.of(Map.ofEntries(entry("context", "x")))),
                        entry("requiresApprovingReviews", true),
                        entry("requiresCodeOwnerReviews", true),
                        entry("requiresCommitSignatures", true),
                        entry("requiresConversationResolution", true),
                        entry("requiresDeployments", true),
                        entry("requiresLinearHistory", true),
                        entry("requiresStatusChecks", true),
                        entry("requiresStrictStatusChecks", true),
                        entry("restrictsPushes", true),
                        entry("restrictsReviewDismissals", true),
                        entry("reviewDismissalActorIds", List.of("x")));
    }
}
