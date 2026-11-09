package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddPullRequestReviewThreadPayloadTest {

    @Test
    void constructor_shouldFail_whenBodyIsNull() {
        final AddPullRequestReviewThreadPayloadBuilder builder = AddPullRequestReviewThreadPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("body must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddPullRequestReviewThreadPayload input =
                AddPullRequestReviewThreadPayloadBuilder.builder().body("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("body", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddPullRequestReviewThreadPayload input = AddPullRequestReviewThreadPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .line(1)
                .path("x")
                .pullRequestId("x")
                .pullRequestReviewId("x")
                .side(DiffSide.LEFT)
                .startLine(1)
                .startSide(DiffSide.LEFT)
                .subjectType(PullRequestReviewThreadSubjectType.FILE)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("line", 1),
                        entry("path", "x"),
                        entry("pullRequestId", "x"),
                        entry("pullRequestReviewId", "x"),
                        entry("side", "LEFT"),
                        entry("startLine", 1),
                        entry("startSide", "LEFT"),
                        entry("subjectType", "FILE"));
    }
}
