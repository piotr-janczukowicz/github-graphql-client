package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddAssigneesToAssignablePayloadTest {

    @Test
    void constructor_shouldFail_whenAssignableIdIsNull() {
        final AddAssigneesToAssignablePayloadBuilder builder = AddAssigneesToAssignablePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("assignableId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddAssigneesToAssignablePayload input = AddAssigneesToAssignablePayloadBuilder.builder()
                .assignableId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("assignableId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddAssigneesToAssignablePayload input = AddAssigneesToAssignablePayloadBuilder.builder()
                .agentAssignment(AgentAssignmentInputBuilder.builder().build())
                .assignableId("x")
                .assigneeIds(List.of("x"))
                .assignees(List.of(
                        AssigneeUpdateInputBuilder.builder().actorId("x").build()))
                .clientMutationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("agentAssignment", Map.ofEntries()),
                        entry("assignableId", "x"),
                        entry("assigneeIds", List.of("x")),
                        entry("assignees", List.of(Map.ofEntries(entry("actorId", "x")))),
                        entry("clientMutationId", "x"));
    }
}
