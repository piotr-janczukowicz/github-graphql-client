package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdatePullRequestReviewCommentPayloadTest {

    @Test
    void constructor_shouldFail_whenBodyIsNull() {
        final UpdatePullRequestReviewCommentPayloadBuilder builder =
                UpdatePullRequestReviewCommentPayloadBuilder.builder().pullRequestReviewCommentId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("body must not be null");
    }

    @Test
    void constructor_shouldFail_whenPullRequestReviewCommentIdIsNull() {
        final UpdatePullRequestReviewCommentPayloadBuilder builder =
                UpdatePullRequestReviewCommentPayloadBuilder.builder().body("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("pullRequestReviewCommentId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdatePullRequestReviewCommentPayload input = UpdatePullRequestReviewCommentPayloadBuilder.builder()
                .body("x")
                .pullRequestReviewCommentId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("body", "x"), entry("pullRequestReviewCommentId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdatePullRequestReviewCommentPayload input = UpdatePullRequestReviewCommentPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .pullRequestReviewCommentId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"), entry("clientMutationId", "x"), entry("pullRequestReviewCommentId", "x"));
    }
}
