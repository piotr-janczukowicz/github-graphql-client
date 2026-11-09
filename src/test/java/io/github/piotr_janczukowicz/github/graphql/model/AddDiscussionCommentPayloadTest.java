package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddDiscussionCommentPayloadTest {

    @Test
    void constructor_shouldFail_whenBodyIsNull() {
        final AddDiscussionCommentPayloadBuilder builder =
                AddDiscussionCommentPayloadBuilder.builder().discussionId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("body must not be null");
    }

    @Test
    void constructor_shouldFail_whenDiscussionIdIsNull() {
        final AddDiscussionCommentPayloadBuilder builder =
                AddDiscussionCommentPayloadBuilder.builder().body("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("discussionId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddDiscussionCommentPayload input = AddDiscussionCommentPayloadBuilder.builder()
                .body("x")
                .discussionId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("body", "x"), entry("discussionId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddDiscussionCommentPayload input = AddDiscussionCommentPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .discussionId("x")
                .replyToId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("discussionId", "x"),
                        entry("replyToId", "x"));
    }
}
