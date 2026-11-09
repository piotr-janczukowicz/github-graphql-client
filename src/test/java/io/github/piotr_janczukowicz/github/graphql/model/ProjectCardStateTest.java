package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectCardStateTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final ProjectCardState projectCardState = ProjectCardState.fromWire("CONTENT_ONLY");

        assertThat(projectCardState).isEqualTo(ProjectCardState.CONTENT_ONLY);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final ProjectCardState projectCardState = ProjectCardState.fromWire("NOT_A_VALUE");

        assertThat(projectCardState).isEqualTo(ProjectCardState.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> ProjectCardState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
