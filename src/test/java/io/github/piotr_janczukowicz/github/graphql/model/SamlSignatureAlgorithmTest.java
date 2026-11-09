package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class SamlSignatureAlgorithmTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final SamlSignatureAlgorithm samlSignatureAlgorithm = SamlSignatureAlgorithm.fromWire("RSA_SHA1");

        assertThat(samlSignatureAlgorithm).isEqualTo(SamlSignatureAlgorithm.RSA_SHA1);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final SamlSignatureAlgorithm samlSignatureAlgorithm = SamlSignatureAlgorithm.fromWire("NOT_A_VALUE");

        assertThat(samlSignatureAlgorithm).isEqualTo(SamlSignatureAlgorithm.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> SamlSignatureAlgorithm.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = SamlSignatureAlgorithm.RSA_SHA1.wireValue();

        assertThat(value).isEqualTo("RSA_SHA1");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(SamlSignatureAlgorithm.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
