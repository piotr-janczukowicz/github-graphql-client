package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class EnterpriseAllowPrivateRepositoryForkingPolicyValueTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final EnterpriseAllowPrivateRepositoryForkingPolicyValue enterpriseAllowPrivateRepositoryForkingPolicyValue =
                EnterpriseAllowPrivateRepositoryForkingPolicyValue.fromWire("ENTERPRISE_ORGANIZATIONS");

        assertThat(enterpriseAllowPrivateRepositoryForkingPolicyValue)
                .isEqualTo(EnterpriseAllowPrivateRepositoryForkingPolicyValue.ENTERPRISE_ORGANIZATIONS);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final EnterpriseAllowPrivateRepositoryForkingPolicyValue enterpriseAllowPrivateRepositoryForkingPolicyValue =
                EnterpriseAllowPrivateRepositoryForkingPolicyValue.fromWire("NOT_A_VALUE");

        assertThat(enterpriseAllowPrivateRepositoryForkingPolicyValue)
                .isEqualTo(EnterpriseAllowPrivateRepositoryForkingPolicyValue.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> EnterpriseAllowPrivateRepositoryForkingPolicyValue.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = EnterpriseAllowPrivateRepositoryForkingPolicyValue.ENTERPRISE_ORGANIZATIONS.wireValue();

        assertThat(value).isEqualTo("ENTERPRISE_ORGANIZATIONS");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown =
                catchThrowable(EnterpriseAllowPrivateRepositoryForkingPolicyValue.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
