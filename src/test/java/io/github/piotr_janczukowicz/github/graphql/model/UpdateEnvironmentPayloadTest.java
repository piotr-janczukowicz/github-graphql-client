package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateEnvironmentPayloadTest {

    @Test
    void constructor_shouldFail_whenEnvironmentIdIsNull() {
        final UpdateEnvironmentPayloadBuilder builder = UpdateEnvironmentPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("environmentId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateEnvironmentPayload input =
                UpdateEnvironmentPayloadBuilder.builder().environmentId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("environmentId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateEnvironmentPayload input = UpdateEnvironmentPayloadBuilder.builder()
                .clientMutationId("x")
                .environmentId("x")
                .preventSelfReview(true)
                .reviewers(List.of("x"))
                .waitTimer(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("environmentId", "x"),
                        entry("preventSelfReview", true),
                        entry("reviewers", List.of("x")),
                        entry("waitTimer", 1));
    }
}
