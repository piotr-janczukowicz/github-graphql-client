package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectV2ViewLayoutTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final ProjectV2ViewLayout projectV2ViewLayout = ProjectV2ViewLayout.fromWire("BOARD_LAYOUT");

        assertThat(projectV2ViewLayout).isEqualTo(ProjectV2ViewLayout.BOARD_LAYOUT);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final ProjectV2ViewLayout projectV2ViewLayout = ProjectV2ViewLayout.fromWire("NOT_A_VALUE");

        assertThat(projectV2ViewLayout).isEqualTo(ProjectV2ViewLayout.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> ProjectV2ViewLayout.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = ProjectV2ViewLayout.BOARD_LAYOUT.wireValue();

        assertThat(value).isEqualTo("BOARD_LAYOUT");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(ProjectV2ViewLayout.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
