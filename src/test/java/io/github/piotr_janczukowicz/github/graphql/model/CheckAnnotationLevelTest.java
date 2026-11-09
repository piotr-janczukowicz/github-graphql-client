package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class CheckAnnotationLevelTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final CheckAnnotationLevel checkAnnotationLevel = CheckAnnotationLevel.fromWire("FAILURE");

        assertThat(checkAnnotationLevel).isEqualTo(CheckAnnotationLevel.FAILURE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final CheckAnnotationLevel checkAnnotationLevel = CheckAnnotationLevel.fromWire("NOT_A_VALUE");

        assertThat(checkAnnotationLevel).isEqualTo(CheckAnnotationLevel.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> CheckAnnotationLevel.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = CheckAnnotationLevel.FAILURE.wireValue();

        assertThat(value).isEqualTo("FAILURE");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(CheckAnnotationLevel.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
