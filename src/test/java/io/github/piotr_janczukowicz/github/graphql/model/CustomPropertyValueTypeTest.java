package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class CustomPropertyValueTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final CustomPropertyValueType customPropertyValueType = CustomPropertyValueType.fromWire("MULTI_SELECT");

        assertThat(customPropertyValueType).isEqualTo(CustomPropertyValueType.MULTI_SELECT);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final CustomPropertyValueType customPropertyValueType = CustomPropertyValueType.fromWire("NOT_A_VALUE");

        assertThat(customPropertyValueType).isEqualTo(CustomPropertyValueType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> CustomPropertyValueType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = CustomPropertyValueType.MULTI_SELECT.wireValue();

        assertThat(value).isEqualTo("MULTI_SELECT");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(CustomPropertyValueType.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
