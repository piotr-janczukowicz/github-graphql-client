package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class IssueFieldUpdateInputTest {

    @Test
    void constructor_shouldFail_whenFieldNameIsNull() {
        final IssueFieldUpdateInputBuilder builder =
                IssueFieldUpdateInputBuilder.builder().operation(IssueFieldUpdateOperation.ADD);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("fieldName must not be null");
    }

    @Test
    void constructor_shouldFail_whenOperationIsNull() {
        final IssueFieldUpdateInputBuilder builder =
                IssueFieldUpdateInputBuilder.builder().fieldName("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("operation must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final IssueFieldUpdateInput input = IssueFieldUpdateInputBuilder.builder()
                .fieldName("x")
                .operation(IssueFieldUpdateOperation.ADD)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("fieldName", "x"), entry("operation", "ADD"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final IssueFieldUpdateInput input = IssueFieldUpdateInputBuilder.builder()
                .fieldName("x")
                .operation(IssueFieldUpdateOperation.ADD)
                .value("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("fieldName", "x"), entry("operation", "ADD"), entry("value", "x"));
    }
}
