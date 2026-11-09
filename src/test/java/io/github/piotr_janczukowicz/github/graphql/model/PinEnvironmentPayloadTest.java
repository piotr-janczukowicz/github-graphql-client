package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class PinEnvironmentPayloadTest {

    @Test
    void constructor_shouldFail_whenEnvironmentIdIsNull() {
        final PinEnvironmentPayloadBuilder builder =
                PinEnvironmentPayloadBuilder.builder().pinned(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("environmentId must not be null");
    }

    @Test
    void constructor_shouldFail_whenPinnedIsNull() {
        final PinEnvironmentPayloadBuilder builder =
                PinEnvironmentPayloadBuilder.builder().environmentId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pinned must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final PinEnvironmentPayload input = PinEnvironmentPayloadBuilder.builder()
                .environmentId("x")
                .pinned(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("environmentId", "x"), entry("pinned", true));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final PinEnvironmentPayload input = PinEnvironmentPayloadBuilder.builder()
                .clientMutationId("x")
                .environmentId("x")
                .pinned(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("environmentId", "x"), entry("pinned", true));
    }
}
