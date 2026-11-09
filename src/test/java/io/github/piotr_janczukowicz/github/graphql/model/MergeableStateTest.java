package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class MergeableStateTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final MergeableState mergeableState = MergeableState.fromWire("CONFLICTING");

        assertThat(mergeableState).isEqualTo(MergeableState.CONFLICTING);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final MergeableState mergeableState = MergeableState.fromWire("NOT_A_VALUE");

        assertThat(mergeableState).isEqualTo(MergeableState.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> MergeableState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
