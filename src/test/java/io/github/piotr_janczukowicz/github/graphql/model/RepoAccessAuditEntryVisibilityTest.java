package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepoAccessAuditEntryVisibilityTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepoAccessAuditEntryVisibility repoAccessAuditEntryVisibility =
                RepoAccessAuditEntryVisibility.fromWire("INTERNAL");

        assertThat(repoAccessAuditEntryVisibility).isEqualTo(RepoAccessAuditEntryVisibility.INTERNAL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepoAccessAuditEntryVisibility repoAccessAuditEntryVisibility =
                RepoAccessAuditEntryVisibility.fromWire("NOT_A_VALUE");

        assertThat(repoAccessAuditEntryVisibility).isEqualTo(RepoAccessAuditEntryVisibility.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepoAccessAuditEntryVisibility.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
