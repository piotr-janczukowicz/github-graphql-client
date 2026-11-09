package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class DeploymentReviewStateTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final DeploymentReviewState deploymentReviewState = DeploymentReviewState.fromWire("APPROVED");

        assertThat(deploymentReviewState).isEqualTo(DeploymentReviewState.APPROVED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final DeploymentReviewState deploymentReviewState = DeploymentReviewState.fromWire("NOT_A_VALUE");

        assertThat(deploymentReviewState).isEqualTo(DeploymentReviewState.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> DeploymentReviewState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
