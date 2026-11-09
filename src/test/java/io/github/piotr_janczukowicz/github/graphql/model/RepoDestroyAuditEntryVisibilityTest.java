package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepoDestroyAuditEntryVisibilityTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepoDestroyAuditEntryVisibility repoDestroyAuditEntryVisibility =
                RepoDestroyAuditEntryVisibility.fromWire("INTERNAL");

        assertThat(repoDestroyAuditEntryVisibility).isEqualTo(RepoDestroyAuditEntryVisibility.INTERNAL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepoDestroyAuditEntryVisibility repoDestroyAuditEntryVisibility =
                RepoDestroyAuditEntryVisibility.fromWire("NOT_A_VALUE");

        assertThat(repoDestroyAuditEntryVisibility).isEqualTo(RepoDestroyAuditEntryVisibility.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepoDestroyAuditEntryVisibility.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
