package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PullRequestReviewThreadSubjectTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final PullRequestReviewThreadSubjectType pullRequestReviewThreadSubjectType =
                PullRequestReviewThreadSubjectType.fromWire("FILE");

        assertThat(pullRequestReviewThreadSubjectType).isEqualTo(PullRequestReviewThreadSubjectType.FILE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final PullRequestReviewThreadSubjectType pullRequestReviewThreadSubjectType =
                PullRequestReviewThreadSubjectType.fromWire("NOT_A_VALUE");

        assertThat(pullRequestReviewThreadSubjectType).isEqualTo(PullRequestReviewThreadSubjectType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> PullRequestReviewThreadSubjectType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = PullRequestReviewThreadSubjectType.FILE.wireValue();

        assertThat(value).isEqualTo("FILE");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(PullRequestReviewThreadSubjectType.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
