package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PullRequestAllowedMergeMethodsTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final PullRequestAllowedMergeMethods pullRequestAllowedMergeMethods =
                PullRequestAllowedMergeMethods.fromWire("MERGE");

        assertThat(pullRequestAllowedMergeMethods).isEqualTo(PullRequestAllowedMergeMethods.MERGE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final PullRequestAllowedMergeMethods pullRequestAllowedMergeMethods =
                PullRequestAllowedMergeMethods.fromWire("NOT_A_VALUE");

        assertThat(pullRequestAllowedMergeMethods).isEqualTo(PullRequestAllowedMergeMethods.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> PullRequestAllowedMergeMethods.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = PullRequestAllowedMergeMethods.MERGE.wireValue();

        assertThat(value).isEqualTo("MERGE");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(PullRequestAllowedMergeMethods.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
