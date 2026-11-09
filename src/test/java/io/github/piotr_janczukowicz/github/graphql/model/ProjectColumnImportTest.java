package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectColumnImportTest {

    @Test
    void constructor_shouldFail_whenColumnNameIsNull() {
        final ProjectColumnImportBuilder builder =
                ProjectColumnImportBuilder.builder().position(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("columnName must not be null");
    }

    @Test
    void constructor_shouldFail_whenPositionIsNull() {
        final ProjectColumnImportBuilder builder =
                ProjectColumnImportBuilder.builder().columnName("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("position must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ProjectColumnImport input =
                ProjectColumnImportBuilder.builder().columnName("x").position(1).build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("columnName", "x"), entry("position", 1));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ProjectColumnImport input = ProjectColumnImportBuilder.builder()
                .columnName("x")
                .issues(List.of(ProjectCardImportBuilder.builder()
                        .number(1)
                        .repository("x")
                        .build()))
                .position(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("columnName", "x"),
                        entry("issues", List.of(Map.ofEntries(entry("number", 1), entry("repository", "x")))),
                        entry("position", 1));
    }
}
