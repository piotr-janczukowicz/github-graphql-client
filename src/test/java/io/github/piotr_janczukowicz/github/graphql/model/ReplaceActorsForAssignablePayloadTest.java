package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ReplaceActorsForAssignablePayloadTest {

    @Test
    void constructor_shouldFail_whenAssignableIdIsNull() {
        final ReplaceActorsForAssignablePayloadBuilder builder = ReplaceActorsForAssignablePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("assignableId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ReplaceActorsForAssignablePayload input = ReplaceActorsForAssignablePayloadBuilder.builder()
                .assignableId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("assignableId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ReplaceActorsForAssignablePayload input = ReplaceActorsForAssignablePayloadBuilder.builder()
                .actorIds(List.of("x"))
                .actorLogins(List.of("x"))
                .agentAssignment(AgentAssignmentInputBuilder.builder().build())
                .assignableId("x")
                .assignees(List.of(
                        AssigneeUpdateInputBuilder.builder().actorId("x").build()))
                .clientMutationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("actorIds", List.of("x")),
                        entry("actorLogins", List.of("x")),
                        entry("agentAssignment", Map.ofEntries()),
                        entry("assignableId", "x"),
                        entry("assignees", List.of(Map.ofEntries(entry("actorId", "x")))),
                        entry("clientMutationId", "x"));
    }
}
