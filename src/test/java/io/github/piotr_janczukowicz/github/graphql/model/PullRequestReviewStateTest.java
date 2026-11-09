package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PullRequestReviewStateTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final PullRequestReviewState pullRequestReviewState = PullRequestReviewState.fromWire("APPROVED");

        assertThat(pullRequestReviewState).isEqualTo(PullRequestReviewState.APPROVED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final PullRequestReviewState pullRequestReviewState = PullRequestReviewState.fromWire("NOT_A_VALUE");

        assertThat(pullRequestReviewState).isEqualTo(PullRequestReviewState.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> PullRequestReviewState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
