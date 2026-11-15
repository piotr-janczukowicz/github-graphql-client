package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class CopilotCodeReviewRequestReasonTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final CopilotCodeReviewRequestReason copilotCodeReviewRequestReason =
                CopilotCodeReviewRequestReason.fromWire("ACTOR_INELIGIBLE");

        assertThat(copilotCodeReviewRequestReason).isEqualTo(CopilotCodeReviewRequestReason.ACTOR_INELIGIBLE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final CopilotCodeReviewRequestReason copilotCodeReviewRequestReason =
                CopilotCodeReviewRequestReason.fromWire("NOT_A_VALUE");

        assertThat(copilotCodeReviewRequestReason).isEqualTo(CopilotCodeReviewRequestReason.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> CopilotCodeReviewRequestReason.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
