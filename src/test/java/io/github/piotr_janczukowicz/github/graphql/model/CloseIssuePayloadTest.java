package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CloseIssuePayloadTest {

    @Test
    void constructor_shouldFail_whenIssueIdIsNull() {
        final CloseIssuePayloadBuilder builder = CloseIssuePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CloseIssuePayload input =
                CloseIssuePayloadBuilder.builder().issueId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("issueId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CloseIssuePayload input = CloseIssuePayloadBuilder.builder()
                .clientMutationId("x")
                .confidence(IssueEventConfidenceLevel.HIGH)
                .duplicateIssueId("x")
                .isSuggestion(true)
                .issueId("x")
                .rationale("x")
                .stateReason(IssueClosedStateReason.COMPLETED)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("confidence", "HIGH"),
                        entry("duplicateIssueId", "x"),
                        entry("isSuggestion", true),
                        entry("issueId", "x"),
                        entry("rationale", "x"),
                        entry("stateReason", "COMPLETED"));
    }
}
