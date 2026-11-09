package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.json.OptionalNull;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;

@UnitTest
class MoveProjectCardPayloadTest {

    @Test
    void constructor_shouldFail_whenCardIdIsNull() {
        final MoveProjectCardPayloadBuilder builder =
                MoveProjectCardPayloadBuilder.builder().columnId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("cardId must not be null");
    }

    @Test
    void constructor_shouldFail_whenColumnIdIsNull() {
        final MoveProjectCardPayloadBuilder builder =
                MoveProjectCardPayloadBuilder.builder().cardId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("columnId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final MoveProjectCardPayload input = MoveProjectCardPayloadBuilder.builder()
                .cardId("x")
                .columnId("x")
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("cardId", "x"), entry("columnId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final MoveProjectCardPayload input = MoveProjectCardPayloadBuilder.builder()
                .afterCardId(OptionalNull.of("x"))
                .cardId("x")
                .clientMutationId("x")
                .columnId("x")
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("afterCardId", "x"),
                        entry("cardId", "x"),
                        entry("clientMutationId", "x"),
                        entry("columnId", "x"));
    }

    @Test
    void toVariable_shouldSendNull_whenAfterCardIdIsExplicitlyNull() {
        final MoveProjectCardPayload input = MoveProjectCardPayloadBuilder.builder()
                .cardId("x")
                .columnId("x")
                .afterCardId(OptionalNull.ofNull())
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).containsEntry("afterCardId", null);
    }
}
