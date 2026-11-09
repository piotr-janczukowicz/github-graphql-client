package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrgUpdateDefaultRepositoryPermissionAuditEntryPermissionTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrgUpdateDefaultRepositoryPermissionAuditEntryPermission
                orgUpdateDefaultRepositoryPermissionAuditEntryPermission =
                        OrgUpdateDefaultRepositoryPermissionAuditEntryPermission.fromWire("ADMIN");

        assertThat(orgUpdateDefaultRepositoryPermissionAuditEntryPermission)
                .isEqualTo(OrgUpdateDefaultRepositoryPermissionAuditEntryPermission.ADMIN);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrgUpdateDefaultRepositoryPermissionAuditEntryPermission
                orgUpdateDefaultRepositoryPermissionAuditEntryPermission =
                        OrgUpdateDefaultRepositoryPermissionAuditEntryPermission.fromWire("NOT_A_VALUE");

        assertThat(orgUpdateDefaultRepositoryPermissionAuditEntryPermission)
                .isEqualTo(OrgUpdateDefaultRepositoryPermissionAuditEntryPermission.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> OrgUpdateDefaultRepositoryPermissionAuditEntryPermission.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
