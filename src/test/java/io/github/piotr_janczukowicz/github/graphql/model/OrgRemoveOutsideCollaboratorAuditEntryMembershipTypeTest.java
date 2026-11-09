package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrgRemoveOutsideCollaboratorAuditEntryMembershipTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrgRemoveOutsideCollaboratorAuditEntryMembershipType
                orgRemoveOutsideCollaboratorAuditEntryMembershipType =
                        OrgRemoveOutsideCollaboratorAuditEntryMembershipType.fromWire("BILLING_MANAGER");

        assertThat(orgRemoveOutsideCollaboratorAuditEntryMembershipType)
                .isEqualTo(OrgRemoveOutsideCollaboratorAuditEntryMembershipType.BILLING_MANAGER);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrgRemoveOutsideCollaboratorAuditEntryMembershipType
                orgRemoveOutsideCollaboratorAuditEntryMembershipType =
                        OrgRemoveOutsideCollaboratorAuditEntryMembershipType.fromWire("NOT_A_VALUE");

        assertThat(orgRemoveOutsideCollaboratorAuditEntryMembershipType)
                .isEqualTo(OrgRemoveOutsideCollaboratorAuditEntryMembershipType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> OrgRemoveOutsideCollaboratorAuditEntryMembershipType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
