package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class EnterpriseEnabledDisabledSettingValueTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final EnterpriseEnabledDisabledSettingValue enterpriseEnabledDisabledSettingValue =
                EnterpriseEnabledDisabledSettingValue.fromWire("DISABLED");

        assertThat(enterpriseEnabledDisabledSettingValue).isEqualTo(EnterpriseEnabledDisabledSettingValue.DISABLED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final EnterpriseEnabledDisabledSettingValue enterpriseEnabledDisabledSettingValue =
                EnterpriseEnabledDisabledSettingValue.fromWire("NOT_A_VALUE");

        assertThat(enterpriseEnabledDisabledSettingValue).isEqualTo(EnterpriseEnabledDisabledSettingValue.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> EnterpriseEnabledDisabledSettingValue.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = EnterpriseEnabledDisabledSettingValue.DISABLED.wireValue();

        assertThat(value).isEqualTo("DISABLED");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(EnterpriseEnabledDisabledSettingValue.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
