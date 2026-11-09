package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrgRemoveMemberAuditEntryMembershipTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrgRemoveMemberAuditEntryMembershipType orgRemoveMemberAuditEntryMembershipType =
                OrgRemoveMemberAuditEntryMembershipType.fromWire("ADMIN");

        assertThat(orgRemoveMemberAuditEntryMembershipType).isEqualTo(OrgRemoveMemberAuditEntryMembershipType.ADMIN);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrgRemoveMemberAuditEntryMembershipType orgRemoveMemberAuditEntryMembershipType =
                OrgRemoveMemberAuditEntryMembershipType.fromWire("NOT_A_VALUE");

        assertThat(orgRemoveMemberAuditEntryMembershipType)
                .isEqualTo(OrgRemoveMemberAuditEntryMembershipType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrgRemoveMemberAuditEntryMembershipType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
