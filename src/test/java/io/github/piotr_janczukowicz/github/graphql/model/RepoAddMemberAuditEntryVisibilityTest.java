package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepoAddMemberAuditEntryVisibilityTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepoAddMemberAuditEntryVisibility repoAddMemberAuditEntryVisibility =
                RepoAddMemberAuditEntryVisibility.fromWire("INTERNAL");

        assertThat(repoAddMemberAuditEntryVisibility).isEqualTo(RepoAddMemberAuditEntryVisibility.INTERNAL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepoAddMemberAuditEntryVisibility repoAddMemberAuditEntryVisibility =
                RepoAddMemberAuditEntryVisibility.fromWire("NOT_A_VALUE");

        assertThat(repoAddMemberAuditEntryVisibility).isEqualTo(RepoAddMemberAuditEntryVisibility.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepoAddMemberAuditEntryVisibility.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
