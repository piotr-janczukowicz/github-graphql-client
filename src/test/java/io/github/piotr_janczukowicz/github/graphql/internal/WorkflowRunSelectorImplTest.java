package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CheckConclusionState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class WorkflowRunSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"checkSuite\":{\"conclusion\": \"ACTION_REQUIRED\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1" + ","
            + "\"deploymentReviews\":{\"nodes\": [{\"comment\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"displayTitle\":\"x\"" + "," + "\"event\":\"x\"" + "," + "\"file\":{\"id\": \"x\"}" + ","
            + "\"id\":\"x\"" + ","
            + "\"pendingDeploymentRequests\":{\"nodes\": [{\"currentUserCanApprove\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"resourcePath\":\"x\"" + "," + "\"runAttempt\":1" + "," + "\"runNumber\":1" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + ","
            + "\"workflow\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "}";

    private static List<Object> readWithArguments(final WorkflowRunSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.checkSuite(CheckSuiteSelector::conclusion));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.deploymentReviews(Paging.first(1), DeploymentReviewSelector::comment));
        values.add(selector.displayTitle());
        values.add(selector.event());
        values.add(selector.file(WorkflowRunFileSelector::id));
        values.add(selector.id());
        values.add(
                selector.pendingDeploymentRequests(Paging.first(1), DeploymentRequestSelector::currentUserCanApprove));
        values.add(selector.resourcePath());
        values.add(selector.runAttempt());
        values.add(selector.runNumber());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.workflow(WorkflowSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new WorkflowRunSelectorImpl(new RecordingCursor(root)));
        final WorkflowRunSelectorImpl selector =
                new WorkflowRunSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        CheckConclusionState.ACTION_REQUIRED,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        new Page<>(List.of("x"), false, null),
                        "x",
                        "x",
                        "x",
                        "x",
                        new Page<>(List.of(true), false, null),
                        "x",
                        1,
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }
}
