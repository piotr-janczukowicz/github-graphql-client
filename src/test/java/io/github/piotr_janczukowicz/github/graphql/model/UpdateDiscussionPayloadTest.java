package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateDiscussionPayloadTest {

    @Test
    void constructor_shouldFail_whenDiscussionIdIsNull() {
        final UpdateDiscussionPayloadBuilder builder = UpdateDiscussionPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("discussionId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateDiscussionPayload input =
                UpdateDiscussionPayloadBuilder.builder().discussionId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("discussionId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateDiscussionPayload input = UpdateDiscussionPayloadBuilder.builder()
                .body("x")
                .categoryId("x")
                .clientMutationId("x")
                .discussionId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("categoryId", "x"),
                        entry("clientMutationId", "x"),
                        entry("discussionId", "x"),
                        entry("title", "x"));
    }
}
