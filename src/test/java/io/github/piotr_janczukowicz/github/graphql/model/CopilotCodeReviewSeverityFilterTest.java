package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class CopilotCodeReviewSeverityFilterTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final CopilotCodeReviewSeverityFilter copilotCodeReviewSeverityFilter =
                CopilotCodeReviewSeverityFilter.fromWire("LOW");

        assertThat(copilotCodeReviewSeverityFilter).isEqualTo(CopilotCodeReviewSeverityFilter.LOW);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final CopilotCodeReviewSeverityFilter copilotCodeReviewSeverityFilter =
                CopilotCodeReviewSeverityFilter.fromWire("NOT_A_VALUE");

        assertThat(copilotCodeReviewSeverityFilter).isEqualTo(CopilotCodeReviewSeverityFilter.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> CopilotCodeReviewSeverityFilter.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = CopilotCodeReviewSeverityFilter.LOW.wireValue();

        assertThat(value).isEqualTo("LOW");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(CopilotCodeReviewSeverityFilter.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
