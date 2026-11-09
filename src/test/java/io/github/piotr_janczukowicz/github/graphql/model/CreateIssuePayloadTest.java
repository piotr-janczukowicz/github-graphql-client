package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateIssuePayloadTest {

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final CreateIssuePayloadBuilder builder =
                CreateIssuePayloadBuilder.builder().title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void constructor_shouldFail_whenTitleIsNull() {
        final CreateIssuePayloadBuilder builder =
                CreateIssuePayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("title must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateIssuePayload input =
                CreateIssuePayloadBuilder.builder().repositoryId("x").title("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("repositoryId", "x"), entry("title", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateIssuePayload input = CreateIssuePayloadBuilder.builder()
                .agentAssignment(AgentAssignmentInputBuilder.builder().build())
                .assigneeIds(List.of("x"))
                .body("x")
                .clientMutationId("x")
                .issueFields(List.of(IssueFieldCreateOrUpdateInputBuilder.builder()
                        .fieldId("x")
                        .build()))
                .issueTemplate("x")
                .issueTypeId("x")
                .labelIds(List.of("x"))
                .milestoneId("x")
                .parentIssueId("x")
                .projectIds(List.of("x"))
                .projectV2Ids(List.of("x"))
                .repositoryId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("agentAssignment", Map.ofEntries()),
                        entry("assigneeIds", List.of("x")),
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("issueFields", List.of(Map.ofEntries(entry("fieldId", "x")))),
                        entry("issueTemplate", "x"),
                        entry("issueTypeId", "x"),
                        entry("labelIds", List.of("x")),
                        entry("milestoneId", "x"),
                        entry("parentIssueId", "x"),
                        entry("projectIds", List.of("x")),
                        entry("projectV2Ids", List.of("x")),
                        entry("repositoryId", "x"),
                        entry("title", "x"));
    }
}
