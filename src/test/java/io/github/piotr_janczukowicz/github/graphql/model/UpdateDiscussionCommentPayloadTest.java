package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateDiscussionCommentPayloadTest {

    @Test
    void constructor_shouldFail_whenBodyIsNull() {
        final UpdateDiscussionCommentPayloadBuilder builder =
                UpdateDiscussionCommentPayloadBuilder.builder().commentId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("body must not be null");
    }

    @Test
    void constructor_shouldFail_whenCommentIdIsNull() {
        final UpdateDiscussionCommentPayloadBuilder builder =
                UpdateDiscussionCommentPayloadBuilder.builder().body("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("commentId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateDiscussionCommentPayload input = UpdateDiscussionCommentPayloadBuilder.builder()
                .body("x")
                .commentId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("body", "x"), entry("commentId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateDiscussionCommentPayload input = UpdateDiscussionCommentPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .commentId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("body", "x"), entry("clientMutationId", "x"), entry("commentId", "x"));
    }
}
