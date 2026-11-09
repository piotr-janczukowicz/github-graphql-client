package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CheckAnnotationLevel;
import io.github.piotr_janczukowicz.github.graphql.model.CheckAnnotationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckConclusionState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunIsRequiredFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunStepsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CheckStatusState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckStepSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CheckRunSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"annotations\":{\"nodes\": [{\"annotationLevel\": \"FAILURE\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"checkSuite\":{\"conclusion\": \"ACTION_REQUIRED\"}" + ","
            + "\"completedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"conclusion\":\"ACTION_REQUIRED\"" + ","
            + "\"databaseId\":1" + "," + "\"deployment\":{\"commitOid\": \"x\"}" + "," + "\"detailsUrl\":\"x\"" + ","
            + "\"externalId\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"isRequired\":true" + "," + "\"name\":\"x\"" + ","
            + "\"pendingDeploymentRequest\":{\"currentUserCanApprove\": true}" + "," + "\"permalink\":\"x\"" + ","
            + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"startedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"status\":\"COMPLETED\"" + ","
            + "\"steps\":{\"nodes\": [{\"completedAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"summary\":\"x\"" + "," + "\"text\":\"x\"" + "," + "\"title\":\"x\"" + "," + "\"url\":\"x\""
            + "}";

    private static List<Object> readWithArguments(final CheckRunSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.annotations(Paging.first(1), CheckAnnotationSelector::annotationLevel));
        values.add(selector.checkSuite(CheckSuiteSelector::conclusion));
        values.add(selector.completedAt());
        values.add(selector.conclusion());
        values.add(selector.databaseId());
        values.add(selector.deployment(DeploymentSelector::commitOid));
        values.add(selector.detailsUrl());
        values.add(selector.externalId());
        values.add(selector.id());
        values.add(selector.isRequired(CheckRunIsRequiredFilterBuilder.builder()
                .pullRequestId("x")
                .pullRequestNumber(1)
                .build()));
        values.add(selector.name());
        values.add(selector.pendingDeploymentRequest(DeploymentRequestSelector::currentUserCanApprove));
        values.add(selector.permalink());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.startedAt());
        values.add(selector.status());
        values.add(selector.steps(
                Paging.first(1),
                CheckRunStepsFilterBuilder.builder().number(1).build(),
                CheckStepSelector::completedAt));
        values.add(selector.summary());
        values.add(selector.text());
        values.add(selector.title());
        values.add(selector.url());
        return values;
    }

    private static List<Object> readWithoutArguments(final CheckRunSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.isRequired());
        values.add(selector.steps(Paging.first(1), CheckStepSelector::completedAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CheckRunSelectorImpl(new RecordingCursor(root)));
        final CheckRunSelectorImpl selector =
                new CheckRunSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(CheckAnnotationLevel.FAILURE), false, null),
                        CheckConclusionState.ACTION_REQUIRED,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        CheckConclusionState.ACTION_REQUIRED,
                        1,
                        "x",
                        "x",
                        "x",
                        "x",
                        true,
                        "x",
                        true,
                        "x",
                        true,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        CheckStatusState.COMPLETED,
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        "x",
                        "x",
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new CheckRunSelectorImpl(new RecordingCursor(root)));
        final CheckRunSelectorImpl selector =
                new CheckRunSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(true, new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }
}
