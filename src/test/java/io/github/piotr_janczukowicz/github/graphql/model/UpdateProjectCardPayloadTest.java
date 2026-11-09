package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateProjectCardPayloadTest {

    @Test
    void constructor_shouldFail_whenProjectCardIdIsNull() {
        final UpdateProjectCardPayloadBuilder builder = UpdateProjectCardPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectCardId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateProjectCardPayload input =
                UpdateProjectCardPayloadBuilder.builder().projectCardId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("projectCardId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateProjectCardPayload input = UpdateProjectCardPayloadBuilder.builder()
                .clientMutationId("x")
                .isArchived(true)
                .note("x")
                .projectCardId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("isArchived", true),
                        entry("note", "x"),
                        entry("projectCardId", "x"));
    }
}
