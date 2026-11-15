package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class CopilotCodeReviewSourceKindTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final CopilotCodeReviewSourceKind copilotCodeReviewSourceKind =
                CopilotCodeReviewSourceKind.fromWire("CUSTOM_INSTRUCTIONS");

        assertThat(copilotCodeReviewSourceKind).isEqualTo(CopilotCodeReviewSourceKind.CUSTOM_INSTRUCTIONS);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final CopilotCodeReviewSourceKind copilotCodeReviewSourceKind =
                CopilotCodeReviewSourceKind.fromWire("NOT_A_VALUE");

        assertThat(copilotCodeReviewSourceKind).isEqualTo(CopilotCodeReviewSourceKind.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> CopilotCodeReviewSourceKind.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
