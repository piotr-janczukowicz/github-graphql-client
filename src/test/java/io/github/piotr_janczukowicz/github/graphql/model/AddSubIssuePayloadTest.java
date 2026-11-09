package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddSubIssuePayloadTest {

    @Test
    void constructor_shouldFail_whenIssueIdIsNull() {
        final AddSubIssuePayloadBuilder builder = AddSubIssuePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddSubIssuePayload input =
                AddSubIssuePayloadBuilder.builder().issueId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("issueId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddSubIssuePayload input = AddSubIssuePayloadBuilder.builder()
                .clientMutationId("x")
                .issueId("x")
                .replaceParent(true)
                .subIssueId("x")
                .subIssueUrl("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("issueId", "x"),
                        entry("replaceParent", true),
                        entry("subIssueId", "x"),
                        entry("subIssueUrl", "x"));
    }
}
