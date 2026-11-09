package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepositoryLockReasonTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepositoryLockReason repositoryLockReason = RepositoryLockReason.fromWire("BILLING");

        assertThat(repositoryLockReason).isEqualTo(RepositoryLockReason.BILLING);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepositoryLockReason repositoryLockReason = RepositoryLockReason.fromWire("NOT_A_VALUE");

        assertThat(repositoryLockReason).isEqualTo(RepositoryLockReason.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepositoryLockReason.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
