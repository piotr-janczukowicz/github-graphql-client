package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddPullRequestReviewPayloadTest {

    private static final String BODY = "body";

    @Test
    void constructor_shouldFail_whenPullRequestIdIsNull() {
        final AddPullRequestReviewPayloadBuilder builder = AddPullRequestReviewPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pullRequestId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddPullRequestReviewPayload input =
                AddPullRequestReviewPayloadBuilder.builder().pullRequestId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("pullRequestId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddPullRequestReviewPayload input = AddPullRequestReviewPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .comments(List.of(DraftPullRequestReviewCommentBuilder.builder()
                        .body("x")
                        .path("x")
                        .position(1)
                        .build()))
                .commitOID("x")
                .event(PullRequestReviewEvent.APPROVE)
                .pullRequestId("x")
                .threads(List.of(
                        DraftPullRequestReviewThreadBuilder.builder().body("x").build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry(BODY, "x"),
                        entry("clientMutationId", "x"),
                        entry(
                                "comments",
                                List.of(Map.ofEntries(entry(BODY, "x"), entry("path", "x"), entry("position", 1)))),
                        entry("commitOID", "x"),
                        entry("event", "APPROVE"),
                        entry("pullRequestId", "x"),
                        entry("threads", List.of(Map.ofEntries(entry(BODY, "x")))));
    }
}
