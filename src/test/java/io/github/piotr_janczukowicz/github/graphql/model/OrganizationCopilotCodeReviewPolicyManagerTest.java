package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrganizationCopilotCodeReviewPolicyManagerTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrganizationCopilotCodeReviewPolicyManager organizationCopilotCodeReviewPolicyManager =
                OrganizationCopilotCodeReviewPolicyManager.fromWire("ENTERPRISE");

        assertThat(organizationCopilotCodeReviewPolicyManager)
                .isEqualTo(OrganizationCopilotCodeReviewPolicyManager.ENTERPRISE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrganizationCopilotCodeReviewPolicyManager organizationCopilotCodeReviewPolicyManager =
                OrganizationCopilotCodeReviewPolicyManager.fromWire("NOT_A_VALUE");

        assertThat(organizationCopilotCodeReviewPolicyManager)
                .isEqualTo(OrganizationCopilotCodeReviewPolicyManager.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrganizationCopilotCodeReviewPolicyManager.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
