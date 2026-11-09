package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class DiffSideTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final DiffSide diffSide = DiffSide.fromWire("LEFT");

        assertThat(diffSide).isEqualTo(DiffSide.LEFT);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final DiffSide diffSide = DiffSide.fromWire("NOT_A_VALUE");

        assertThat(diffSide).isEqualTo(DiffSide.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> DiffSide.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = DiffSide.LEFT.wireValue();

        assertThat(value).isEqualTo("LEFT");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(DiffSide.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
