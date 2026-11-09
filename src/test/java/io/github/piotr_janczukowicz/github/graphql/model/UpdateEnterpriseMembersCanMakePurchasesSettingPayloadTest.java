package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateEnterpriseMembersCanMakePurchasesSettingPayloadTest {

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final UpdateEnterpriseMembersCanMakePurchasesSettingPayloadBuilder builder =
                UpdateEnterpriseMembersCanMakePurchasesSettingPayloadBuilder.builder()
                        .settingValue(EnterpriseMembersCanMakePurchasesSettingValue.DISABLED);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenSettingValueIsNull() {
        final UpdateEnterpriseMembersCanMakePurchasesSettingPayloadBuilder builder =
                UpdateEnterpriseMembersCanMakePurchasesSettingPayloadBuilder.builder()
                        .enterpriseId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("settingValue must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateEnterpriseMembersCanMakePurchasesSettingPayload input =
                UpdateEnterpriseMembersCanMakePurchasesSettingPayloadBuilder.builder()
                        .enterpriseId("x")
                        .settingValue(EnterpriseMembersCanMakePurchasesSettingValue.DISABLED)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("enterpriseId", "x"), entry("settingValue", "DISABLED"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateEnterpriseMembersCanMakePurchasesSettingPayload input =
                UpdateEnterpriseMembersCanMakePurchasesSettingPayloadBuilder.builder()
                        .clientMutationId("x")
                        .enterpriseId("x")
                        .settingValue(EnterpriseMembersCanMakePurchasesSettingValue.DISABLED)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("enterpriseId", "x"), entry("settingValue", "DISABLED"));
    }
}
