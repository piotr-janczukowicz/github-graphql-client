package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class MergeQueueMergeMethodTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final MergeQueueMergeMethod mergeQueueMergeMethod = MergeQueueMergeMethod.fromWire("MERGE");

        assertThat(mergeQueueMergeMethod).isEqualTo(MergeQueueMergeMethod.MERGE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final MergeQueueMergeMethod mergeQueueMergeMethod = MergeQueueMergeMethod.fromWire("NOT_A_VALUE");

        assertThat(mergeQueueMergeMethod).isEqualTo(MergeQueueMergeMethod.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> MergeQueueMergeMethod.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = MergeQueueMergeMethod.MERGE.wireValue();

        assertThat(value).isEqualTo("MERGE");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(MergeQueueMergeMethod.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
