package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateProjectPayloadTest {

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final UpdateProjectPayloadBuilder builder = UpdateProjectPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateProjectPayload input =
                UpdateProjectPayloadBuilder.builder().projectId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateProjectPayload input = UpdateProjectPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .name("x")
                .projectId("x")
                .publicValue(true)
                .state(ProjectState.CLOSED)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("name", "x"),
                        entry("projectId", "x"),
                        entry("public", true),
                        entry("state", "CLOSED"));
    }
}
