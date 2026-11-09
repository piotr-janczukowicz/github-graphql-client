package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class EnterpriseDefaultRepositoryPermissionSettingValueTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final EnterpriseDefaultRepositoryPermissionSettingValue enterpriseDefaultRepositoryPermissionSettingValue =
                EnterpriseDefaultRepositoryPermissionSettingValue.fromWire("ADMIN");

        assertThat(enterpriseDefaultRepositoryPermissionSettingValue)
                .isEqualTo(EnterpriseDefaultRepositoryPermissionSettingValue.ADMIN);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final EnterpriseDefaultRepositoryPermissionSettingValue enterpriseDefaultRepositoryPermissionSettingValue =
                EnterpriseDefaultRepositoryPermissionSettingValue.fromWire("NOT_A_VALUE");

        assertThat(enterpriseDefaultRepositoryPermissionSettingValue)
                .isEqualTo(EnterpriseDefaultRepositoryPermissionSettingValue.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> EnterpriseDefaultRepositoryPermissionSettingValue.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = EnterpriseDefaultRepositoryPermissionSettingValue.ADMIN.wireValue();

        assertThat(value).isEqualTo("ADMIN");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown =
                catchThrowable(EnterpriseDefaultRepositoryPermissionSettingValue.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
