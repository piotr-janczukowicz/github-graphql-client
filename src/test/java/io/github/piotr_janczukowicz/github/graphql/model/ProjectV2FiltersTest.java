package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectV2FiltersTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ProjectV2Filters input = ProjectV2FiltersBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ProjectV2Filters input =
                ProjectV2FiltersBuilder.builder().state(ProjectV2State.CLOSED).build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("state", "CLOSED"));
    }
}
