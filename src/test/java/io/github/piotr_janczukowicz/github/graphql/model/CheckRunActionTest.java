package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CheckRunActionTest {

    @Test
    void constructor_shouldFail_whenDescriptionIsNull() {
        final CheckRunActionBuilder builder =
                CheckRunActionBuilder.builder().identifier("x").label("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("description must not be null");
    }

    @Test
    void constructor_shouldFail_whenIdentifierIsNull() {
        final CheckRunActionBuilder builder =
                CheckRunActionBuilder.builder().description("x").label("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("identifier must not be null");
    }

    @Test
    void constructor_shouldFail_whenLabelIsNull() {
        final CheckRunActionBuilder builder =
                CheckRunActionBuilder.builder().description("x").identifier("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("label must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CheckRunAction input = CheckRunActionBuilder.builder()
                .description("x")
                .identifier("x")
                .label("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("description", "x"), entry("identifier", "x"), entry("label", "x"));
    }
}
