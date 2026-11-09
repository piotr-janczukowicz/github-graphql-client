package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddPullRequestReviewCommentPayloadTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddPullRequestReviewCommentPayload input =
                AddPullRequestReviewCommentPayloadBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddPullRequestReviewCommentPayload input = AddPullRequestReviewCommentPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .commitOID("x")
                .inReplyTo("x")
                .path("x")
                .position(1)
                .pullRequestId("x")
                .pullRequestReviewId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("commitOID", "x"),
                        entry("inReplyTo", "x"),
                        entry("path", "x"),
                        entry("position", 1),
                        entry("pullRequestId", "x"),
                        entry("pullRequestReviewId", "x"));
    }
}
