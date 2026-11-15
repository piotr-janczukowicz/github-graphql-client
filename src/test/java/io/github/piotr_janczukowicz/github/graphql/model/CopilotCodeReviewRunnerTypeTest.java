package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class CopilotCodeReviewRunnerTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final CopilotCodeReviewRunnerType copilotCodeReviewRunnerType = CopilotCodeReviewRunnerType.fromWire("LABELED");

        assertThat(copilotCodeReviewRunnerType).isEqualTo(CopilotCodeReviewRunnerType.LABELED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final CopilotCodeReviewRunnerType copilotCodeReviewRunnerType =
                CopilotCodeReviewRunnerType.fromWire("NOT_A_VALUE");

        assertThat(copilotCodeReviewRunnerType).isEqualTo(CopilotCodeReviewRunnerType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> CopilotCodeReviewRunnerType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = CopilotCodeReviewRunnerType.LABELED.wireValue();

        assertThat(value).isEqualTo("LABELED");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(CopilotCodeReviewRunnerType.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
