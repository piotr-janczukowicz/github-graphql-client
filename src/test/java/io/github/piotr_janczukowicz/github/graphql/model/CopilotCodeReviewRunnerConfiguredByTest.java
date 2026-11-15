package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class CopilotCodeReviewRunnerConfiguredByTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final CopilotCodeReviewRunnerConfiguredBy copilotCodeReviewRunnerConfiguredBy =
                CopilotCodeReviewRunnerConfiguredBy.fromWire("CODE_REVIEW");

        assertThat(copilotCodeReviewRunnerConfiguredBy).isEqualTo(CopilotCodeReviewRunnerConfiguredBy.CODE_REVIEW);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final CopilotCodeReviewRunnerConfiguredBy copilotCodeReviewRunnerConfiguredBy =
                CopilotCodeReviewRunnerConfiguredBy.fromWire("NOT_A_VALUE");

        assertThat(copilotCodeReviewRunnerConfiguredBy).isEqualTo(CopilotCodeReviewRunnerConfiguredBy.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> CopilotCodeReviewRunnerConfiguredBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
