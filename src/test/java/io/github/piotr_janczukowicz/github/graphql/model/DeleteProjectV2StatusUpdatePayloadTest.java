package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DeleteProjectV2StatusUpdatePayloadTest {

    @Test
    void constructor_shouldFail_whenStatusUpdateIdIsNull() {
        final DeleteProjectV2StatusUpdatePayloadBuilder builder = DeleteProjectV2StatusUpdatePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("statusUpdateId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeleteProjectV2StatusUpdatePayload input = DeleteProjectV2StatusUpdatePayloadBuilder.builder()
                .statusUpdateId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("statusUpdateId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeleteProjectV2StatusUpdatePayload input = DeleteProjectV2StatusUpdatePayloadBuilder.builder()
                .clientMutationId("x")
                .statusUpdateId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("statusUpdateId", "x"));
    }
}
