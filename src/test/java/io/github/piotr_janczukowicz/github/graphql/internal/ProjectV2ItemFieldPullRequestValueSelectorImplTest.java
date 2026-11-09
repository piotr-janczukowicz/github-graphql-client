package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldPullRequestValuePullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2ItemFieldPullRequestValueSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"field\":{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
                    + "\"pullRequests\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "}";

    private static List<Object> readWithArguments(final ProjectV2ItemFieldPullRequestValueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.field(child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.pullRequests(
                Paging.first(1),
                ProjectV2ItemFieldPullRequestValuePullRequestsFilterBuilder.builder()
                        .orderBy(PullRequestOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(PullRequestOrderField.CREATED_AT)
                                .build())
                        .build(),
                PullRequestSelector::activeLockReason));
        return values;
    }

    private static List<Object> readWithoutArguments(final ProjectV2ItemFieldPullRequestValueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.pullRequests(Paging.first(1), PullRequestSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2ItemFieldPullRequestValueSelectorImpl(new RecordingCursor(root)));
        final ProjectV2ItemFieldPullRequestValueSelectorImpl selector =
                new ProjectV2ItemFieldPullRequestValueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"), new Page<>(List.of(LockReason.OFF_TOPIC), false, null));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ProjectV2ItemFieldPullRequestValueSelectorImpl(new RecordingCursor(root)));
        final ProjectV2ItemFieldPullRequestValueSelectorImpl selector =
                new ProjectV2ItemFieldPullRequestValueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(LockReason.OFF_TOPIC), false, null));
    }
}
