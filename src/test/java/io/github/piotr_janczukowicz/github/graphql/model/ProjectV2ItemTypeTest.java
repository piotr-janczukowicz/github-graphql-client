package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectV2ItemTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final ProjectV2ItemType projectV2ItemType = ProjectV2ItemType.fromWire("DRAFT_ISSUE");

        assertThat(projectV2ItemType).isEqualTo(ProjectV2ItemType.DRAFT_ISSUE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final ProjectV2ItemType projectV2ItemType = ProjectV2ItemType.fromWire("NOT_A_VALUE");

        assertThat(projectV2ItemType).isEqualTo(ProjectV2ItemType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> ProjectV2ItemType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
