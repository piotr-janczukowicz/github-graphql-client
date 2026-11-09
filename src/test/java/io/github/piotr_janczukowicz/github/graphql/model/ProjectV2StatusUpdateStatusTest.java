package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectV2StatusUpdateStatusTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final ProjectV2StatusUpdateStatus projectV2StatusUpdateStatus = ProjectV2StatusUpdateStatus.fromWire("AT_RISK");

        assertThat(projectV2StatusUpdateStatus).isEqualTo(ProjectV2StatusUpdateStatus.AT_RISK);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final ProjectV2StatusUpdateStatus projectV2StatusUpdateStatus =
                ProjectV2StatusUpdateStatus.fromWire("NOT_A_VALUE");

        assertThat(projectV2StatusUpdateStatus).isEqualTo(ProjectV2StatusUpdateStatus.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> ProjectV2StatusUpdateStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = ProjectV2StatusUpdateStatus.AT_RISK.wireValue();

        assertThat(value).isEqualTo("AT_RISK");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(ProjectV2StatusUpdateStatus.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
