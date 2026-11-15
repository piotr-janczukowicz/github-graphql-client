package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class EnterpriseCopilotCodeReviewPolicyStateTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final EnterpriseCopilotCodeReviewPolicyState enterpriseCopilotCodeReviewPolicyState =
                EnterpriseCopilotCodeReviewPolicyState.fromWire("CONFIGURED_BY_ORGANIZATION_ADMINS");

        assertThat(enterpriseCopilotCodeReviewPolicyState)
                .isEqualTo(EnterpriseCopilotCodeReviewPolicyState.CONFIGURED_BY_ORGANIZATION_ADMINS);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final EnterpriseCopilotCodeReviewPolicyState enterpriseCopilotCodeReviewPolicyState =
                EnterpriseCopilotCodeReviewPolicyState.fromWire("NOT_A_VALUE");

        assertThat(enterpriseCopilotCodeReviewPolicyState)
                .isEqualTo(EnterpriseCopilotCodeReviewPolicyState.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> EnterpriseCopilotCodeReviewPolicyState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = EnterpriseCopilotCodeReviewPolicyState.CONFIGURED_BY_ORGANIZATION_ADMINS.wireValue();

        assertThat(value).isEqualTo("CONFIGURED_BY_ORGANIZATION_ADMINS");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(EnterpriseCopilotCodeReviewPolicyState.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
