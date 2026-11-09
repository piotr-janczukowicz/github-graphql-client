package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class FileAdditionTest {

    @Test
    void constructor_shouldFail_whenContentsIsNull() {
        final FileAdditionBuilder builder = FileAdditionBuilder.builder().path("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("contents must not be null");
    }

    @Test
    void constructor_shouldFail_whenPathIsNull() {
        final FileAdditionBuilder builder = FileAdditionBuilder.builder().contents("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("path must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final FileAddition input =
                FileAdditionBuilder.builder().contents("x").path("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("contents", "x"), entry("path", "x"));
    }
}
