package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateDeploymentPayloadTest {

    @Test
    void constructor_shouldFail_whenRefIdIsNull() {
        final CreateDeploymentPayloadBuilder builder =
                CreateDeploymentPayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("refId must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final CreateDeploymentPayloadBuilder builder =
                CreateDeploymentPayloadBuilder.builder().refId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateDeploymentPayload input = CreateDeploymentPayloadBuilder.builder()
                .refId("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("refId", "x"), entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateDeploymentPayload input = CreateDeploymentPayloadBuilder.builder()
                .autoMerge(true)
                .clientMutationId("x")
                .description("x")
                .environment("x")
                .payload("x")
                .refId("x")
                .repositoryId("x")
                .requiredContexts(List.of("x"))
                .task("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("autoMerge", true),
                        entry("clientMutationId", "x"),
                        entry("description", "x"),
                        entry("environment", "x"),
                        entry("payload", "x"),
                        entry("refId", "x"),
                        entry("repositoryId", "x"),
                        entry("requiredContexts", List.of("x")),
                        entry("task", "x"));
    }
}
