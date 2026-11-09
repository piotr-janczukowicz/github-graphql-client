package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class CodeQualitySeverityTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final CodeQualitySeverity codeQualitySeverity = CodeQualitySeverity.fromWire("ALL");

        assertThat(codeQualitySeverity).isEqualTo(CodeQualitySeverity.ALL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final CodeQualitySeverity codeQualitySeverity = CodeQualitySeverity.fromWire("NOT_A_VALUE");

        assertThat(codeQualitySeverity).isEqualTo(CodeQualitySeverity.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> CodeQualitySeverity.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = CodeQualitySeverity.ALL.wireValue();

        assertThat(value).isEqualTo("ALL");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(CodeQualitySeverity.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
