package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RequestReviewsByLoginPayloadTest {

    @Test
    void constructor_shouldFail_whenPullRequestIdIsNull() {
        final RequestReviewsByLoginPayloadBuilder builder = RequestReviewsByLoginPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pullRequestId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RequestReviewsByLoginPayload input =
                RequestReviewsByLoginPayloadBuilder.builder().pullRequestId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("pullRequestId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RequestReviewsByLoginPayload input = RequestReviewsByLoginPayloadBuilder.builder()
                .botLogins(List.of("x"))
                .clientMutationId("x")
                .pullRequestId("x")
                .teamSlugs(List.of("x"))
                .union(true)
                .userLogins(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("botLogins", List.of("x")),
                        entry("clientMutationId", "x"),
                        entry("pullRequestId", "x"),
                        entry("teamSlugs", List.of("x")),
                        entry("union", true),
                        entry("userLogins", List.of("x")));
    }
}
