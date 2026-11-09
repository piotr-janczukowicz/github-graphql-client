package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrgRemoveOutsideCollaboratorAuditEntryReasonTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrgRemoveOutsideCollaboratorAuditEntryReason orgRemoveOutsideCollaboratorAuditEntryReason =
                OrgRemoveOutsideCollaboratorAuditEntryReason.fromWire("SAML_EXTERNAL_IDENTITY_MISSING");

        assertThat(orgRemoveOutsideCollaboratorAuditEntryReason)
                .isEqualTo(OrgRemoveOutsideCollaboratorAuditEntryReason.SAML_EXTERNAL_IDENTITY_MISSING);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrgRemoveOutsideCollaboratorAuditEntryReason orgRemoveOutsideCollaboratorAuditEntryReason =
                OrgRemoveOutsideCollaboratorAuditEntryReason.fromWire("NOT_A_VALUE");

        assertThat(orgRemoveOutsideCollaboratorAuditEntryReason)
                .isEqualTo(OrgRemoveOutsideCollaboratorAuditEntryReason.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrgRemoveOutsideCollaboratorAuditEntryReason.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
