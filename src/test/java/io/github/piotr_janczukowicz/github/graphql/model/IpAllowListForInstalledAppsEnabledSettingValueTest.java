package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class IpAllowListForInstalledAppsEnabledSettingValueTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final IpAllowListForInstalledAppsEnabledSettingValue ipAllowListForInstalledAppsEnabledSettingValue =
                IpAllowListForInstalledAppsEnabledSettingValue.fromWire("DISABLED");

        assertThat(ipAllowListForInstalledAppsEnabledSettingValue)
                .isEqualTo(IpAllowListForInstalledAppsEnabledSettingValue.DISABLED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final IpAllowListForInstalledAppsEnabledSettingValue ipAllowListForInstalledAppsEnabledSettingValue =
                IpAllowListForInstalledAppsEnabledSettingValue.fromWire("NOT_A_VALUE");

        assertThat(ipAllowListForInstalledAppsEnabledSettingValue)
                .isEqualTo(IpAllowListForInstalledAppsEnabledSettingValue.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> IpAllowListForInstalledAppsEnabledSettingValue.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = IpAllowListForInstalledAppsEnabledSettingValue.DISABLED.wireValue();

        assertThat(value).isEqualTo("DISABLED");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(IpAllowListForInstalledAppsEnabledSettingValue.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
