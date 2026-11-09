package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PullRequestMergeMethodTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final PullRequestMergeMethod pullRequestMergeMethod = PullRequestMergeMethod.fromWire("MERGE");

        assertThat(pullRequestMergeMethod).isEqualTo(PullRequestMergeMethod.MERGE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final PullRequestMergeMethod pullRequestMergeMethod = PullRequestMergeMethod.fromWire("NOT_A_VALUE");

        assertThat(pullRequestMergeMethod).isEqualTo(PullRequestMergeMethod.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> PullRequestMergeMethod.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = PullRequestMergeMethod.MERGE.wireValue();

        assertThat(value).isEqualTo("MERGE");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(PullRequestMergeMethod.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
