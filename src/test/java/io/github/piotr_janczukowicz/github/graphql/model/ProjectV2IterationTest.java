package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.LocalDate;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectV2IterationTest {

    @Test
    void constructor_shouldFail_whenDurationIsNull() {
        final ProjectV2IterationBuilder builder = ProjectV2IterationBuilder.builder()
                .startDate(LocalDate.of(2024, 5, 1))
                .title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("duration must not be null");
    }

    @Test
    void constructor_shouldFail_whenStartDateIsNull() {
        final ProjectV2IterationBuilder builder =
                ProjectV2IterationBuilder.builder().duration(1).title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("startDate must not be null");
    }

    @Test
    void constructor_shouldFail_whenTitleIsNull() {
        final ProjectV2IterationBuilder builder =
                ProjectV2IterationBuilder.builder().duration(1).startDate(LocalDate.of(2024, 5, 1));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("title must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ProjectV2Iteration input = ProjectV2IterationBuilder.builder()
                .duration(1)
                .startDate(LocalDate.of(2024, 5, 1))
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("duration", 1), entry("startDate", "2024-05-01"), entry("title", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ProjectV2Iteration input = ProjectV2IterationBuilder.builder()
                .duration(1)
                .id("x")
                .startDate(LocalDate.of(2024, 5, 1))
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("duration", 1), entry("id", "x"), entry("startDate", "2024-05-01"), entry("title", "x"));
    }
}
