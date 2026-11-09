package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class MaxFileSizeParametersInputTest {

    @Test
    void constructor_shouldFail_whenMaxFileSizeIsNull() {
        final MaxFileSizeParametersInputBuilder builder = MaxFileSizeParametersInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("maxFileSize must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final MaxFileSizeParametersInput input =
                MaxFileSizeParametersInputBuilder.builder().maxFileSize(1).build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("maxFileSize", 1));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final MaxFileSizeParametersInput input = MaxFileSizeParametersInputBuilder.builder()
                .ignoredFilePaths(List.of("x"))
                .maxFileSize(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("ignoredFilePaths", List.of("x")), entry("maxFileSize", 1));
    }
}
