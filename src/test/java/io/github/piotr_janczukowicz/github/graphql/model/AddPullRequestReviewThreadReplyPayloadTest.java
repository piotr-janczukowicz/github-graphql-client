package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddPullRequestReviewThreadReplyPayloadTest {

    @Test
    void constructor_shouldFail_whenBodyIsNull() {
        final AddPullRequestReviewThreadReplyPayloadBuilder builder =
                AddPullRequestReviewThreadReplyPayloadBuilder.builder().pullRequestReviewThreadId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("body must not be null");
    }

    @Test
    void constructor_shouldFail_whenPullRequestReviewThreadIdIsNull() {
        final AddPullRequestReviewThreadReplyPayloadBuilder builder =
                AddPullRequestReviewThreadReplyPayloadBuilder.builder().body("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("pullRequestReviewThreadId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddPullRequestReviewThreadReplyPayload input = AddPullRequestReviewThreadReplyPayloadBuilder.builder()
                .body("x")
                .pullRequestReviewThreadId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("body", "x"), entry("pullRequestReviewThreadId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddPullRequestReviewThreadReplyPayload input = AddPullRequestReviewThreadReplyPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .pullRequestReviewId("x")
                .pullRequestReviewThreadId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("pullRequestReviewId", "x"),
                        entry("pullRequestReviewThreadId", "x"));
    }
}
