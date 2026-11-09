package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class SecurityAdvisorySeverityTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final SecurityAdvisorySeverity securityAdvisorySeverity = SecurityAdvisorySeverity.fromWire("CRITICAL");

        assertThat(securityAdvisorySeverity).isEqualTo(SecurityAdvisorySeverity.CRITICAL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final SecurityAdvisorySeverity securityAdvisorySeverity = SecurityAdvisorySeverity.fromWire("NOT_A_VALUE");

        assertThat(securityAdvisorySeverity).isEqualTo(SecurityAdvisorySeverity.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> SecurityAdvisorySeverity.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
