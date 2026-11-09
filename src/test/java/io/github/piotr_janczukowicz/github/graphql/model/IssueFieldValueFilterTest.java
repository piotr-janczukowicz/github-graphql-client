package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class IssueFieldValueFilterTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final IssueFieldValueFilter input =
                IssueFieldValueFilterBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final IssueFieldValueFilter input = IssueFieldValueFilterBuilder.builder()
                .dateValue("x")
                .fieldId("x")
                .fieldName("x")
                .multiSelectOptionIds(List.of("x"))
                .multiSelectOptionValues(List.of("x"))
                .numberValue(1.5)
                .singleSelectOptionId("x")
                .singleSelectOptionValue("x")
                .textValue("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("dateValue", "x"),
                        entry("fieldId", "x"),
                        entry("fieldName", "x"),
                        entry("multiSelectOptionIds", List.of("x")),
                        entry("multiSelectOptionValues", List.of("x")),
                        entry("numberValue", 1.5),
                        entry("singleSelectOptionId", "x"),
                        entry("singleSelectOptionValue", "x"),
                        entry("textValue", "x"));
    }
}
