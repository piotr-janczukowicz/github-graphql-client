package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateIssueTypePayloadTest {

    @Test
    void constructor_shouldFail_whenIssueTypeIdIsNull() {
        final UpdateIssueTypePayloadBuilder builder = UpdateIssueTypePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueTypeId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateIssueTypePayload input =
                UpdateIssueTypePayloadBuilder.builder().issueTypeId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("issueTypeId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateIssueTypePayload input = UpdateIssueTypePayloadBuilder.builder()
                .clientMutationId("x")
                .color(IssueTypeColor.BLUE)
                .description("x")
                .isEnabled(true)
                .issueTypeId("x")
                .name("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("color", "BLUE"),
                        entry("description", "x"),
                        entry("isEnabled", true),
                        entry("issueTypeId", "x"),
                        entry("name", "x"));
    }
}
