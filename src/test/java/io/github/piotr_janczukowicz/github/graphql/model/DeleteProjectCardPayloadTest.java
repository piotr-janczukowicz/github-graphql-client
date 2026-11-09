package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DeleteProjectCardPayloadTest {

    @Test
    void constructor_shouldFail_whenCardIdIsNull() {
        final DeleteProjectCardPayloadBuilder builder = DeleteProjectCardPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("cardId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeleteProjectCardPayload input =
                DeleteProjectCardPayloadBuilder.builder().cardId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("cardId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeleteProjectCardPayload input = DeleteProjectCardPayloadBuilder.builder()
                .cardId("x")
                .clientMutationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("cardId", "x"), entry("clientMutationId", "x"));
    }
}
