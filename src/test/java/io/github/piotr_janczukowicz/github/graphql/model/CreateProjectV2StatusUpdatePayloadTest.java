package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.LocalDate;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateProjectV2StatusUpdatePayloadTest {

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final CreateProjectV2StatusUpdatePayloadBuilder builder = CreateProjectV2StatusUpdatePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateProjectV2StatusUpdatePayload input = CreateProjectV2StatusUpdatePayloadBuilder.builder()
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateProjectV2StatusUpdatePayload input = CreateProjectV2StatusUpdatePayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .projectId("x")
                .startDate(LocalDate.of(2024, 5, 1))
                .status(ProjectV2StatusUpdateStatus.AT_RISK)
                .targetDate(LocalDate.of(2024, 5, 1))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("projectId", "x"),
                        entry("startDate", "2024-05-01"),
                        entry("status", "AT_RISK"),
                        entry("targetDate", "2024-05-01"));
    }
}
