package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PullRequestCreationPolicyTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final PullRequestCreationPolicy pullRequestCreationPolicy = PullRequestCreationPolicy.fromWire("ALL");

        assertThat(pullRequestCreationPolicy).isEqualTo(PullRequestCreationPolicy.ALL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final PullRequestCreationPolicy pullRequestCreationPolicy = PullRequestCreationPolicy.fromWire("NOT_A_VALUE");

        assertThat(pullRequestCreationPolicy).isEqualTo(PullRequestCreationPolicy.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> PullRequestCreationPolicy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = PullRequestCreationPolicy.ALL.wireValue();

        assertThat(value).isEqualTo("ALL");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(PullRequestCreationPolicy.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
