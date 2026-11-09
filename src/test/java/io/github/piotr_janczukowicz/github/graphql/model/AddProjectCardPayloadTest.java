package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddProjectCardPayloadTest {

    @Test
    void constructor_shouldFail_whenProjectColumnIdIsNull() {
        final AddProjectCardPayloadBuilder builder = AddProjectCardPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectColumnId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddProjectCardPayload input =
                AddProjectCardPayloadBuilder.builder().projectColumnId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("projectColumnId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddProjectCardPayload input = AddProjectCardPayloadBuilder.builder()
                .clientMutationId("x")
                .contentId("x")
                .note("x")
                .projectColumnId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("contentId", "x"),
                        entry("note", "x"),
                        entry("projectColumnId", "x"));
    }
}
