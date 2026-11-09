package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CodeQualityParametersInputTest {

    @Test
    void constructor_shouldFail_whenSeverityIsNull() {
        final CodeQualityParametersInputBuilder builder = CodeQualityParametersInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("severity must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CodeQualityParametersInput input = CodeQualityParametersInputBuilder.builder()
                .severity(CodeQualitySeverity.ALL)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("severity", "ALL"));
    }
}
