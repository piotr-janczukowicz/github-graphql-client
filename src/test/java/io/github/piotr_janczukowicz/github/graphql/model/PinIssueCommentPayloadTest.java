package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class PinIssueCommentPayloadTest {

    @Test
    void constructor_shouldFail_whenIssueCommentIdIsNull() {
        final PinIssueCommentPayloadBuilder builder = PinIssueCommentPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueCommentId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final PinIssueCommentPayload input =
                PinIssueCommentPayloadBuilder.builder().issueCommentId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("issueCommentId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final PinIssueCommentPayload input = PinIssueCommentPayloadBuilder.builder()
                .clientMutationId("x")
                .issueCommentId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("issueCommentId", "x"));
    }
}
