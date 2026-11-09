package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectV2FieldTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final ProjectV2FieldType projectV2FieldType = ProjectV2FieldType.fromWire("ASSIGNEES");

        assertThat(projectV2FieldType).isEqualTo(ProjectV2FieldType.ASSIGNEES);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final ProjectV2FieldType projectV2FieldType = ProjectV2FieldType.fromWire("NOT_A_VALUE");

        assertThat(projectV2FieldType).isEqualTo(ProjectV2FieldType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> ProjectV2FieldType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
