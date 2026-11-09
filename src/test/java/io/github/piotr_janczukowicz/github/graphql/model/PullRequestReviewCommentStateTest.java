package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PullRequestReviewCommentStateTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final PullRequestReviewCommentState pullRequestReviewCommentState =
                PullRequestReviewCommentState.fromWire("PENDING");

        assertThat(pullRequestReviewCommentState).isEqualTo(PullRequestReviewCommentState.PENDING);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final PullRequestReviewCommentState pullRequestReviewCommentState =
                PullRequestReviewCommentState.fromWire("NOT_A_VALUE");

        assertThat(pullRequestReviewCommentState).isEqualTo(PullRequestReviewCommentState.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> PullRequestReviewCommentState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
