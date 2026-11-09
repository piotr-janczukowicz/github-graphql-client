package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.LocalDate;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateProjectV2StatusUpdatePayloadTest {

    @Test
    void constructor_shouldFail_whenStatusUpdateIdIsNull() {
        final UpdateProjectV2StatusUpdatePayloadBuilder builder = UpdateProjectV2StatusUpdatePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("statusUpdateId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateProjectV2StatusUpdatePayload input = UpdateProjectV2StatusUpdatePayloadBuilder.builder()
                .statusUpdateId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("statusUpdateId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateProjectV2StatusUpdatePayload input = UpdateProjectV2StatusUpdatePayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .startDate(LocalDate.of(2024, 5, 1))
                .status(ProjectV2StatusUpdateStatus.AT_RISK)
                .statusUpdateId("x")
                .targetDate(LocalDate.of(2024, 5, 1))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("startDate", "2024-05-01"),
                        entry("status", "AT_RISK"),
                        entry("statusUpdateId", "x"),
                        entry("targetDate", "2024-05-01"));
    }
}
