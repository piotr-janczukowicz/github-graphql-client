package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class IssueFieldCreateOrUpdateInputTest {

    @Test
    void constructor_shouldFail_whenFieldIdIsNull() {
        final IssueFieldCreateOrUpdateInputBuilder builder = IssueFieldCreateOrUpdateInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("fieldId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final IssueFieldCreateOrUpdateInput input =
                IssueFieldCreateOrUpdateInputBuilder.builder().fieldId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("fieldId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final IssueFieldCreateOrUpdateInput input = IssueFieldCreateOrUpdateInputBuilder.builder()
                .confidence(IssueEventConfidenceLevel.HIGH)
                .dateValue("x")
                .delete(true)
                .fieldId("x")
                .multiSelectOptionIds(List.of("x"))
                .numberValue(1.5)
                .rationale("x")
                .singleSelectOptionId("x")
                .suggest(true)
                .textValue("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("confidence", "HIGH"),
                        entry("dateValue", "x"),
                        entry("delete", true),
                        entry("fieldId", "x"),
                        entry("multiSelectOptionIds", List.of("x")),
                        entry("numberValue", 1.5),
                        entry("rationale", "x"),
                        entry("singleSelectOptionId", "x"),
                        entry("suggest", true),
                        entry("textValue", "x"));
    }
}
