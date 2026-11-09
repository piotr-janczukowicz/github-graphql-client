package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class SecurityAdvisoryClassificationTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final SecurityAdvisoryClassification securityAdvisoryClassification =
                SecurityAdvisoryClassification.fromWire("GENERAL");

        assertThat(securityAdvisoryClassification).isEqualTo(SecurityAdvisoryClassification.GENERAL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final SecurityAdvisoryClassification securityAdvisoryClassification =
                SecurityAdvisoryClassification.fromWire("NOT_A_VALUE");

        assertThat(securityAdvisoryClassification).isEqualTo(SecurityAdvisoryClassification.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> SecurityAdvisoryClassification.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
