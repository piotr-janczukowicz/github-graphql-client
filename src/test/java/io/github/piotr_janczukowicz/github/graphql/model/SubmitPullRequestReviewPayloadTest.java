package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class SubmitPullRequestReviewPayloadTest {

    @Test
    void constructor_shouldFail_whenEventIsNull() {
        final SubmitPullRequestReviewPayloadBuilder builder = SubmitPullRequestReviewPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("event must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final SubmitPullRequestReviewPayload input = SubmitPullRequestReviewPayloadBuilder.builder()
                .event(PullRequestReviewEvent.APPROVE)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("event", "APPROVE"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final SubmitPullRequestReviewPayload input = SubmitPullRequestReviewPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .event(PullRequestReviewEvent.APPROVE)
                .pullRequestId("x")
                .pullRequestReviewId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("event", "APPROVE"),
                        entry("pullRequestId", "x"),
                        entry("pullRequestReviewId", "x"));
    }
}
