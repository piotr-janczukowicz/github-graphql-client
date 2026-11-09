package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateProjectV2FieldPayloadTest {

    private static final String NAME = "name";

    @Test
    void constructor_shouldFail_whenFieldIdIsNull() {
        final UpdateProjectV2FieldPayloadBuilder builder = UpdateProjectV2FieldPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("fieldId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateProjectV2FieldPayload input =
                UpdateProjectV2FieldPayloadBuilder.builder().fieldId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("fieldId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateProjectV2FieldPayload input = UpdateProjectV2FieldPayloadBuilder.builder()
                .clientMutationId("x")
                .fieldId("x")
                .iterationConfiguration(ProjectV2IterationFieldConfigurationInputBuilder.builder()
                        .duration(1)
                        .iterations(List.of(ProjectV2IterationBuilder.builder()
                                .duration(1)
                                .startDate(LocalDate.of(2024, 5, 1))
                                .title("x")
                                .build()))
                        .startDate(LocalDate.of(2024, 5, 1))
                        .build())
                .multiSelectOptions(List.of(ProjectV2MultiSelectFieldOptionInputBuilder.builder()
                        .color(ProjectV2SingleSelectFieldOptionColor.BLUE)
                        .description("x")
                        .name("x")
                        .build()))
                .name("x")
                .singleSelectOptions(List.of(ProjectV2SingleSelectFieldOptionInputBuilder.builder()
                        .color(ProjectV2SingleSelectFieldOptionColor.BLUE)
                        .description("x")
                        .name("x")
                        .build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("fieldId", "x"),
                        entry(
                                "iterationConfiguration",
                                Map.ofEntries(
                                        entry("duration", 1),
                                        entry(
                                                "iterations",
                                                List.of(Map.ofEntries(
                                                        entry("duration", 1),
                                                        entry("startDate", "2024-05-01"),
                                                        entry("title", "x")))),
                                        entry("startDate", "2024-05-01"))),
                        entry(
                                "multiSelectOptions",
                                List.of(Map.ofEntries(
                                        entry("color", "BLUE"), entry("description", "x"), entry(NAME, "x")))),
                        entry(NAME, "x"),
                        entry(
                                "singleSelectOptions",
                                List.of(Map.ofEntries(
                                        entry("color", "BLUE"), entry("description", "x"), entry(NAME, "x")))));
    }
}
