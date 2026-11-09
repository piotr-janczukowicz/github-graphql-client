package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CodeCoverageParametersInputTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CodeCoverageParametersInput input =
                CodeCoverageParametersInputBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CodeCoverageParametersInput input = CodeCoverageParametersInputBuilder.builder()
                .maxCoverageDrop(1.5)
                .minimumCoverage(1.5)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("maxCoverageDrop", 1.5), entry("minimumCoverage", 1.5));
    }
}
