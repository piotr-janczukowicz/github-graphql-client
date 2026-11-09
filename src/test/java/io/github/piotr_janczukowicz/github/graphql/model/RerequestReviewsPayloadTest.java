package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RerequestReviewsPayloadTest {

    @Test
    void constructor_shouldFail_whenPullRequestIdIsNull() {
        final RerequestReviewsPayloadBuilder builder = RerequestReviewsPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pullRequestId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RerequestReviewsPayload input =
                RerequestReviewsPayloadBuilder.builder().pullRequestId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("pullRequestId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RerequestReviewsPayload input = RerequestReviewsPayloadBuilder.builder()
                .botIds(List.of("x"))
                .clientMutationId("x")
                .pullRequestId("x")
                .teamIds(List.of("x"))
                .userIds(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("botIds", List.of("x")),
                        entry("clientMutationId", "x"),
                        entry("pullRequestId", "x"),
                        entry("teamIds", List.of("x")),
                        entry("userIds", List.of("x")));
    }
}
