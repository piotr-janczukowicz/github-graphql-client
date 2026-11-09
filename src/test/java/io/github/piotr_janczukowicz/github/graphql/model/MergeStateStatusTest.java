package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class MergeStateStatusTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final MergeStateStatus mergeStateStatus = MergeStateStatus.fromWire("BEHIND");

        assertThat(mergeStateStatus).isEqualTo(MergeStateStatus.BEHIND);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final MergeStateStatus mergeStateStatus = MergeStateStatus.fromWire("NOT_A_VALUE");

        assertThat(mergeStateStatus).isEqualTo(MergeStateStatus.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> MergeStateStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
