package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateProjectColumnPayloadTest {

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final UpdateProjectColumnPayloadBuilder builder =
                UpdateProjectColumnPayloadBuilder.builder().projectColumnId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenProjectColumnIdIsNull() {
        final UpdateProjectColumnPayloadBuilder builder =
                UpdateProjectColumnPayloadBuilder.builder().name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectColumnId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateProjectColumnPayload input = UpdateProjectColumnPayloadBuilder.builder()
                .name("x")
                .projectColumnId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("name", "x"), entry("projectColumnId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateProjectColumnPayload input = UpdateProjectColumnPayloadBuilder.builder()
                .clientMutationId("x")
                .name("x")
                .projectColumnId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("name", "x"), entry("projectColumnId", "x"));
    }
}
