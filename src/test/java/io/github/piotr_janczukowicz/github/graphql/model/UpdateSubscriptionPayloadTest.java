package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateSubscriptionPayloadTest {

    @Test
    void constructor_shouldFail_whenStateIsNull() {
        final UpdateSubscriptionPayloadBuilder builder =
                UpdateSubscriptionPayloadBuilder.builder().subscribableId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("state must not be null");
    }

    @Test
    void constructor_shouldFail_whenSubscribableIdIsNull() {
        final UpdateSubscriptionPayloadBuilder builder =
                UpdateSubscriptionPayloadBuilder.builder().state(SubscriptionState.IGNORED);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("subscribableId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateSubscriptionPayload input = UpdateSubscriptionPayloadBuilder.builder()
                .state(SubscriptionState.IGNORED)
                .subscribableId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("state", "IGNORED"), entry("subscribableId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateSubscriptionPayload input = UpdateSubscriptionPayloadBuilder.builder()
                .clientMutationId("x")
                .state(SubscriptionState.IGNORED)
                .subscribableId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("state", "IGNORED"), entry("subscribableId", "x"));
    }
}
