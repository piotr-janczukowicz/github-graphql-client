package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateIpAllowListUserLevelEnforcementEnabledSettingPayloadTest {

    @Test
    void constructor_shouldFail_whenOwnerIdIsNull() {
        final UpdateIpAllowListUserLevelEnforcementEnabledSettingPayloadBuilder builder =
                UpdateIpAllowListUserLevelEnforcementEnabledSettingPayloadBuilder.builder()
                        .settingValue(IpAllowListUserLevelEnforcementEnabledSettingValue.DISABLED);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerId must not be null");
    }

    @Test
    void constructor_shouldFail_whenSettingValueIsNull() {
        final UpdateIpAllowListUserLevelEnforcementEnabledSettingPayloadBuilder builder =
                UpdateIpAllowListUserLevelEnforcementEnabledSettingPayloadBuilder.builder()
                        .ownerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("settingValue must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateIpAllowListUserLevelEnforcementEnabledSettingPayload input =
                UpdateIpAllowListUserLevelEnforcementEnabledSettingPayloadBuilder.builder()
                        .ownerId("x")
                        .settingValue(IpAllowListUserLevelEnforcementEnabledSettingValue.DISABLED)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("ownerId", "x"), entry("settingValue", "DISABLED"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateIpAllowListUserLevelEnforcementEnabledSettingPayload input =
                UpdateIpAllowListUserLevelEnforcementEnabledSettingPayloadBuilder.builder()
                        .clientMutationId("x")
                        .ownerId("x")
                        .settingValue(IpAllowListUserLevelEnforcementEnabledSettingValue.DISABLED)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("ownerId", "x"), entry("settingValue", "DISABLED"));
    }
}
