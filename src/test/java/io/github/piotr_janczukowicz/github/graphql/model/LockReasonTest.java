package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class LockReasonTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final LockReason lockReason = LockReason.fromWire("OFF_TOPIC");

        assertThat(lockReason).isEqualTo(LockReason.OFF_TOPIC);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final LockReason lockReason = LockReason.fromWire("NOT_A_VALUE");

        assertThat(lockReason).isEqualTo(LockReason.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> LockReason.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = LockReason.OFF_TOPIC.wireValue();

        assertThat(value).isEqualTo("OFF_TOPIC");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(LockReason.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
