package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ChangeUserStatusPayloadTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ChangeUserStatusPayload input =
                ChangeUserStatusPayloadBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ChangeUserStatusPayload input = ChangeUserStatusPayloadBuilder.builder()
                .clientMutationId("x")
                .emoji("x")
                .expiresAt(Instant.parse("2024-05-01T10:15:30Z"))
                .limitedAvailability(true)
                .message("x")
                .organizationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("emoji", "x"),
                        entry("expiresAt", "2024-05-01T10:15:30Z"),
                        entry("limitedAvailability", true),
                        entry("message", "x"),
                        entry("organizationId", "x"));
    }
}
