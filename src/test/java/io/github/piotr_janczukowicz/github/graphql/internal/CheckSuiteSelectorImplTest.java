package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckConclusionState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckStatusState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteCheckRunsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteMatchingPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestState;
import io.github.piotr_janczukowicz.github.graphql.model.PushSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CheckSuiteSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"app\":{\"clientId\": \"x\"}" + "," + "\"branch\":{\"id\": \"x\"}" + ","
                    + "\"checkRuns\":{\"nodes\": [{\"completedAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "," + "\"commit\":{\"abbreviatedOid\": \"x\"}" + "," + "\"conclusion\":\"ACTION_REQUIRED\"" + ","
                    + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"creator\":{\"anyPinnableItems\": true}" + ","
                    + "\"databaseId\":1" + "," + "\"id\":\"x\"" + ","
                    + "\"matchingPullRequests\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "," + "\"push\":{\"id\": \"x\"}" + "," + "\"repository\":{\"allowUpdateBranch\": true}" + ","
                    + "\"resourcePath\":\"x\"" + "," + "\"status\":\"COMPLETED\"" + ","
                    + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + ","
                    + "\"workflowRun\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "}";

    private static List<Object> readWithArguments(final CheckSuiteSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.app(AppSelector::clientId));
        values.add(selector.branch(RefSelector::id));
        values.add(selector.checkRuns(
                Paging.first(1),
                CheckSuiteCheckRunsFilterBuilder.builder()
                        .filterBy(CheckRunFilterBuilder.builder().build())
                        .build(),
                CheckRunSelector::completedAt));
        values.add(selector.commit(CommitSelector::abbreviatedOid));
        values.add(selector.conclusion());
        values.add(selector.createdAt());
        values.add(selector.creator(UserSelector::anyPinnableItems));
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.matchingPullRequests(
                Paging.first(1),
                CheckSuiteMatchingPullRequestsFilterBuilder.builder()
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
        values.add(selector.push(PushSelector::id));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.status());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.workflowRun(WorkflowRunSelector::createdAt));
        return values;
    }

    private static List<Object> readWithoutArguments(final CheckSuiteSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.checkRuns(Paging.first(1), CheckRunSelector::completedAt));
        values.add(selector.matchingPullRequests(Paging.first(1), PullRequestSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CheckSuiteSelectorImpl(new RecordingCursor(root)));
        final CheckSuiteSelectorImpl selector =
                new CheckSuiteSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        CheckConclusionState.ACTION_REQUIRED,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        1,
                        "x",
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        "x",
                        true,
                        "x",
                        CheckStatusState.COMPLETED,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new CheckSuiteSelectorImpl(new RecordingCursor(root)));
        final CheckSuiteSelectorImpl selector =
                new CheckSuiteSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null));
    }
}
