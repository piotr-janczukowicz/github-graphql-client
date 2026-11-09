package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepoCreateAuditEntryVisibilityTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepoCreateAuditEntryVisibility repoCreateAuditEntryVisibility =
                RepoCreateAuditEntryVisibility.fromWire("INTERNAL");

        assertThat(repoCreateAuditEntryVisibility).isEqualTo(RepoCreateAuditEntryVisibility.INTERNAL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepoCreateAuditEntryVisibility repoCreateAuditEntryVisibility =
                RepoCreateAuditEntryVisibility.fromWire("NOT_A_VALUE");

        assertThat(repoCreateAuditEntryVisibility).isEqualTo(RepoCreateAuditEntryVisibility.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepoCreateAuditEntryVisibility.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
