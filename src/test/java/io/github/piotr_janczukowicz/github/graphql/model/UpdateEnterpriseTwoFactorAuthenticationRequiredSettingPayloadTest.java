package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadTest {

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadBuilder builder =
                UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadBuilder.builder()
                        .settingValue(EnterpriseEnabledSettingValue.ENABLED);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenSettingValueIsNull() {
        final UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadBuilder builder =
                UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadBuilder.builder()
                        .enterpriseId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("settingValue must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayload input =
                UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadBuilder.builder()
                        .enterpriseId("x")
                        .settingValue(EnterpriseEnabledSettingValue.ENABLED)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("enterpriseId", "x"), entry("settingValue", "ENABLED"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayload input =
                UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadBuilder.builder()
                        .clientMutationId("x")
                        .enterpriseId("x")
                        .settingValue(EnterpriseEnabledSettingValue.ENABLED)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("enterpriseId", "x"), entry("settingValue", "ENABLED"));
    }
}
