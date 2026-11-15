package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class CopilotCodeReviewEffortTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final CopilotCodeReviewEffort copilotCodeReviewEffort = CopilotCodeReviewEffort.fromWire("AUTO");

        assertThat(copilotCodeReviewEffort).isEqualTo(CopilotCodeReviewEffort.AUTO);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final CopilotCodeReviewEffort copilotCodeReviewEffort = CopilotCodeReviewEffort.fromWire("NOT_A_VALUE");

        assertThat(copilotCodeReviewEffort).isEqualTo(CopilotCodeReviewEffort.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> CopilotCodeReviewEffort.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = CopilotCodeReviewEffort.AUTO.wireValue();

        assertThat(value).isEqualTo("AUTO");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(CopilotCodeReviewEffort.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
