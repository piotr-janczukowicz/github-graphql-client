package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ReorderEnvironmentPayloadTest {

    @Test
    void constructor_shouldFail_whenEnvironmentIdIsNull() {
        final ReorderEnvironmentPayloadBuilder builder =
                ReorderEnvironmentPayloadBuilder.builder().position(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("environmentId must not be null");
    }

    @Test
    void constructor_shouldFail_whenPositionIsNull() {
        final ReorderEnvironmentPayloadBuilder builder =
                ReorderEnvironmentPayloadBuilder.builder().environmentId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("position must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ReorderEnvironmentPayload input = ReorderEnvironmentPayloadBuilder.builder()
                .environmentId("x")
                .position(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("environmentId", "x"), entry("position", 1));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ReorderEnvironmentPayload input = ReorderEnvironmentPayloadBuilder.builder()
                .clientMutationId("x")
                .environmentId("x")
                .position(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("environmentId", "x"), entry("position", 1));
    }
}
