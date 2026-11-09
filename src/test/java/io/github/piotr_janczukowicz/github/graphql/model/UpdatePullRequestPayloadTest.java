package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdatePullRequestPayloadTest {

    @Test
    void constructor_shouldFail_whenPullRequestIdIsNull() {
        final UpdatePullRequestPayloadBuilder builder = UpdatePullRequestPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pullRequestId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdatePullRequestPayload input =
                UpdatePullRequestPayloadBuilder.builder().pullRequestId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("pullRequestId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdatePullRequestPayload input = UpdatePullRequestPayloadBuilder.builder()
                .assigneeIds(List.of("x"))
                .baseRefName("x")
                .body("x")
                .clientMutationId("x")
                .labelIds(List.of("x"))
                .maintainerCanModify(true)
                .milestoneId("x")
                .projectIds(List.of("x"))
                .pullRequestId("x")
                .state(PullRequestUpdateState.CLOSED)
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("assigneeIds", List.of("x")),
                        entry("baseRefName", "x"),
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("labelIds", List.of("x")),
                        entry("maintainerCanModify", true),
                        entry("milestoneId", "x"),
                        entry("projectIds", List.of("x")),
                        entry("pullRequestId", "x"),
                        entry("state", "CLOSED"),
                        entry("title", "x"));
    }
}
