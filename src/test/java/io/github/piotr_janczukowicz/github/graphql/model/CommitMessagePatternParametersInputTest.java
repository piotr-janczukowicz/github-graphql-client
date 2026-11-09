package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CommitMessagePatternParametersInputTest {

    @Test
    void constructor_shouldFail_whenOperatorIsNull() {
        final CommitMessagePatternParametersInputBuilder builder =
                CommitMessagePatternParametersInputBuilder.builder().pattern("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("operator must not be null");
    }

    @Test
    void constructor_shouldFail_whenPatternIsNull() {
        final CommitMessagePatternParametersInputBuilder builder =
                CommitMessagePatternParametersInputBuilder.builder().operator("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pattern must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CommitMessagePatternParametersInput input = CommitMessagePatternParametersInputBuilder.builder()
                .operator("x")
                .pattern("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("operator", "x"), entry("pattern", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CommitMessagePatternParametersInput input = CommitMessagePatternParametersInputBuilder.builder()
                .name("x")
                .negate(true)
                .operator("x")
                .pattern("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("name", "x"), entry("negate", true), entry("operator", "x"), entry("pattern", "x"));
    }
}
