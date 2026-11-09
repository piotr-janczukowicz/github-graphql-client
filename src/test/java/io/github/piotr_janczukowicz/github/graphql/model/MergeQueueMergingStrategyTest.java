package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class MergeQueueMergingStrategyTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final MergeQueueMergingStrategy mergeQueueMergingStrategy = MergeQueueMergingStrategy.fromWire("ALLGREEN");

        assertThat(mergeQueueMergingStrategy).isEqualTo(MergeQueueMergingStrategy.ALLGREEN);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final MergeQueueMergingStrategy mergeQueueMergingStrategy = MergeQueueMergingStrategy.fromWire("NOT_A_VALUE");

        assertThat(mergeQueueMergingStrategy).isEqualTo(MergeQueueMergingStrategy.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> MergeQueueMergingStrategy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
