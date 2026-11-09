package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CloseDiscussionPayloadTest {

    @Test
    void constructor_shouldFail_whenDiscussionIdIsNull() {
        final CloseDiscussionPayloadBuilder builder = CloseDiscussionPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("discussionId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CloseDiscussionPayload input =
                CloseDiscussionPayloadBuilder.builder().discussionId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("discussionId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CloseDiscussionPayload input = CloseDiscussionPayloadBuilder.builder()
                .clientMutationId("x")
                .discussionId("x")
                .reason(DiscussionCloseReason.DUPLICATE)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("discussionId", "x"), entry("reason", "DUPLICATE"));
    }
}
