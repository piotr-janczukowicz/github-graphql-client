package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class UserBlockDurationTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final UserBlockDuration userBlockDuration = UserBlockDuration.fromWire("ONE_DAY");

        assertThat(userBlockDuration).isEqualTo(UserBlockDuration.ONE_DAY);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final UserBlockDuration userBlockDuration = UserBlockDuration.fromWire("NOT_A_VALUE");

        assertThat(userBlockDuration).isEqualTo(UserBlockDuration.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> UserBlockDuration.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
