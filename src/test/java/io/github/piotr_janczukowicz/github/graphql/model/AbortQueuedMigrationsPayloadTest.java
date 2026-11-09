package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AbortQueuedMigrationsPayloadTest {

    @Test
    void constructor_shouldFail_whenOwnerIdIsNull() {
        final AbortQueuedMigrationsPayloadBuilder builder = AbortQueuedMigrationsPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AbortQueuedMigrationsPayload input =
                AbortQueuedMigrationsPayloadBuilder.builder().ownerId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("ownerId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AbortQueuedMigrationsPayload input = AbortQueuedMigrationsPayloadBuilder.builder()
                .clientMutationId("x")
                .ownerId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("ownerId", "x"));
    }
}
