package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RuleEnforcementTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RuleEnforcement ruleEnforcement = RuleEnforcement.fromWire("ACTIVE");

        assertThat(ruleEnforcement).isEqualTo(RuleEnforcement.ACTIVE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RuleEnforcement ruleEnforcement = RuleEnforcement.fromWire("NOT_A_VALUE");

        assertThat(ruleEnforcement).isEqualTo(RuleEnforcement.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RuleEnforcement.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = RuleEnforcement.ACTIVE.wireValue();

        assertThat(value).isEqualTo("ACTIVE");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(RuleEnforcement.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
