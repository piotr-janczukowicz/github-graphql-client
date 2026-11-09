package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectV2IterationFieldConfigurationInputTest {

    @Test
    void constructor_shouldFail_whenDurationIsNull() {
        final ProjectV2IterationFieldConfigurationInputBuilder builder =
                ProjectV2IterationFieldConfigurationInputBuilder.builder()
                        .iterations(List.of(ProjectV2IterationBuilder.builder()
                                .duration(1)
                                .startDate(LocalDate.of(2024, 5, 1))
                                .title("x")
                                .build()))
                        .startDate(LocalDate.of(2024, 5, 1));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("duration must not be null");
    }

    @Test
    void constructor_shouldFail_whenIterationsIsNull() {
        final ProjectV2IterationFieldConfigurationInputBuilder builder =
                ProjectV2IterationFieldConfigurationInputBuilder.builder()
                        .duration(1)
                        .startDate(LocalDate.of(2024, 5, 1));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("iterations must not be null");
    }

    @Test
    void constructor_shouldFail_whenStartDateIsNull() {
        final ProjectV2IterationFieldConfigurationInputBuilder builder =
                ProjectV2IterationFieldConfigurationInputBuilder.builder()
                        .duration(1)
                        .iterations(List.of(ProjectV2IterationBuilder.builder()
                                .duration(1)
                                .startDate(LocalDate.of(2024, 5, 1))
                                .title("x")
                                .build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("startDate must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ProjectV2IterationFieldConfigurationInput input =
                ProjectV2IterationFieldConfigurationInputBuilder.builder()
                        .duration(1)
                        .iterations(List.of(ProjectV2IterationBuilder.builder()
                                .duration(1)
                                .startDate(LocalDate.of(2024, 5, 1))
                                .title("x")
                                .build()))
                        .startDate(LocalDate.of(2024, 5, 1))
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("duration", 1),
                        entry(
                                "iterations",
                                List.of(Map.ofEntries(
                                        entry("duration", 1), entry("startDate", "2024-05-01"), entry("title", "x")))),
                        entry("startDate", "2024-05-01"));
    }
}
