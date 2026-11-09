package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RequiredStatusChecksParametersInputTest {

    @Test
    void constructor_shouldFail_whenRequiredStatusChecksIsNull() {
        final RequiredStatusChecksParametersInputBuilder builder =
                RequiredStatusChecksParametersInputBuilder.builder().strictRequiredStatusChecksPolicy(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("requiredStatusChecks must not be null");
    }

    @Test
    void constructor_shouldFail_whenStrictRequiredStatusChecksPolicyIsNull() {
        final RequiredStatusChecksParametersInputBuilder builder = RequiredStatusChecksParametersInputBuilder.builder()
                .requiredStatusChecks(List.of(StatusCheckConfigurationInputBuilder.builder()
                        .context("x")
                        .build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("strictRequiredStatusChecksPolicy must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RequiredStatusChecksParametersInput input = RequiredStatusChecksParametersInputBuilder.builder()
                .requiredStatusChecks(List.of(StatusCheckConfigurationInputBuilder.builder()
                        .context("x")
                        .build()))
                .strictRequiredStatusChecksPolicy(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("requiredStatusChecks", List.of(Map.ofEntries(entry("context", "x")))),
                        entry("strictRequiredStatusChecksPolicy", true));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RequiredStatusChecksParametersInput input = RequiredStatusChecksParametersInputBuilder.builder()
                .doNotEnforceOnCreate(true)
                .requiredStatusChecks(List.of(StatusCheckConfigurationInputBuilder.builder()
                        .context("x")
                        .build()))
                .strictRequiredStatusChecksPolicy(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("doNotEnforceOnCreate", true),
                        entry("requiredStatusChecks", List.of(Map.ofEntries(entry("context", "x")))),
                        entry("strictRequiredStatusChecksPolicy", true));
    }
}
