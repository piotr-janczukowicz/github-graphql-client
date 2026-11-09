package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ThreadSubscriptionFormActionTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final ThreadSubscriptionFormAction threadSubscriptionFormAction = ThreadSubscriptionFormAction.fromWire("NONE");

        assertThat(threadSubscriptionFormAction).isEqualTo(ThreadSubscriptionFormAction.NONE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final ThreadSubscriptionFormAction threadSubscriptionFormAction =
                ThreadSubscriptionFormAction.fromWire("NOT_A_VALUE");

        assertThat(threadSubscriptionFormAction).isEqualTo(ThreadSubscriptionFormAction.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> ThreadSubscriptionFormAction.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
