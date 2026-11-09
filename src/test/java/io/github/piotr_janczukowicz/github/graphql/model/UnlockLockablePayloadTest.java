package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UnlockLockablePayloadTest {

    @Test
    void constructor_shouldFail_whenLockableIdIsNull() {
        final UnlockLockablePayloadBuilder builder = UnlockLockablePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("lockableId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UnlockLockablePayload input =
                UnlockLockablePayloadBuilder.builder().lockableId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("lockableId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UnlockLockablePayload input = UnlockLockablePayloadBuilder.builder()
                .clientMutationId("x")
                .lockableId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("lockableId", "x"));
    }
}
