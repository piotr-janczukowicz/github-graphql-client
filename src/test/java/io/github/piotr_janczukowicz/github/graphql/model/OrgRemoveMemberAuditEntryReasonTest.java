package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrgRemoveMemberAuditEntryReasonTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrgRemoveMemberAuditEntryReason orgRemoveMemberAuditEntryReason =
                OrgRemoveMemberAuditEntryReason.fromWire("SAML_EXTERNAL_IDENTITY_MISSING");

        assertThat(orgRemoveMemberAuditEntryReason)
                .isEqualTo(OrgRemoveMemberAuditEntryReason.SAML_EXTERNAL_IDENTITY_MISSING);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrgRemoveMemberAuditEntryReason orgRemoveMemberAuditEntryReason =
                OrgRemoveMemberAuditEntryReason.fromWire("NOT_A_VALUE");

        assertThat(orgRemoveMemberAuditEntryReason).isEqualTo(OrgRemoveMemberAuditEntryReason.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrgRemoveMemberAuditEntryReason.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
