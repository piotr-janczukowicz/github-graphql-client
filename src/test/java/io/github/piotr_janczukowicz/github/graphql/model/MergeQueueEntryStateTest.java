package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class MergeQueueEntryStateTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final MergeQueueEntryState mergeQueueEntryState = MergeQueueEntryState.fromWire("AWAITING_CHECKS");

        assertThat(mergeQueueEntryState).isEqualTo(MergeQueueEntryState.AWAITING_CHECKS);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final MergeQueueEntryState mergeQueueEntryState = MergeQueueEntryState.fromWire("NOT_A_VALUE");

        assertThat(mergeQueueEntryState).isEqualTo(MergeQueueEntryState.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> MergeQueueEntryState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
