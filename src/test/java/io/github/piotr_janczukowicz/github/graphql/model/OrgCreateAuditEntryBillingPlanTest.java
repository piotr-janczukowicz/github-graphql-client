package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrgCreateAuditEntryBillingPlanTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrgCreateAuditEntryBillingPlan orgCreateAuditEntryBillingPlan =
                OrgCreateAuditEntryBillingPlan.fromWire("BUSINESS");

        assertThat(orgCreateAuditEntryBillingPlan).isEqualTo(OrgCreateAuditEntryBillingPlan.BUSINESS);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrgCreateAuditEntryBillingPlan orgCreateAuditEntryBillingPlan =
                OrgCreateAuditEntryBillingPlan.fromWire("NOT_A_VALUE");

        assertThat(orgCreateAuditEntryBillingPlan).isEqualTo(OrgCreateAuditEntryBillingPlan.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrgCreateAuditEntryBillingPlan.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
