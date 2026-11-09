package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class IpAllowListUserLevelEnforcementEnabledSettingValueTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final IpAllowListUserLevelEnforcementEnabledSettingValue ipAllowListUserLevelEnforcementEnabledSettingValue =
                IpAllowListUserLevelEnforcementEnabledSettingValue.fromWire("DISABLED");

        assertThat(ipAllowListUserLevelEnforcementEnabledSettingValue)
                .isEqualTo(IpAllowListUserLevelEnforcementEnabledSettingValue.DISABLED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final IpAllowListUserLevelEnforcementEnabledSettingValue ipAllowListUserLevelEnforcementEnabledSettingValue =
                IpAllowListUserLevelEnforcementEnabledSettingValue.fromWire("NOT_A_VALUE");

        assertThat(ipAllowListUserLevelEnforcementEnabledSettingValue)
                .isEqualTo(IpAllowListUserLevelEnforcementEnabledSettingValue.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> IpAllowListUserLevelEnforcementEnabledSettingValue.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = IpAllowListUserLevelEnforcementEnabledSettingValue.DISABLED.wireValue();

        assertThat(value).isEqualTo("DISABLED");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown =
                catchThrowable(IpAllowListUserLevelEnforcementEnabledSettingValue.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
