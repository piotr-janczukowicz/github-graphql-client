package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CheckRunOutputImageTest {

    @Test
    void constructor_shouldFail_whenAltIsNull() {
        final CheckRunOutputImageBuilder builder =
                CheckRunOutputImageBuilder.builder().imageUrl("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("alt must not be null");
    }

    @Test
    void constructor_shouldFail_whenImageUrlIsNull() {
        final CheckRunOutputImageBuilder builder =
                CheckRunOutputImageBuilder.builder().alt("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("imageUrl must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CheckRunOutputImage input =
                CheckRunOutputImageBuilder.builder().alt("x").imageUrl("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("alt", "x"), entry("imageUrl", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CheckRunOutputImage input = CheckRunOutputImageBuilder.builder()
                .alt("x")
                .caption("x")
                .imageUrl("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("alt", "x"), entry("caption", "x"), entry("imageUrl", "x"));
    }
}
