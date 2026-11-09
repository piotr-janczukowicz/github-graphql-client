package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdatePullRequestReviewPayloadTest {

    @Test
    void constructor_shouldFail_whenBodyIsNull() {
        final UpdatePullRequestReviewPayloadBuilder builder =
                UpdatePullRequestReviewPayloadBuilder.builder().pullRequestReviewId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("body must not be null");
    }

    @Test
    void constructor_shouldFail_whenPullRequestReviewIdIsNull() {
        final UpdatePullRequestReviewPayloadBuilder builder =
                UpdatePullRequestReviewPayloadBuilder.builder().body("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pullRequestReviewId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdatePullRequestReviewPayload input = UpdatePullRequestReviewPayloadBuilder.builder()
                .body("x")
                .pullRequestReviewId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("body", "x"), entry("pullRequestReviewId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdatePullRequestReviewPayload input = UpdatePullRequestReviewPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .pullRequestReviewId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("body", "x"), entry("clientMutationId", "x"), entry("pullRequestReviewId", "x"));
    }
}
