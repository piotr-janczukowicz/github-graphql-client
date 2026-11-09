package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ComparisonStatusTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final ComparisonStatus comparisonStatus = ComparisonStatus.fromWire("AHEAD");

        assertThat(comparisonStatus).isEqualTo(ComparisonStatus.AHEAD);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final ComparisonStatus comparisonStatus = ComparisonStatus.fromWire("NOT_A_VALUE");

        assertThat(comparisonStatus).isEqualTo(ComparisonStatus.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> ComparisonStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
