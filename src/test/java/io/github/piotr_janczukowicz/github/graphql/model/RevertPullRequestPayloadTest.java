package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RevertPullRequestPayloadTest {

    @Test
    void constructor_shouldFail_whenPullRequestIdIsNull() {
        final RevertPullRequestPayloadBuilder builder = RevertPullRequestPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pullRequestId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RevertPullRequestPayload input =
                RevertPullRequestPayloadBuilder.builder().pullRequestId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("pullRequestId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RevertPullRequestPayload input = RevertPullRequestPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .draft(true)
                .pullRequestId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("draft", true),
                        entry("pullRequestId", "x"),
                        entry("title", "x"));
    }
}
