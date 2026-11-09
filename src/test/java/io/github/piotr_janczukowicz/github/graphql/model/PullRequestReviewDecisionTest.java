package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PullRequestReviewDecisionTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final PullRequestReviewDecision pullRequestReviewDecision = PullRequestReviewDecision.fromWire("APPROVED");

        assertThat(pullRequestReviewDecision).isEqualTo(PullRequestReviewDecision.APPROVED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final PullRequestReviewDecision pullRequestReviewDecision = PullRequestReviewDecision.fromWire("NOT_A_VALUE");

        assertThat(pullRequestReviewDecision).isEqualTo(PullRequestReviewDecision.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> PullRequestReviewDecision.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
