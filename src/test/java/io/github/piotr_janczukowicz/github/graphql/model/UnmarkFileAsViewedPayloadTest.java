package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UnmarkFileAsViewedPayloadTest {

    @Test
    void constructor_shouldFail_whenPathIsNull() {
        final UnmarkFileAsViewedPayloadBuilder builder =
                UnmarkFileAsViewedPayloadBuilder.builder().pullRequestId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("path must not be null");
    }

    @Test
    void constructor_shouldFail_whenPullRequestIdIsNull() {
        final UnmarkFileAsViewedPayloadBuilder builder =
                UnmarkFileAsViewedPayloadBuilder.builder().path("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pullRequestId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UnmarkFileAsViewedPayload input = UnmarkFileAsViewedPayloadBuilder.builder()
                .path("x")
                .pullRequestId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("path", "x"), entry("pullRequestId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UnmarkFileAsViewedPayload input = UnmarkFileAsViewedPayloadBuilder.builder()
                .clientMutationId("x")
                .path("x")
                .pullRequestId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("path", "x"), entry("pullRequestId", "x"));
    }
}
