package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class EnterpriseAdministratorRoleTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final EnterpriseAdministratorRole enterpriseAdministratorRole =
                EnterpriseAdministratorRole.fromWire("BILLING_MANAGER");

        assertThat(enterpriseAdministratorRole).isEqualTo(EnterpriseAdministratorRole.BILLING_MANAGER);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final EnterpriseAdministratorRole enterpriseAdministratorRole =
                EnterpriseAdministratorRole.fromWire("NOT_A_VALUE");

        assertThat(enterpriseAdministratorRole).isEqualTo(EnterpriseAdministratorRole.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> EnterpriseAdministratorRole.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = EnterpriseAdministratorRole.BILLING_MANAGER.wireValue();

        assertThat(value).isEqualTo("BILLING_MANAGER");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(EnterpriseAdministratorRole.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
