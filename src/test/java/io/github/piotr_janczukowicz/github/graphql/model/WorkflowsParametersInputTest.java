package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class WorkflowsParametersInputTest {

    @Test
    void constructor_shouldFail_whenWorkflowsIsNull() {
        final WorkflowsParametersInputBuilder builder = WorkflowsParametersInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("workflows must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final WorkflowsParametersInput input = WorkflowsParametersInputBuilder.builder()
                .workflows(List.of(WorkflowFileReferenceInputBuilder.builder()
                        .path("x")
                        .repositoryId(1)
                        .build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("workflows", List.of(Map.ofEntries(entry("path", "x"), entry("repositoryId", 1)))));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final WorkflowsParametersInput input = WorkflowsParametersInputBuilder.builder()
                .doNotEnforceOnCreate(true)
                .workflows(List.of(WorkflowFileReferenceInputBuilder.builder()
                        .path("x")
                        .repositoryId(1)
                        .build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("doNotEnforceOnCreate", true),
                        entry("workflows", List.of(Map.ofEntries(entry("path", "x"), entry("repositoryId", 1)))));
    }
}
