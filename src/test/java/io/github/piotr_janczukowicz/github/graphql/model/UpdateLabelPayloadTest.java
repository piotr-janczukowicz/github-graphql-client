package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateLabelPayloadTest {

    @Test
    void constructor_shouldFail_whenIdIsNull() {
        final UpdateLabelPayloadBuilder builder = UpdateLabelPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("id must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateLabelPayload input =
                UpdateLabelPayloadBuilder.builder().id("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("id", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateLabelPayload input = UpdateLabelPayloadBuilder.builder()
                .clientMutationId("x")
                .color("x")
                .description("x")
                .id("x")
                .name("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("color", "x"),
                        entry("description", "x"),
                        entry("id", "x"),
                        entry("name", "x"));
    }
}
