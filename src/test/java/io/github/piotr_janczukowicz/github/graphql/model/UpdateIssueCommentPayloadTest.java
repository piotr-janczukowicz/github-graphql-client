package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateIssueCommentPayloadTest {

    @Test
    void constructor_shouldFail_whenBodyIsNull() {
        final UpdateIssueCommentPayloadBuilder builder =
                UpdateIssueCommentPayloadBuilder.builder().id("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("body must not be null");
    }

    @Test
    void constructor_shouldFail_whenIdIsNull() {
        final UpdateIssueCommentPayloadBuilder builder =
                UpdateIssueCommentPayloadBuilder.builder().body("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("id must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateIssueCommentPayload input =
                UpdateIssueCommentPayloadBuilder.builder().body("x").id("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("body", "x"), entry("id", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateIssueCommentPayload input = UpdateIssueCommentPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .id("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("body", "x"), entry("clientMutationId", "x"), entry("id", "x"));
    }
}
