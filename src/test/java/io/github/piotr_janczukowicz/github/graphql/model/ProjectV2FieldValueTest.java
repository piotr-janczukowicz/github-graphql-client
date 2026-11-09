package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectV2FieldValueTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ProjectV2FieldValue input = ProjectV2FieldValueBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ProjectV2FieldValue input = ProjectV2FieldValueBuilder.builder()
                .date(LocalDate.of(2024, 5, 1))
                .iterationId("x")
                .multiSelectOptionIds(List.of("x"))
                .number(1.5)
                .singleSelectOptionId("x")
                .text("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("date", "2024-05-01"),
                        entry("iterationId", "x"),
                        entry("multiSelectOptionIds", List.of("x")),
                        entry("number", 1.5),
                        entry("singleSelectOptionId", "x"),
                        entry("text", "x"));
    }
}
