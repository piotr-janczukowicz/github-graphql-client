package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateDeploymentStatusPayloadTest {

    @Test
    void constructor_shouldFail_whenDeploymentIdIsNull() {
        final CreateDeploymentStatusPayloadBuilder builder =
                CreateDeploymentStatusPayloadBuilder.builder().state(DeploymentStatusState.ERROR);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("deploymentId must not be null");
    }

    @Test
    void constructor_shouldFail_whenStateIsNull() {
        final CreateDeploymentStatusPayloadBuilder builder =
                CreateDeploymentStatusPayloadBuilder.builder().deploymentId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("state must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateDeploymentStatusPayload input = CreateDeploymentStatusPayloadBuilder.builder()
                .deploymentId("x")
                .state(DeploymentStatusState.ERROR)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("deploymentId", "x"), entry("state", "ERROR"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateDeploymentStatusPayload input = CreateDeploymentStatusPayloadBuilder.builder()
                .autoInactive(true)
                .clientMutationId("x")
                .deploymentId("x")
                .description("x")
                .environment("x")
                .environmentUrl("x")
                .logUrl("x")
                .state(DeploymentStatusState.ERROR)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("autoInactive", true),
                        entry("clientMutationId", "x"),
                        entry("deploymentId", "x"),
                        entry("description", "x"),
                        entry("environment", "x"),
                        entry("environmentUrl", "x"),
                        entry("logUrl", "x"),
                        entry("state", "ERROR"));
    }
}
