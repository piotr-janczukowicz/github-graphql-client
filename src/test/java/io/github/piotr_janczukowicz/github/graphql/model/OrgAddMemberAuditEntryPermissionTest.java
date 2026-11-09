package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrgAddMemberAuditEntryPermissionTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrgAddMemberAuditEntryPermission orgAddMemberAuditEntryPermission =
                OrgAddMemberAuditEntryPermission.fromWire("ADMIN");

        assertThat(orgAddMemberAuditEntryPermission).isEqualTo(OrgAddMemberAuditEntryPermission.ADMIN);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrgAddMemberAuditEntryPermission orgAddMemberAuditEntryPermission =
                OrgAddMemberAuditEntryPermission.fromWire("NOT_A_VALUE");

        assertThat(orgAddMemberAuditEntryPermission).isEqualTo(OrgAddMemberAuditEntryPermission.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrgAddMemberAuditEntryPermission.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
