package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFiltersBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.LabelIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LabelPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
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
class LabelSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"color\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\""
            + "," + "\"description\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"isDefault\":true" + ","
            + "\"issues\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"name\":\"x\"" + ","
            + "\"pullRequests\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final LabelSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.color());
        values.add(selector.createdAt());
        values.add(selector.description());
        values.add(selector.id());
        values.add(selector.isDefault());
        values.add(selector.issues(
                Paging.first(1),
                LabelIssuesFilterBuilder.builder()
                        .filterBy(IssueFiltersBuilder.builder().build())
                        .labels(List.of("x"))
                        .orderBy(IssueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueOrderField.COMMENTS)
                                .build())
                        .states(List.of(IssueState.CLOSED))
                        .build(),
                IssueSelector::activeLockReason));
        values.add(selector.name());
        values.add(selector.pullRequests(
                Paging.first(1),
                LabelPullRequestsFilterBuilder.builder()
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
        values.add(selector.updatedAt());
        values.add(selector.url());
        return values;
    }

    private static List<Object> readWithoutArguments(final LabelSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.issues(Paging.first(1), IssueSelector::activeLockReason));
        values.add(selector.pullRequests(Paging.first(1), PullRequestSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new LabelSelectorImpl(new RecordingCursor(root)));
        final LabelSelectorImpl selector = new LabelSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        true,
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        "x",
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        true,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new LabelSelectorImpl(new RecordingCursor(root)));
        final LabelSelectorImpl selector = new LabelSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null));
    }
}
