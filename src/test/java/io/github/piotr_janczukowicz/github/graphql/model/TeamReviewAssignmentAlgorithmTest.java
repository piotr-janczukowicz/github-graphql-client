package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class TeamReviewAssignmentAlgorithmTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final TeamReviewAssignmentAlgorithm teamReviewAssignmentAlgorithm =
                TeamReviewAssignmentAlgorithm.fromWire("LOAD_BALANCE");

        assertThat(teamReviewAssignmentAlgorithm).isEqualTo(TeamReviewAssignmentAlgorithm.LOAD_BALANCE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final TeamReviewAssignmentAlgorithm teamReviewAssignmentAlgorithm =
                TeamReviewAssignmentAlgorithm.fromWire("NOT_A_VALUE");

        assertThat(teamReviewAssignmentAlgorithm).isEqualTo(TeamReviewAssignmentAlgorithm.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> TeamReviewAssignmentAlgorithm.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = TeamReviewAssignmentAlgorithm.LOAD_BALANCE.wireValue();

        assertThat(value).isEqualTo("LOAD_BALANCE");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(TeamReviewAssignmentAlgorithm.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
