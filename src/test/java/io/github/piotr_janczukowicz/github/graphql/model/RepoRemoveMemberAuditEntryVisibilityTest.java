package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepoRemoveMemberAuditEntryVisibilityTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepoRemoveMemberAuditEntryVisibility repoRemoveMemberAuditEntryVisibility =
                RepoRemoveMemberAuditEntryVisibility.fromWire("INTERNAL");

        assertThat(repoRemoveMemberAuditEntryVisibility).isEqualTo(RepoRemoveMemberAuditEntryVisibility.INTERNAL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepoRemoveMemberAuditEntryVisibility repoRemoveMemberAuditEntryVisibility =
                RepoRemoveMemberAuditEntryVisibility.fromWire("NOT_A_VALUE");

        assertThat(repoRemoveMemberAuditEntryVisibility).isEqualTo(RepoRemoveMemberAuditEntryVisibility.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepoRemoveMemberAuditEntryVisibility.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
