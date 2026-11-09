package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class IpAllowListEnabledSettingValueTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final IpAllowListEnabledSettingValue ipAllowListEnabledSettingValue =
                IpAllowListEnabledSettingValue.fromWire("DISABLED");

        assertThat(ipAllowListEnabledSettingValue).isEqualTo(IpAllowListEnabledSettingValue.DISABLED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final IpAllowListEnabledSettingValue ipAllowListEnabledSettingValue =
                IpAllowListEnabledSettingValue.fromWire("NOT_A_VALUE");

        assertThat(ipAllowListEnabledSettingValue).isEqualTo(IpAllowListEnabledSettingValue.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> IpAllowListEnabledSettingValue.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = IpAllowListEnabledSettingValue.DISABLED.wireValue();

        assertThat(value).isEqualTo("DISABLED");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(IpAllowListEnabledSettingValue.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
