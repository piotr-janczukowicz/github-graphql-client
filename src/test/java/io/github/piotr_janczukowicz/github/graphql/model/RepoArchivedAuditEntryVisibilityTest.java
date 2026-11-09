package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepoArchivedAuditEntryVisibilityTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepoArchivedAuditEntryVisibility repoArchivedAuditEntryVisibility =
                RepoArchivedAuditEntryVisibility.fromWire("INTERNAL");

        assertThat(repoArchivedAuditEntryVisibility).isEqualTo(RepoArchivedAuditEntryVisibility.INTERNAL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepoArchivedAuditEntryVisibility repoArchivedAuditEntryVisibility =
                RepoArchivedAuditEntryVisibility.fromWire("NOT_A_VALUE");

        assertThat(repoArchivedAuditEntryVisibility).isEqualTo(RepoArchivedAuditEntryVisibility.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepoArchivedAuditEntryVisibility.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
