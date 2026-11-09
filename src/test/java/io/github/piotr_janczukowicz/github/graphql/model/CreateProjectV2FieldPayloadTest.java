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
class CreateProjectV2FieldPayloadTest {

    private static final String NAME = "name";

    @Test
    void constructor_shouldFail_whenDataTypeIsNull() {
        final CreateProjectV2FieldPayloadBuilder builder =
                CreateProjectV2FieldPayloadBuilder.builder().name("x").projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("dataType must not be null");
    }

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final CreateProjectV2FieldPayloadBuilder builder = CreateProjectV2FieldPayloadBuilder.builder()
                .dataType(ProjectV2CustomFieldType.DATE)
                .projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final CreateProjectV2FieldPayloadBuilder builder = CreateProjectV2FieldPayloadBuilder.builder()
                .dataType(ProjectV2CustomFieldType.DATE)
                .name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateProjectV2FieldPayload input = CreateProjectV2FieldPayloadBuilder.builder()
                .dataType(ProjectV2CustomFieldType.DATE)
                .name("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("dataType", "DATE"), entry(NAME, "x"), entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateProjectV2FieldPayload input = CreateProjectV2FieldPayloadBuilder.builder()
                .clientMutationId("x")
                .dataType(ProjectV2CustomFieldType.DATE)
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
                .projectId("x")
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
                        entry("dataType", "DATE"),
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
                        entry("projectId", "x"),
                        entry(
                                "singleSelectOptions",
                                List.of(Map.ofEntries(
                                        entry("color", "BLUE"), entry("description", "x"), entry(NAME, "x")))));
    }
}
