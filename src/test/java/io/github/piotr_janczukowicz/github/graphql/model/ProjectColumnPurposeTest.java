package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectColumnPurposeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final ProjectColumnPurpose projectColumnPurpose = ProjectColumnPurpose.fromWire("DONE");

        assertThat(projectColumnPurpose).isEqualTo(ProjectColumnPurpose.DONE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final ProjectColumnPurpose projectColumnPurpose = ProjectColumnPurpose.fromWire("NOT_A_VALUE");

        assertThat(projectColumnPurpose).isEqualTo(ProjectColumnPurpose.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> ProjectColumnPurpose.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
