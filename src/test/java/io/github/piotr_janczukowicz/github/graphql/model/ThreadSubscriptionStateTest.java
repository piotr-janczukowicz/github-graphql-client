package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ThreadSubscriptionStateTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final ThreadSubscriptionState threadSubscriptionState = ThreadSubscriptionState.fromWire("DISABLED");

        assertThat(threadSubscriptionState).isEqualTo(ThreadSubscriptionState.DISABLED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final ThreadSubscriptionState threadSubscriptionState = ThreadSubscriptionState.fromWire("NOT_A_VALUE");

        assertThat(threadSubscriptionState).isEqualTo(ThreadSubscriptionState.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> ThreadSubscriptionState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
