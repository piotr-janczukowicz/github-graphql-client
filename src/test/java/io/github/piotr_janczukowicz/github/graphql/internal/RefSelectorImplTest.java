package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ComparisonSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestState;
import io.github.piotr_janczukowicz.github.graphql.model.RefAssociatedPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RefRulesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RefUpdateRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RefSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"associatedPullRequests\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"branchProtectionRule\":{\"allowsDeletions\": true}" + "," + "\"compare\":{\"aheadBy\": 1}" + ","
            + "\"id\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"prefix\":\"x\"" + ","
            + "\"refUpdateRule\":{\"allowsDeletions\": true}" + "," + "\"repository\":{\"allowUpdateBranch\": true}"
            + ","
            + "\"rules\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"target\":{\"abbreviatedOid\": \"x\"}" + "}";

    private static List<Object> readWithArguments(final RefSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.associatedPullRequests(
                Paging.first(1),
                RefAssociatedPullRequestsFilterBuilder.builder()
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
        values.add(selector.branchProtectionRule(BranchProtectionRuleSelector::allowsDeletions));
        values.add(selector.compare("x", ComparisonSelector::aheadBy));
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.prefix());
        values.add(selector.refUpdateRule(RefUpdateRuleSelector::allowsDeletions));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.rules(
                Paging.first(1),
                RefRulesFilterBuilder.builder()
                        .orderBy(RepositoryRuleOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(RepositoryRuleOrderField.CREATED_AT)
                                .build())
                        .build(),
                RepositoryRuleSelector::id));
        values.add(selector.target(GitObjectSelector::abbreviatedOid));
        return values;
    }

    private static List<Object> readWithoutArguments(final RefSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.associatedPullRequests(Paging.first(1), PullRequestSelector::activeLockReason));
        values.add(selector.rules(Paging.first(1), RepositoryRuleSelector::id));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RefSelectorImpl(new RecordingCursor(root)));
        final RefSelectorImpl selector = new RefSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        true,
                        1,
                        "x",
                        "x",
                        "x",
                        true,
                        true,
                        new Page<>(List.of("x"), false, null),
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new RefSelectorImpl(new RecordingCursor(root)));
        final RefSelectorImpl selector = new RefSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null), new Page<>(List.of("x"), false, null));
    }
}
