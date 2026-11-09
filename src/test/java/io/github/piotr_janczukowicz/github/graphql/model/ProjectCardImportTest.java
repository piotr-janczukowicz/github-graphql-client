package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectCardImportTest {

    @Test
    void constructor_shouldFail_whenNumberIsNull() {
        final ProjectCardImportBuilder builder =
                ProjectCardImportBuilder.builder().repository("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("number must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIsNull() {
        final ProjectCardImportBuilder builder =
                ProjectCardImportBuilder.builder().number(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repository must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ProjectCardImport input =
                ProjectCardImportBuilder.builder().number(1).repository("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("number", 1), entry("repository", "x"));
    }
}
