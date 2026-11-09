package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class LockLockablePayloadTest {

    @Test
    void constructor_shouldFail_whenLockableIdIsNull() {
        final LockLockablePayloadBuilder builder = LockLockablePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("lockableId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final LockLockablePayload input =
                LockLockablePayloadBuilder.builder().lockableId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("lockableId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final LockLockablePayload input = LockLockablePayloadBuilder.builder()
                .clientMutationId("x")
                .lockReason(LockReason.OFF_TOPIC)
                .lockableId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("lockReason", "OFF_TOPIC"), entry("lockableId", "x"));
    }
}
