package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RejectDeploymentsPayloadTest {

    @Test
    void constructor_shouldFail_whenEnvironmentIdsIsNull() {
        final RejectDeploymentsPayloadBuilder builder =
                RejectDeploymentsPayloadBuilder.builder().workflowRunId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("environmentIds must not be null");
    }

    @Test
    void constructor_shouldFail_whenWorkflowRunIdIsNull() {
        final RejectDeploymentsPayloadBuilder builder =
                RejectDeploymentsPayloadBuilder.builder().environmentIds(List.of("x"));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("workflowRunId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RejectDeploymentsPayload input = RejectDeploymentsPayloadBuilder.builder()
                .environmentIds(List.of("x"))
                .workflowRunId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("environmentIds", List.of("x")), entry("workflowRunId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RejectDeploymentsPayload input = RejectDeploymentsPayloadBuilder.builder()
                .clientMutationId("x")
                .comment("x")
                .environmentIds(List.of("x"))
                .workflowRunId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("comment", "x"),
                        entry("environmentIds", List.of("x")),
                        entry("workflowRunId", "x"));
    }
}
