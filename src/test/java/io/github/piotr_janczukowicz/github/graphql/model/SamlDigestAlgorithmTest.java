package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class SamlDigestAlgorithmTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final SamlDigestAlgorithm samlDigestAlgorithm = SamlDigestAlgorithm.fromWire("SHA1");

        assertThat(samlDigestAlgorithm).isEqualTo(SamlDigestAlgorithm.SHA1);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final SamlDigestAlgorithm samlDigestAlgorithm = SamlDigestAlgorithm.fromWire("NOT_A_VALUE");

        assertThat(samlDigestAlgorithm).isEqualTo(SamlDigestAlgorithm.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> SamlDigestAlgorithm.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = SamlDigestAlgorithm.SHA1.wireValue();

        assertThat(value).isEqualTo("SHA1");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(SamlDigestAlgorithm.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
