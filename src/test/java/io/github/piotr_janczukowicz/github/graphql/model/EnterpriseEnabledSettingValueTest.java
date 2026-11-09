package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class EnterpriseEnabledSettingValueTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final EnterpriseEnabledSettingValue enterpriseEnabledSettingValue =
                EnterpriseEnabledSettingValue.fromWire("ENABLED");

        assertThat(enterpriseEnabledSettingValue).isEqualTo(EnterpriseEnabledSettingValue.ENABLED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final EnterpriseEnabledSettingValue enterpriseEnabledSettingValue =
                EnterpriseEnabledSettingValue.fromWire("NOT_A_VALUE");

        assertThat(enterpriseEnabledSettingValue).isEqualTo(EnterpriseEnabledSettingValue.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> EnterpriseEnabledSettingValue.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = EnterpriseEnabledSettingValue.ENABLED.wireValue();

        assertThat(value).isEqualTo("ENABLED");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(EnterpriseEnabledSettingValue.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
