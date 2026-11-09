package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class SponsorsGoalKindTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final SponsorsGoalKind sponsorsGoalKind = SponsorsGoalKind.fromWire("MONTHLY_SPONSORSHIP_AMOUNT");

        assertThat(sponsorsGoalKind).isEqualTo(SponsorsGoalKind.MONTHLY_SPONSORSHIP_AMOUNT);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final SponsorsGoalKind sponsorsGoalKind = SponsorsGoalKind.fromWire("NOT_A_VALUE");

        assertThat(sponsorsGoalKind).isEqualTo(SponsorsGoalKind.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> SponsorsGoalKind.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
