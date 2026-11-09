package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFiltersBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.MilestonePullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneState;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestState;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MilestoneSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"closed\":true" + "," + "\"closedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"closedIssueCount\":1" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"creator\":{\"avatarUrl\": \"x\"}" + "," + "\"description\":\"x\"" + "," + "\"descriptionHTML\":\"x\""
            + "," + "\"dueOn\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + ","
            + "\"issues\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"number\":1" + "," + "\"openIssueCount\":1" + "," + "\"progressPercentage\":1.5" + ","
            + "\"pullRequests\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"state\":\"CLOSED\"" + "," + "\"title\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"url\":\"x\"" + "," + "\"viewerCanClose\":true" + "," + "\"viewerCanReopen\":true" + "}";

    private static List<Object> readWithArguments(final MilestoneSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.closed());
        values.add(selector.closedAt());
        values.add(selector.closedIssueCount());
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.description());
        values.add(selector.descriptionHTML());
        values.add(selector.dueOn());
        values.add(selector.id());
        values.add(selector.issues(
                Paging.first(1),
                MilestoneIssuesFilterBuilder.builder()
                        .filterBy(IssueFiltersBuilder.builder().build())
                        .labels(List.of("x"))
                        .orderBy(IssueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueOrderField.COMMENTS)
                                .build())
                        .states(List.of(IssueState.CLOSED))
                        .build(),
                IssueSelector::activeLockReason));
        values.add(selector.number());
        values.add(selector.openIssueCount());
        values.add(selector.progressPercentage());
        values.add(selector.pullRequests(
                Paging.first(1),
                MilestonePullRequestsFilterBuilder.builder()
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
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.state());
        values.add(selector.title());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.viewerCanClose());
        values.add(selector.viewerCanReopen());
        return values;
    }

    private static List<Object> readWithoutArguments(final MilestoneSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.issues(Paging.first(1), IssueSelector::activeLockReason));
        values.add(selector.pullRequests(Paging.first(1), PullRequestSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new MilestoneSelectorImpl(new RecordingCursor(root)));
        final MilestoneSelectorImpl selector =
                new MilestoneSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        1,
                        1,
                        1.5,
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        true,
                        "x",
                        MilestoneState.CLOSED,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true,
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new MilestoneSelectorImpl(new RecordingCursor(root)));
        final MilestoneSelectorImpl selector =
                new MilestoneSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null));
    }
}
