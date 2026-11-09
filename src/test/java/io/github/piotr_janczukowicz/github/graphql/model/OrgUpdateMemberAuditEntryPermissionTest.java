package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrgUpdateMemberAuditEntryPermissionTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrgUpdateMemberAuditEntryPermission orgUpdateMemberAuditEntryPermission =
                OrgUpdateMemberAuditEntryPermission.fromWire("ADMIN");

        assertThat(orgUpdateMemberAuditEntryPermission).isEqualTo(OrgUpdateMemberAuditEntryPermission.ADMIN);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrgUpdateMemberAuditEntryPermission orgUpdateMemberAuditEntryPermission =
                OrgUpdateMemberAuditEntryPermission.fromWire("NOT_A_VALUE");

        assertThat(orgUpdateMemberAuditEntryPermission).isEqualTo(OrgUpdateMemberAuditEntryPermission.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrgUpdateMemberAuditEntryPermission.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
