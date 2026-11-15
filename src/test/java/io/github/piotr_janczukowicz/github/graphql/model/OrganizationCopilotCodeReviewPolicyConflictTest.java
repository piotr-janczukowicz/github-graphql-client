package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrganizationCopilotCodeReviewPolicyConflictTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrganizationCopilotCodeReviewPolicyConflict organizationCopilotCodeReviewPolicyConflict =
                OrganizationCopilotCodeReviewPolicyConflict.fromWire("POLICY_MANAGED_BY_ENTERPRISE");

        assertThat(organizationCopilotCodeReviewPolicyConflict)
                .isEqualTo(OrganizationCopilotCodeReviewPolicyConflict.POLICY_MANAGED_BY_ENTERPRISE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrganizationCopilotCodeReviewPolicyConflict organizationCopilotCodeReviewPolicyConflict =
                OrganizationCopilotCodeReviewPolicyConflict.fromWire("NOT_A_VALUE");

        assertThat(organizationCopilotCodeReviewPolicyConflict)
                .isEqualTo(OrganizationCopilotCodeReviewPolicyConflict.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrganizationCopilotCodeReviewPolicyConflict.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
