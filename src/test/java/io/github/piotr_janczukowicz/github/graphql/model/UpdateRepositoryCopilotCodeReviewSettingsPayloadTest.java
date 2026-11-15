package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateRepositoryCopilotCodeReviewSettingsPayloadTest {

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final UpdateRepositoryCopilotCodeReviewSettingsPayloadBuilder builder =
                UpdateRepositoryCopilotCodeReviewSettingsPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateRepositoryCopilotCodeReviewSettingsPayload input =
                UpdateRepositoryCopilotCodeReviewSettingsPayloadBuilder.builder()
                        .repositoryId("x")
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateRepositoryCopilotCodeReviewSettingsPayload input =
                UpdateRepositoryCopilotCodeReviewSettingsPayloadBuilder.builder()
                        .clientMutationId("x")
                        .customInstructionsEnabled(true)
                        .mcpEnabled(true)
                        .repositoryId("x")
                        .reviewEffort(RepositoryCopilotCodeReviewEffortSetting.AUTO)
                        .severityFilter(CopilotCodeReviewSeverityFilter.LOW)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("customInstructionsEnabled", true),
                        entry("mcpEnabled", true),
                        entry("repositoryId", "x"),
                        entry("reviewEffort", "AUTO"),
                        entry("severityFilter", "LOW"));
    }
}
