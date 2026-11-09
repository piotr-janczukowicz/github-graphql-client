package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectV2MultiSelectFieldOptionInputTest {

    @Test
    void constructor_shouldFail_whenColorIsNull() {
        final ProjectV2MultiSelectFieldOptionInputBuilder builder =
                ProjectV2MultiSelectFieldOptionInputBuilder.builder()
                        .description("x")
                        .name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("color must not be null");
    }

    @Test
    void constructor_shouldFail_whenDescriptionIsNull() {
        final ProjectV2MultiSelectFieldOptionInputBuilder builder =
                ProjectV2MultiSelectFieldOptionInputBuilder.builder()
                        .color(ProjectV2SingleSelectFieldOptionColor.BLUE)
                        .name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("description must not be null");
    }

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final ProjectV2MultiSelectFieldOptionInputBuilder builder =
                ProjectV2MultiSelectFieldOptionInputBuilder.builder()
                        .color(ProjectV2SingleSelectFieldOptionColor.BLUE)
                        .description("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ProjectV2MultiSelectFieldOptionInput input = ProjectV2MultiSelectFieldOptionInputBuilder.builder()
                .color(ProjectV2SingleSelectFieldOptionColor.BLUE)
                .description("x")
                .name("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("color", "BLUE"), entry("description", "x"), entry("name", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ProjectV2MultiSelectFieldOptionInput input = ProjectV2MultiSelectFieldOptionInputBuilder.builder()
                .color(ProjectV2SingleSelectFieldOptionColor.BLUE)
                .description("x")
                .id("x")
                .name("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("color", "BLUE"), entry("description", "x"), entry("id", "x"), entry("name", "x"));
    }
}
