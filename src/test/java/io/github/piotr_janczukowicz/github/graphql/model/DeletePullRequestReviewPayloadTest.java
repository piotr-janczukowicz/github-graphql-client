package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DeletePullRequestReviewPayloadTest {

    @Test
    void constructor_shouldFail_whenPullRequestReviewIdIsNull() {
        final DeletePullRequestReviewPayloadBuilder builder = DeletePullRequestReviewPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pullRequestReviewId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeletePullRequestReviewPayload input = DeletePullRequestReviewPayloadBuilder.builder()
                .pullRequestReviewId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("pullRequestReviewId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeletePullRequestReviewPayload input = DeletePullRequestReviewPayloadBuilder.builder()
                .clientMutationId("x")
                .pullRequestReviewId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("pullRequestReviewId", "x"));
    }
}
