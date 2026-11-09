package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibilityTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility
                orgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility =
                        OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility.fromWire("ALL");

        assertThat(orgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility)
                .isEqualTo(OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility.ALL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility
                orgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility =
                        OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility.fromWire("NOT_A_VALUE");

        assertThat(orgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility)
                .isEqualTo(OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
