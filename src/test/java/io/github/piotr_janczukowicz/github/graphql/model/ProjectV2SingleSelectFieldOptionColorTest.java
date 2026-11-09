package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectV2SingleSelectFieldOptionColorTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final ProjectV2SingleSelectFieldOptionColor projectV2SingleSelectFieldOptionColor =
                ProjectV2SingleSelectFieldOptionColor.fromWire("BLUE");

        assertThat(projectV2SingleSelectFieldOptionColor).isEqualTo(ProjectV2SingleSelectFieldOptionColor.BLUE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final ProjectV2SingleSelectFieldOptionColor projectV2SingleSelectFieldOptionColor =
                ProjectV2SingleSelectFieldOptionColor.fromWire("NOT_A_VALUE");

        assertThat(projectV2SingleSelectFieldOptionColor).isEqualTo(ProjectV2SingleSelectFieldOptionColor.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> ProjectV2SingleSelectFieldOptionColor.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = ProjectV2SingleSelectFieldOptionColor.BLUE.wireValue();

        assertThat(value).isEqualTo("BLUE");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(ProjectV2SingleSelectFieldOptionColor.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
