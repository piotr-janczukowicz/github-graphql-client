package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class FileExtensionRestrictionParametersInputTest {

    @Test
    void constructor_shouldFail_whenRestrictedFileExtensionsIsNull() {
        final FileExtensionRestrictionParametersInputBuilder builder =
                FileExtensionRestrictionParametersInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("restrictedFileExtensions must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final FileExtensionRestrictionParametersInput input = FileExtensionRestrictionParametersInputBuilder.builder()
                .restrictedFileExtensions(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("restrictedFileExtensions", List.of("x")));
    }
}
