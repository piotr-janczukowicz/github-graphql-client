package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class SponsorsActivityActionTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final SponsorsActivityAction sponsorsActivityAction = SponsorsActivityAction.fromWire("CANCELLED_SPONSORSHIP");

        assertThat(sponsorsActivityAction).isEqualTo(SponsorsActivityAction.CANCELLED_SPONSORSHIP);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final SponsorsActivityAction sponsorsActivityAction = SponsorsActivityAction.fromWire("NOT_A_VALUE");

        assertThat(sponsorsActivityAction).isEqualTo(SponsorsActivityAction.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> SponsorsActivityAction.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
