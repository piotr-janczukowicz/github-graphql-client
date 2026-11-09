package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateIssuePayloadTest {

    @Test
    void constructor_shouldFail_whenIdIsNull() {
        final UpdateIssuePayloadBuilder builder = UpdateIssuePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("id must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateIssuePayload input =
                UpdateIssuePayloadBuilder.builder().id("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("id", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateIssuePayload input = UpdateIssuePayloadBuilder.builder()
                .agentAssignment(AgentAssignmentInputBuilder.builder().build())
                .assigneeIds(List.of("x"))
                .assignees(List.of(
                        AssigneeUpdateInputBuilder.builder().actorId("x").build()))
                .body("x")
                .clientMutationId("x")
                .id("x")
                .issueFieldUpdates(List.of(IssueFieldUpdateInputBuilder.builder()
                        .fieldName("x")
                        .operation(IssueFieldUpdateOperation.ADD)
                        .build()))
                .issueType(IssueTypeUpdateInputBuilder.builder().build())
                .issueTypeId("x")
                .labelIds(List.of("x"))
                .labels(List.of(LabelUpdateInputBuilder.builder().labelId("x").build()))
                .milestoneId("x")
                .projectIds(List.of("x"))
                .state(IssueState.CLOSED)
                .stateInput(IssueStateUpdateInputBuilder.builder()
                        .value(IssueState.CLOSED)
                        .build())
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("agentAssignment", Map.ofEntries()),
                        entry("assigneeIds", List.of("x")),
                        entry("assignees", List.of(Map.ofEntries(entry("actorId", "x")))),
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("id", "x"),
                        entry(
                                "issueFieldUpdates",
                                List.of(Map.ofEntries(entry("fieldName", "x"), entry("operation", "ADD")))),
                        entry("issueType", Map.ofEntries()),
                        entry("issueTypeId", "x"),
                        entry("labelIds", List.of("x")),
                        entry("labels", List.of(Map.ofEntries(entry("labelId", "x")))),
                        entry("milestoneId", "x"),
                        entry("projectIds", List.of("x")),
                        entry("state", "CLOSED"),
                        entry("stateInput", Map.ofEntries(entry("value", "CLOSED"))),
                        entry("title", "x"));
    }
}
