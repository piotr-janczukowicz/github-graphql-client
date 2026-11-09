package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateEnterpriseDefaultRepositoryPermissionSettingPayloadTest {

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final UpdateEnterpriseDefaultRepositoryPermissionSettingPayloadBuilder builder =
                UpdateEnterpriseDefaultRepositoryPermissionSettingPayloadBuilder.builder()
                        .settingValue(EnterpriseDefaultRepositoryPermissionSettingValue.ADMIN);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenSettingValueIsNull() {
        final UpdateEnterpriseDefaultRepositoryPermissionSettingPayloadBuilder builder =
                UpdateEnterpriseDefaultRepositoryPermissionSettingPayloadBuilder.builder()
                        .enterpriseId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("settingValue must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateEnterpriseDefaultRepositoryPermissionSettingPayload input =
                UpdateEnterpriseDefaultRepositoryPermissionSettingPayloadBuilder.builder()
                        .enterpriseId("x")
                        .settingValue(EnterpriseDefaultRepositoryPermissionSettingValue.ADMIN)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("enterpriseId", "x"), entry("settingValue", "ADMIN"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateEnterpriseDefaultRepositoryPermissionSettingPayload input =
                UpdateEnterpriseDefaultRepositoryPermissionSettingPayloadBuilder.builder()
                        .clientMutationId("x")
                        .enterpriseId("x")
                        .settingValue(EnterpriseDefaultRepositoryPermissionSettingValue.ADMIN)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("enterpriseId", "x"), entry("settingValue", "ADMIN"));
    }
}
