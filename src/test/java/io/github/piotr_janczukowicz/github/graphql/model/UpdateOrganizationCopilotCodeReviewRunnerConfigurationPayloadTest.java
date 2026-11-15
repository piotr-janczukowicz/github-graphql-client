package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayloadTest {

    @Test
    void constructor_shouldFail_whenOrganizationIdIsNull() {
        final UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayloadBuilder builder =
                UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayloadBuilder.builder()
                        .runnerType(CopilotCodeReviewRunnerType.LABELED);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("organizationId must not be null");
    }

    @Test
    void constructor_shouldFail_whenRunnerTypeIsNull() {
        final UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayloadBuilder builder =
                UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayloadBuilder.builder()
                        .organizationId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("runnerType must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayload input =
                UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayloadBuilder.builder()
                        .organizationId("x")
                        .runnerType(CopilotCodeReviewRunnerType.LABELED)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("organizationId", "x"), entry("runnerType", "LABELED"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayload input =
                UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayloadBuilder.builder()
                        .allowRepositoryCustomization(true)
                        .clientMutationId("x")
                        .organizationId("x")
                        .runnerGroupName("x")
                        .runnerLabels(List.of("x"))
                        .runnerType(CopilotCodeReviewRunnerType.LABELED)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("allowRepositoryCustomization", true),
                        entry("clientMutationId", "x"),
                        entry("organizationId", "x"),
                        entry("runnerGroupName", "x"),
                        entry("runnerLabels", List.of("x")),
                        entry("runnerType", "LABELED"));
    }
}
