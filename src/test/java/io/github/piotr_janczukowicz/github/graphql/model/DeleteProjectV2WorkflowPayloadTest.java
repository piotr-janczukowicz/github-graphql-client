package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DeleteProjectV2WorkflowPayloadTest {

    @Test
    void constructor_shouldFail_whenWorkflowIdIsNull() {
        final DeleteProjectV2WorkflowPayloadBuilder builder = DeleteProjectV2WorkflowPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("workflowId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeleteProjectV2WorkflowPayload input =
                DeleteProjectV2WorkflowPayloadBuilder.builder().workflowId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("workflowId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeleteProjectV2WorkflowPayload input = DeleteProjectV2WorkflowPayloadBuilder.builder()
                .clientMutationId("x")
                .workflowId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("workflowId", "x"));
    }
}
