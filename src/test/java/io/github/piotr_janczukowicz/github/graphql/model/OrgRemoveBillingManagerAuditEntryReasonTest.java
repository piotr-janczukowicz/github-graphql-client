package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrgRemoveBillingManagerAuditEntryReasonTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrgRemoveBillingManagerAuditEntryReason orgRemoveBillingManagerAuditEntryReason =
                OrgRemoveBillingManagerAuditEntryReason.fromWire("SAML_EXTERNAL_IDENTITY_MISSING");

        assertThat(orgRemoveBillingManagerAuditEntryReason)
                .isEqualTo(OrgRemoveBillingManagerAuditEntryReason.SAML_EXTERNAL_IDENTITY_MISSING);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrgRemoveBillingManagerAuditEntryReason orgRemoveBillingManagerAuditEntryReason =
                OrgRemoveBillingManagerAuditEntryReason.fromWire("NOT_A_VALUE");

        assertThat(orgRemoveBillingManagerAuditEntryReason)
                .isEqualTo(OrgRemoveBillingManagerAuditEntryReason.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrgRemoveBillingManagerAuditEntryReason.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
