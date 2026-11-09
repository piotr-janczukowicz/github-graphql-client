package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class DeploymentProtectionRuleTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final DeploymentProtectionRuleType deploymentProtectionRuleType =
                DeploymentProtectionRuleType.fromWire("BRANCH_POLICY");

        assertThat(deploymentProtectionRuleType).isEqualTo(DeploymentProtectionRuleType.BRANCH_POLICY);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final DeploymentProtectionRuleType deploymentProtectionRuleType =
                DeploymentProtectionRuleType.fromWire("NOT_A_VALUE");

        assertThat(deploymentProtectionRuleType).isEqualTo(DeploymentProtectionRuleType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> DeploymentProtectionRuleType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
