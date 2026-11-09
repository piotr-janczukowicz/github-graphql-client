package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class MergeQueueGroupingStrategyTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final MergeQueueGroupingStrategy mergeQueueGroupingStrategy = MergeQueueGroupingStrategy.fromWire("ALLGREEN");

        assertThat(mergeQueueGroupingStrategy).isEqualTo(MergeQueueGroupingStrategy.ALLGREEN);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final MergeQueueGroupingStrategy mergeQueueGroupingStrategy =
                MergeQueueGroupingStrategy.fromWire("NOT_A_VALUE");

        assertThat(mergeQueueGroupingStrategy).isEqualTo(MergeQueueGroupingStrategy.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> MergeQueueGroupingStrategy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = MergeQueueGroupingStrategy.ALLGREEN.wireValue();

        assertThat(value).isEqualTo("ALLGREEN");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(MergeQueueGroupingStrategy.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
