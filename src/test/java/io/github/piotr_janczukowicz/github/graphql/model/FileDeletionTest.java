package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class FileDeletionTest {

    @Test
    void constructor_shouldFail_whenPathIsNull() {
        final FileDeletionBuilder builder = FileDeletionBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("path must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final FileDeletion input = FileDeletionBuilder.builder().path("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("path", "x"));
    }
}
