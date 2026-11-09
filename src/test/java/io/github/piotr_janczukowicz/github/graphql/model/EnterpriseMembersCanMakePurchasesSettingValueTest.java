package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class EnterpriseMembersCanMakePurchasesSettingValueTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final EnterpriseMembersCanMakePurchasesSettingValue enterpriseMembersCanMakePurchasesSettingValue =
                EnterpriseMembersCanMakePurchasesSettingValue.fromWire("DISABLED");

        assertThat(enterpriseMembersCanMakePurchasesSettingValue)
                .isEqualTo(EnterpriseMembersCanMakePurchasesSettingValue.DISABLED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final EnterpriseMembersCanMakePurchasesSettingValue enterpriseMembersCanMakePurchasesSettingValue =
                EnterpriseMembersCanMakePurchasesSettingValue.fromWire("NOT_A_VALUE");

        assertThat(enterpriseMembersCanMakePurchasesSettingValue)
                .isEqualTo(EnterpriseMembersCanMakePurchasesSettingValue.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> EnterpriseMembersCanMakePurchasesSettingValue.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = EnterpriseMembersCanMakePurchasesSettingValue.DISABLED.wireValue();

        assertThat(value).isEqualTo("DISABLED");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(EnterpriseMembersCanMakePurchasesSettingValue.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
