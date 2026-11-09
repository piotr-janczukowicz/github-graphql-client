package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class WorkflowFileReferenceInputTest {

    @Test
    void constructor_shouldFail_whenPathIsNull() {
        final WorkflowFileReferenceInputBuilder builder =
                WorkflowFileReferenceInputBuilder.builder().repositoryId(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("path must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final WorkflowFileReferenceInputBuilder builder =
                WorkflowFileReferenceInputBuilder.builder().path("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final WorkflowFileReferenceInput input = WorkflowFileReferenceInputBuilder.builder()
                .path("x")
                .repositoryId(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("path", "x"), entry("repositoryId", 1));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final WorkflowFileReferenceInput input = WorkflowFileReferenceInputBuilder.builder()
                .path("x")
                .ref("x")
                .repositoryId(1)
                .sha("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("path", "x"), entry("ref", "x"), entry("repositoryId", 1), entry("sha", "x"));
    }
}
