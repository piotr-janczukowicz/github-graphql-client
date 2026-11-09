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
class MoveProjectColumnPayloadTest {

    @Test
    void constructor_shouldFail_whenColumnIdIsNull() {
        final MoveProjectColumnPayloadBuilder builder = MoveProjectColumnPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("columnId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final MoveProjectColumnPayload input =
                MoveProjectColumnPayloadBuilder.builder().columnId("x").build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("columnId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final MoveProjectColumnPayload input = MoveProjectColumnPayloadBuilder.builder()
                .afterColumnId(OptionalNull.of("x"))
                .clientMutationId("x")
                .columnId("x")
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("afterColumnId", "x"), entry("clientMutationId", "x"), entry("columnId", "x"));
    }

    @Test
    void toVariable_shouldSendNull_whenAfterColumnIdIsExplicitlyNull() {
        final MoveProjectColumnPayload input = MoveProjectColumnPayloadBuilder.builder()
                .columnId("x")
                .afterColumnId(OptionalNull.ofNull())
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).containsEntry("afterColumnId", null);
    }
}
