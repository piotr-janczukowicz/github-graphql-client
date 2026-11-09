package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CheckSuiteFilterTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CheckSuiteFilter input = CheckSuiteFilterBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CheckSuiteFilter input =
                CheckSuiteFilterBuilder.builder().appId(1).checkName("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("appId", 1), entry("checkName", "x"));
    }
}
