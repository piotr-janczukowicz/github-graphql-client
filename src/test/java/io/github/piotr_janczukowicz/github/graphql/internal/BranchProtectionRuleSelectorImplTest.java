package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleMatchingRefsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BypassForcePushAllowanceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BypassPullRequestAllowanceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PushAllowanceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequiredStatusCheckDescriptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewDismissalAllowanceSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class BranchProtectionRuleSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"allowsDeletions\":true" + "," + "\"allowsForcePushes\":true" + ","
            + "\"blocksCreations\":true" + ","
            + "\"branchProtectionRuleConflicts\":{\"nodes\": [{\"branchProtectionRule\": {\"allowsDeletions\": true}}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"bypassForcePushAllowances\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"bypassPullRequestAllowances\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"creator\":{\"avatarUrl\": \"x\"}" + "," + "\"databaseId\":1" + ","
            + "\"dismissesStaleReviews\":true" + "," + "\"id\":\"x\"" + "," + "\"isAdminEnforced\":true" + ","
            + "\"lockAllowsFetchAndMerge\":true" + "," + "\"lockBranch\":true" + ","
            + "\"matchingRefs\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"pattern\":\"x\"" + ","
            + "\"pushAllowances\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"requireLastPushApproval\":true" + ","
            + "\"requiredApprovingReviewCount\":1" + "," + "\"requiredDeploymentEnvironments\":[\"x\"]" + ","
            + "\"requiredStatusCheckContexts\":[\"x\"]" + "," + "\"requiredStatusChecks\":[{\"context\": \"x\"}]" + ","
            + "\"requiresApprovingReviews\":true" + "," + "\"requiresCodeOwnerReviews\":true" + ","
            + "\"requiresCommitSignatures\":true" + "," + "\"requiresConversationResolution\":true" + ","
            + "\"requiresDeployments\":true" + "," + "\"requiresLinearHistory\":true" + ","
            + "\"requiresStatusChecks\":true" + "," + "\"requiresStrictStatusChecks\":true" + ","
            + "\"restrictsPushes\":true" + "," + "\"restrictsReviewDismissals\":true" + ","
            + "\"reviewDismissalAllowances\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "}";

    private static List<Object> readWithArguments(final BranchProtectionRuleSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.allowsDeletions());
        values.add(selector.allowsForcePushes());
        values.add(selector.blocksCreations());
        values.add(selector.branchProtectionRuleConflicts(
                Paging.first(1), child -> child.branchProtectionRule(BranchProtectionRuleSelector::allowsDeletions)));
        values.add(selector.bypassForcePushAllowances(Paging.first(1), BypassForcePushAllowanceSelector::id));
        values.add(selector.bypassPullRequestAllowances(Paging.first(1), BypassPullRequestAllowanceSelector::id));
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.databaseId());
        values.add(selector.dismissesStaleReviews());
        values.add(selector.id());
        values.add(selector.isAdminEnforced());
        values.add(selector.lockAllowsFetchAndMerge());
        values.add(selector.lockBranch());
        values.add(selector.matchingRefs(
                Paging.first(1),
                BranchProtectionRuleMatchingRefsFilterBuilder.builder()
                        .query("x")
                        .build(),
                RefSelector::id));
        values.add(selector.pattern());
        values.add(selector.pushAllowances(Paging.first(1), PushAllowanceSelector::id));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.requireLastPushApproval());
        values.add(selector.requiredApprovingReviewCount());
        values.add(selector.requiredDeploymentEnvironments());
        values.add(selector.requiredStatusCheckContexts());
        values.add(selector.requiredStatusChecks(RequiredStatusCheckDescriptionSelector::context));
        values.add(selector.requiresApprovingReviews());
        values.add(selector.requiresCodeOwnerReviews());
        values.add(selector.requiresCommitSignatures());
        values.add(selector.requiresConversationResolution());
        values.add(selector.requiresDeployments());
        values.add(selector.requiresLinearHistory());
        values.add(selector.requiresStatusChecks());
        values.add(selector.requiresStrictStatusChecks());
        values.add(selector.restrictsPushes());
        values.add(selector.restrictsReviewDismissals());
        values.add(selector.reviewDismissalAllowances(Paging.first(1), ReviewDismissalAllowanceSelector::id));
        return values;
    }

    private static List<Object> readWithoutArguments(final BranchProtectionRuleSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.matchingRefs(Paging.first(1), RefSelector::id));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new BranchProtectionRuleSelectorImpl(new RecordingCursor(root)));
        final BranchProtectionRuleSelectorImpl selector =
                new BranchProtectionRuleSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        true,
                        true,
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of("x"), false, null),
                        "x",
                        1,
                        true,
                        "x",
                        true,
                        true,
                        true,
                        new Page<>(List.of("x"), false, null),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        true,
                        true,
                        1,
                        List.of("x"),
                        List.of("x"),
                        List.of("x"),
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
                        new Page<>(List.of("x"), false, null));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new BranchProtectionRuleSelectorImpl(new RecordingCursor(root)));
        final BranchProtectionRuleSelectorImpl selector =
                new BranchProtectionRuleSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null));
    }
}
